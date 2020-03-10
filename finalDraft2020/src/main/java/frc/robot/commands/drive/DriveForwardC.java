package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveForwardC extends Command {
  //Creating variables
  private double power;
  private double time;


  /**
   * Command for driving in a line at a set speed for a certain amount of time.
   * (May not be perfectly straight since drive is lacking a PID controller.)
   * @param power The power that you want the robot to run at.
   * @param time The time (in seconds) that you want the robot to run for.
   */
  public DriveForwardC(double power, double time) {
    //This command requires the drivebase subsystem.
    requires(Robot.mDriveS);

    //setting the class variables to be equal to the perameters.
    this.power = power;
    this.time = time;
  }

  @Override
  protected void initialize() {
    //sets the timeout to the time permeter.
    setTimeout(time);
  }

  @Override
  protected void execute() {
    //sets the power of the motors to the power perameter.
    Robot.mDriveS.tankDrive(power, power, 1.0);
  }

  @Override
  protected boolean isFinished() {
    //Returns true if the timeout has passed.
    return isTimedOut();
  }

  @Override
  protected void end() {
    //stops the motors when the command ends.
    Robot.mDriveS.tankDrive(0.0, 0.0, 0.0);
  }

  @Override
  protected void interrupted() {
    //DO NOT CALL END IN INTERRUPRED, this would cause an ubrupt stop when trying to drive the robot while this is running.
  }
}