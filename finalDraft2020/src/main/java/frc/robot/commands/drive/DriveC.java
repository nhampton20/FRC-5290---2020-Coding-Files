package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class DriveC extends Command{
    public double leftSpeed = 0.0;
    public double rightSpeed = 0.0;
    public double throttle = 0.0;

    public DriveC(){
        requires(Robot.mDriveS);
    }
    @Override
    protected void initialize(){
        Robot.mDriveS.tankDrive(0, 0, 0);
    }
    @Override
    protected void execute(){
        leftSpeed = Robot.mOI.lJoystick.axisY();
        rightSpeed = Robot.mOI.rJoystick.axisY();
        throttle  = Robot.mOI.rJoystick.throttle();
        SmartDashboard.putNumber("Throttle", throttle);
        Robot.mDriveS.tankDrive(leftSpeed, rightSpeed, throttle);
    }
    @Override
    protected boolean isFinished(){
        return false;
    }
    @Override
    protected void end(){
        //Robot.mDriveS.tankDrive(0, 0, 0);
    }
    @Override
    protected void interrupted(){
        end();
    }

}