package frc.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.Spark;


public class EnergyIntakeS extends Subsystem{
    public Spark intakeMotor;

    @Override
    protected void initDefaultCommand(){
    }

    public EnergyIntakeS (){
        intakeMotor = new Spark(RobotMap.intake);
    }

    public void setSpeed(double speed){
        intakeMotor.set(speed);
    }
}