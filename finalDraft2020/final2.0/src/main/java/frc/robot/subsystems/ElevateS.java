package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Spark;

public class ElevateS extends Subsystem {

    Spark climbMotor;

    public ElevateS(){
        climbMotor = new Spark(RobotMap.elevator);
    }

    @Override
    public void initDefaultCommand(){

    }
    public void setSpeed(double speed){
        climbMotor.set(speed);
    }
    
}