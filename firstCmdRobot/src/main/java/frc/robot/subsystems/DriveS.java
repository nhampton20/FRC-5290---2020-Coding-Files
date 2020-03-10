package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
import frc.robot.commands.drive.DriveForwardC;
import java.lang.Math;

public class DriveS extends Subsystem {

    private Spark FL = null;
    private Spark RL = null;
    private Spark FR = null;
    private Spark RR = null;

    private DifferentialDrive differentialDrive = null;

    public void initDefaultCommand(){
        setDefaultCommand(new DriveForwardC(0.0, 0.0));
    }
    public DriveS(){
        FL = new Spark(RobotMap.frontL);
        RL = new Spark(RobotMap.rearL);
        FR = new Spark(RobotMap.frontR);
        RR = new Spark(RobotMap.rearR);

        SpeedControllerGroup leftDriveMotors = new SpeedControllerGroup(FL, RL);
        SpeedControllerGroup rightDriveMotors = new SpeedControllerGroup(FR, RR);

        differentialDrive = new DifferentialDrive(leftDriveMotors, rightDriveMotors);
    }

    public void tankDrive(double leftSpeed, double rightSpeed, double throttle){
        throttle=(throttle+1)/2;
        differentialDrive.tankDrive(-leftSpeed * throttle, -rightSpeed * throttle);
        SmartDashboard.putNumber("Throttle", throttle);

    }

    public void visionDrive(double leftSpeed, double rightSpeed) {
        FL.set(leftSpeed);
        FR.set(rightSpeed);
      }
}