package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.mapping.Xbox;

public class LaunchC extends Command {

    private double speed = 0.0;
    private boolean pause = false;
    
    public LaunchC() {
        requires(Robot.mLaunchS);
    }

    public LaunchC(double speed){
        this();
        this.speed = speed;
    }

    public LaunchC(double speed, boolean pause){
        this();
        this.pause=pause;
        this.speed=speed;
    }

    @Override
    protected void initialize(){
        this.setTimeout(3);
    }

    @Override
    protected void execute(){
        if (!pause){
            Robot.mLaunchS.setSpeed(speed);
        }
        //speed=Xbox.xbox.getTriggerAxis(Hand.kRight);
    }
@Override
    protected boolean isFinished(){
        return isTimedOut();
    }
    @Override
    protected void end(){
        Robot.mLaunchS.setSpeed(0.0);
    }
    @Override
    protected void interrupted(){
        end();
    }
    public void togglePause(){
        pause=!pause;
    }
    public boolean isPaused(){
        return pause;
    }
} 