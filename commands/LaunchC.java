package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LaunchC extends Command {

    private double speed = 1.0;
    
    public LaunchC() {
        requires(Robot.mLaunchS);
    }

    public LaunchC(double speed){
        this();
        this.speed = speed;
    }
    @Override
    protected void initialize(){
        this.setTimeout(10);
        Robot.mLaunchS.blockBall(DoubleSolenoid.Value.valueOf("kForward"));
    }

    @Override
    protected void execute(){

        Robot.mLaunchS.setSpeed(speed);
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
}