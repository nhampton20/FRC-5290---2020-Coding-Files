package frc.robot.commands.limelight;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.RobotMap;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
/**
 * IMPORTANT!!! MAKE SURE "IGNORE NETWORK TABLES" IS SET TO FALSE.
 * To verify, connect to the limelight through the web interface and look for a button in the top middle
 */
public class VisionAlignTarget extends Command {
  //Network tables
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry txEntry = table.getEntry("tx");
  NetworkTableEntry tyEntry = table.getEntry("ty");
  NetworkTableEntry tvEntry = table.getEntry("tv");
  NetworkTableEntry ledMode = table.getEntry(("ledMode"));
  NetworkTableEntry pipelineEntry = table.getEntry("pipeline");
  NetworkTableEntry camMode = table.getEntry("camMode");

  //CONSTANTS
  //Change these if the align method is going too fast or too slow (or is oscilating)
  double KpAim = -0.005f;
  double KpDistance = -0.03f;
  double max_power = 1.0; //clamp
  double rampTime = 0.25; //seconds
  double minCommand = 0.05;

  //Change these if the align method is stopping too soon or not soon enough
  double xRange = 1; //degrees
  double yRange = 0; //degrees
  double waitInRange = 10; //cycles

  //Variables that are set within the command
  double tx= 0.0;
  double ty = 0.0;
  double ta = 0.0;
  double tv = 0.0;
  double steering_adjust = 0.0;
  double distance_adjust = 0.0;
  double pipeline = 0.0;

  boolean firstLoop = true;
  boolean pause = false;

  double clampValue = 0;
  double heading_error = 0;
  double distance_error = 0;

  int sumInRange = 0;

  Timer rampTimer = new Timer();

  double leftCommand = 0.0;
  double rightCommand = 0.0;


  public VisionAlignTarget() {
    requires(Robot.mDriveS);
    requires(Robot.mLimeLight);
    pipelineEntry.setDouble(RobotMap.NO_TRACKING); //Normal camera
    ledMode.setDouble(0); //Leds off

    //Puts constants on smart dashboard
    SmartDashboard.putNumber("kpAim", KpAim);
    SmartDashboard.putNumber("kpDistance", KpDistance);
    SmartDashboard.putNumber("max_power", max_power);
    SmartDashboard.putNumber("xRange", xRange);
    SmartDashboard.putNumber("yRange", yRange);
    SmartDashboard.putNumber("waitInRange", waitInRange);

  }
  public VisionAlignTarget(boolean pause){
    this();
    this.pause=pause;
  }

  @Override
  protected void initialize() {
    //To interrupt this command, use the toggle feature
    this.setInterruptible(true); //Prevents drivebase from overriding this command.
    firstLoop = true;
  }

  @Override
  protected void execute() {
    if(!pause){
    //Rumbles the controller to let the driver know he doesn't have drivebase control
    //Robot.m_oi.xbox.setRumble(0.2);

    //Only runs on the first excecute loop
    if(firstLoop) {
      //Starts the power ramp up timer
      rampTimer.reset();
      rampTimer.start();

      firstLoop = false;
    }
    
      pipelineEntry.setDouble(RobotMap.TRACKING);
    
    

    //Force the limelight LED on
    ledMode.setDouble(3);

    //Get offsets from limelight
    tx = txEntry.getDouble(0.0);
    ty = tyEntry.getDouble(0.0);
    tv = tvEntry.getDouble(0.0);

    SmartDashboard.putNumber("Vision Heading error", heading_error);
    SmartDashboard.putNumber("Vision Distance error", distance_error);
    SmartDashboard.putNumber("RampTimer", rampTimer.get());

    //Pull control constants from smartdashboard. COMMENT WHEN WE ARE DONE TESTING
    KpAim = SmartDashboard.getNumber("kpAim", KpAim);
    KpDistance = SmartDashboard.getNumber("kpDistance", KpDistance);
    max_power = SmartDashboard.getNumber("max_power", max_power);
    xRange = SmartDashboard.getNumber("xRange", xRange);
    yRange = SmartDashboard.getNumber("yRange", yRange);
    waitInRange = SmartDashboard.getNumber("waitInRange", waitInRange);

    if (tv == 0.0){
      steering_adjust=0.3;
    }
    else if (tv != 0.0 && ty != 0.0){
      distance_adjust= KpDistance * distance_error;

      leftCommand += distance_adjust;
      rightCommand += distance_adjust;
    }
    else if (tv != 0.0 && ty == 0.0){
      heading_error = -tx;
      steering_adjust = 0.0;
      if (tx > 1.0)
        steering_adjust = KpAim*heading_error - minCommand;
      else if(tx < 1.0)
        steering_adjust = KpAim*heading_error + minCommand;

      leftCommand += steering_adjust;
      rightCommand -= steering_adjust;
      

    }


    //Ramps our PID to full over the period of ramp time
    clampValue = clamp(rampTimer.get()/rampTime, 1) * max_power;

    //Enforces the max power
    steering_adjust = clamp(steering_adjust, clampValue);
    distance_adjust = clamp(distance_adjust, clampValue);

    SmartDashboard.putNumber("Vision Steer Adj", steering_adjust);
    SmartDashboard.putNumber("Vision Dist Adj", distance_adjust);

    Robot.mDriveS.visionDrive(leftCommand, rightCommand);
    System.out.println("AlignTarget activating");
  }
  }

  @Override
  protected boolean isFinished() {
    //If we are within range, begin to add to the sumInRange command
    SmartDashboard.putNumber("sumInRange", sumInRange);
    if (Math.abs(tx) <= xRange && Math.abs(ty) <= yRange) {
      sumInRange+=1;
    } else {
      sumInRange = 0;
    }

    //If we are aligned, end the command
    if (sumInRange>waitInRange){
      sumInRange = 0;
      return true;
    } else {
      return false;
    }
    
  }

  @Override
  protected void end() {
    //Resets things
    rampTimer.stop();
    firstLoop = true;
    pipelineEntry.setDouble(RobotMap.NO_TRACKING);
    ledMode.setDouble(0);
  }

  @Override
  protected void interrupted() {
  }

  //Clamps a value between -mag and +mag
  private static double clamp(double val, double mag) {
    return Math.max(-mag, Math.min(mag, val));
  }
  /**
   * Toggles the Command.
   * @param
   */
  public void togglePause(){
    pause=!pause;
  }
  public boolean isPaused(){
    return pause;
  }
}
