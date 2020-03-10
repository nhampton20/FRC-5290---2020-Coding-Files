package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class UnlockC extends Command{

    public UnlockC(){
        requires(Robot.mLockS);
    }

    @Override
    protected void initialize(){
    }

    @Override
    protected void execute(){
        Robot.mLockS.elevateLockSet(true);
        DriverStation.reportWarning("Unlocking!",false);
    }

    @Override
    protected boolean isFinished(){
        return true;
    }
    @Override
    protected void end(){
    }
    @Override
    protected void interrupted(){

    }
}