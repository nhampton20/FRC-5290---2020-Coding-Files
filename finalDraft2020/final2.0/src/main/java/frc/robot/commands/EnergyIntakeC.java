package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class EnergyIntakeC extends Command{

    private double speed = 0.0;
    private boolean pause = false;

    public EnergyIntakeC(){
        requires(Robot.mEnergyIntakeS);
    }
    public EnergyIntakeC(double speed){
        this();
        this.speed = -speed;
    }
    public EnergyIntakeC(double speed, boolean pause){
        this();
        this.speed = -speed;
        this.pause = pause;
    }
    @Override
    protected void initialize(){
        this.setTimeout(2);
    }

    @Override
    protected void execute(){
        if(!pause){
        Robot.mEnergyIntakeS.setSpeed(speed);
        //speed = Robot.mOI.xbox.leftTrigger();
        }
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
    public void togglePause(){
        pause = !pause;
    }
    public boolean isPaused(){
        return pause;
    }
}