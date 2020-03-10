package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LockC extends Command{

    public LockC(){
        requires(Robot.mLockS);
    }

    @Override
    protected void initialize(){
    }

    @Override
    protected void execute(){
        Robot.mLockS.elevateLockSet(false);
        DriverStation.reportWarning("Locking!",false);
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