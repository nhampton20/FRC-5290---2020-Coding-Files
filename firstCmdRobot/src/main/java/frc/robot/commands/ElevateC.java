package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ElevateC extends Command{

    private double speed = 1.0;
    public ElevateC(){
        requires(Robot.mEnergyIntakeS);
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
        if (Robot.mElavateS.dSolenoidState()==Value.kForward)
            return true;
        else
            return false;
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
