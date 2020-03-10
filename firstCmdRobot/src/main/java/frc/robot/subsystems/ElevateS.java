package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;

public class ElevateS extends Subsystem {

    Spark climbMotor;
    DoubleSolenoid climbDSolenoid;

    public ElevateS(){
        climbDSolenoid = new DoubleSolenoid(RobotMap.dSolenoidClimbForward, RobotMap.dSolenoidCLimbBackward);
        climbMotor = new Spark(RobotMap.elevator);
    }

    @Override
    public void initDefaultCommand(){

    }
    public void setSpeed(double speed){
        climbMotor.set(speed);
    }
    public DoubleSolenoid.Value dSolenoidState(){
        return climbDSolenoid.get();
    }
    public void elevateLockSet( DoubleSolenoid.Value k){
        climbDSolenoid.set(k);
    }
}