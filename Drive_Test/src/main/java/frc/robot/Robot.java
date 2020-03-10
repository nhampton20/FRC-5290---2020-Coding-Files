package frc.robot;

//java.lang.Math; /*I think this won’t need to be imported, but it’s here just in case*/
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SPI.Port;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

public class Robot extends TimedRobot {
  
  //Joysticks!
  final int joyN1 = 0;
  final int joyN2 = 1;
  Joystick joy1 = new Joystick(joyN1);
  Joystick joy2 = new Joystick(joyN2);
  
  //Motors
  SpeedControllerGroup leftSide;
  SpeedControllerGroup rightSide;
  DifferentialDrive drive;

  final int frontLeftChannel = 3;
  Talon frontLeft;
  final int backLeftChannel = 2;
  Talon backLeft;
  final int frontRightChannel = 1;
  Talon frontRight;
  final int backRightChannel = 0;
  Talon backRight;
  
  
  //Acceleration Control Method
  double lastSpeedL = 0;
  double lastSpeedR = 0;
  public double accelCont(double speedNow, double speedLast){
    double c = speedNow - speedLast;
    double maxC = 0.08;
    if(c > maxC){
      return maxC + speedLast;
    } else if(c < -1*maxC){
      return -1*maxC + speedLast;
    } else {
      return speedNow;
    }
  }
  
  
  //Gyro Base Turning Functions and Stuff
  ADXRS450_Gyro gyro;
  double maxTwist = 1.0;
  double thresholdAngle = 2.0;
  boolean thereAngle = false;
  
  /**
   * This function is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    //Gyroscope!
    gyro = new ADXRS450_Gyro(Port.kOnboardCS0);

    //Motors and Drive Controls
    frontLeft = new Talon(frontLeftChannel);
    backLeft = new Talon(backLeftChannel);
    frontRight = new Talon(frontRightChannel);
    backRight = new Talon(backRightChannel);
			
    rightSide = new SpeedControllerGroup(frontLeft, backLeft);
    leftSide = new SpeedControllerGroup(frontRight, backRight);
    leftSide.setInverted(false);
    rightSide.setInverted(false);
    drive = new DifferentialDrive(leftSide, rightSide);
  }

  /**
   * This function is called every robot packet, no matter the mode. Use
   * this for items like diagnostics that you want ran during disabled,
   * autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before
   * LiveWindow and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
  }

  /**
   * This autonomous (along with the chooser code above) shows how to select
   * between different autonomous modes using the dashboard. The sendable
   * chooser code works with the Java SmartDashboard. If you prefer the
   * LabVIEW Dashboard, remove all of the chooser code and uncomment the
   * getString line to get the auto name from the text box below the Gyro
   *
   * <p>You can add additional auto modes by adding additional comparisons to
   * the switch structure below with additional strings. If using the
   * SendableChooser make sure to add them to the chooser code above as well.
   */
  @Override
  public void autonomousInit() {
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    lastSpeedL = accelCont(joy1.getY(),lastSpeedL);
    lastSpeedR = accelCont(joy2.getY(),lastSpeedR);
    double precentSpeed = (((joy1.getThrottle())-1.0)/(-2.0));
    drive.tankDrive((lastSpeedL/precentSpeed),(lastSpeedR/precentSpeed));
  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}

