package frc.robot.subsystems;

import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

public class LaunchS extends Subsystem {
    Spark rightLaunchMotor;
    Spark leftLaunchMotor;
    DoubleSolenoid block;
    SpeedControllerGroup launch;
    public LaunchS (){
        rightLaunchMotor = new Spark(RobotMap.launchR);
        leftLaunchMotor = new Spark(RobotMap.launchL);
        rightLaunchMotor.setInverted(true);
        block = new DoubleSolenoid(RobotMap.dSolenoidBallForward, RobotMap.dSolenoidBallBackward);
        launch = new SpeedControllerGroup(leftLaunchMotor, rightLaunchMotor);
    }

    @Override
    public void initDefaultCommand(){

    }
    public void setSpeed(double speed){
        launch.set(-speed);
    }
    public DoubleSolenoid.Value dSolenoidState(){
        return block.get();
    }
    public void blockBall(DoubleSolenoid.Value k){
        block.set(k);
    }

}