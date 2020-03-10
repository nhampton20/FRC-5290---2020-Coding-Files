package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ElevateC extends Command{

    private double speed = 1.0;
    private double time = 0.1;
    public ElevateC(){
        requires(Robot.mElevateS);
    }
    public ElevateC(double speed, double time){
        this();
        this.speed=speed;
        this.time=time;
    }
    @Override
    protected void initialize(){
        this.setTimeout(time);
    }

    @Override
    protected void execute(){
        Robot.mElevateS.setSpeed(speed);
    }
    @Override
    protected boolean isFinished(){
        if (isTimedOut())
            return true;
        else
            return false;
    }
    @Override
    protected void end(){
        Robot.mElevateS.setSpeed(0.0);
    }
    @Override
    protected void interrupted(){
        end();
    }
}
