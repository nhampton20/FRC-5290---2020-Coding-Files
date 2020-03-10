package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.DriveTrain_TankDrive;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
	
	Spark leftMotor = new Spark(RobotMap.fl);
    Spark rightMotor = new Spark(RobotMap.fr);
    Spark leftRear = new Spark(RobotMap.rl);
    Spark rightRear = new Spark(RobotMap.rr);
    SpeedControllerGroup left = new SpeedControllerGroup(leftMotor, leftRear);
    SpeedControllerGroup right = new SpeedControllerGroup(rightMotor, rightRear);
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveTrain_TankDrive());
    }
	
	public void setMotors(double left, double right) {
    	left = scaleLeft(left);
    	right = scaleRight(right);
    	
    	setMotorsRaw(left, right);
    }
    
    public void setMotorsRaw(double left, double right) {

    	this.left.set(left);
    	this.right.set(right);		
	}
    
    
    private double scaleLeft(double left) {
    	return 1.0 * left;
    }
    
    private double scaleRight(double right) {
    	return 1.0 * right;
    }
}

