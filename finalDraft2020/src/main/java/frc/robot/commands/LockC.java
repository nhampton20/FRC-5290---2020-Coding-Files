package frc.robot.commands;

// import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LockC extends Command{

    public LockC(){
        requires(Robot.mLockS);
    }

    @Override
    protected void initialize(){
        Robot.mLockS.elevateLockSet(false);
        DriverStation.reportWarning("Locking!", false);
    }

    @Override
    protected void execute(){
        System.out.println("Testing");
    }

    @Override
    protected boolean isFinished(){
        return true;
    }
    @Override
    protected void end(){
        Robot.mLockS.elevateLockSet(false);
    }
    @Override
    protected void interrupted(){

    }
}