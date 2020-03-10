package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class EnergyIntakeC extends Command{

    private double speed = -0.5;
    public EnergyIntakeC(){
        requires(Robot.mEnergyIntakeS);
    }
    public EnergyIntakeC(double speed){
        this();
        this.speed = -speed;
    }
    @Override
    protected void initialize(){
        this.setTimeout(10);
    }

    @Override
    protected void execute(){
        Robot.mEnergyIntakeS.setSpeed(speed);
    }
    @Override
    protected boolean isFinished(){
        return isTimedOut();
    }
    @Override
    protected void end(){
        Robot.mEnergyIntakeS.setSpeed(0.0);
    }
    @Override
    protected void interrupted(){
        end();
    }
}