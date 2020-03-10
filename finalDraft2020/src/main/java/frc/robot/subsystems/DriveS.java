package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.ADXRS450_Gyro;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.RobotMap;
//import frc.robot.commands.drive.DriveForwardC;
import frc.robot.commands.drive.DriveC;

public class DriveS extends Subsystem {

    private Spark FL = null;
    private Spark RL = null;
    private Spark FR = null;
    private Spark RR = null;

    SpeedControllerGroup leftDriveMotors = null;
    SpeedControllerGroup rightDriveMotors = null;

    private DifferentialDrive differentialDrive = null;
    private ADXRS450_Gyro Gyroscope = null;

    public void initDefaultCommand(){
        setDefaultCommand(new DriveC());
    }
    public DriveS(){
        FL = new Spark(RobotMap.frontL);
        RL = new Spark(RobotMap.rearL);
        FR = new Spark(RobotMap.frontR);
        RR = new Spark(RobotMap.rearR);

         leftDriveMotors = new SpeedControllerGroup(FL, RL);
        rightDriveMotors = new SpeedControllerGroup(FR, RR);
        
        Gyroscope = new ADXRS450_Gyro();

        differentialDrive = new DifferentialDrive(leftDriveMotors, rightDriveMotors);
    }

    public void tankDrive(double leftSpeed, double rightSpeed, double throttle){
        throttle = (throttle+1)/2;
        differentialDrive.tankDrive(-leftSpeed * throttle, -rightSpeed * throttle);
        SmartDashboard.putNumber("Throttle", throttle);

    }

    public void visionDrive(double leftSpeed, double rightSpeed) {
        leftDriveMotors.set(leftSpeed);
        rightDriveMotors.set(rightSpeed);
      }
      public double gyroAngle(){
          return Gyroscope.getAngle();
      }
}