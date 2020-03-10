package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

public class LockS extends Subsystem{

    DoubleSolenoid climbDSolenoid;

    public LockS(){
        climbDSolenoid = new DoubleSolenoid(RobotMap.dSolenoidClimbForward, RobotMap.dSolenoidCLimbBackward);
    }

    @Override
    public void initDefaultCommand(){

    }

    public DoubleSolenoid.Value dSolenoidState(){
        return climbDSolenoid.get();
    }
    public void elevateLockSet(boolean locked){
        if(locked){
            climbDSolenoid.set(Value.kForward);
        }
        else{
            climbDSolenoid.set(Value.kReverse);
        }
    }

}