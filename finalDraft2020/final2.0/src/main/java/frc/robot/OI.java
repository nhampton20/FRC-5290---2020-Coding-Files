package frc.robot;

import frc.robot.mapping.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.limelight.*;
import frc.robot.commands.LaunchC;
import frc.robot.commands.LockC;
import frc.robot.commands.UnlockC;
import frc.robot.commands.ElevateC;
import frc.robot.commands.EnergyIntakeC;

//import edu.wpi.first.wpilibj.Joystick;

public class OI {
    public final rJStick rJoystick = new rJStick(RobotMap.rStick);
    public final lJStick lJoystick = new lJStick(RobotMap.lStick);
    public final Xbox xbox = new Xbox(RobotMap.xbox);

    public OI(){

        //button assignments Joystick only

        rJoystick.buttonRs1RunWhileHeld(new LaunchC(1.0));
        lJoystick.buttonLs1RunWhileHeld(new EnergyIntakeC(1.0));
        rJoystick.buttonRs6RunWhileHeld(new ElevateC(-0.65, 5));
        rJoystick.buttonRs4RunWhileHeld(new ElevateC(0.65, 4.57));
        rJoystick.buttonRs5RunOnPress(new LockC());
        rJoystick.buttonRs3ToggleOnPress(new UnlockC());
        rJoystick.buttonRs2RunWhileHeld(new VisionAlignTarget());


        //button assignments Joystick and Xbox

        //xbox.xCancelOnPress(new LaunchC(xbox.rightTrigger()));
        //xbox.bCancelOnPress(new EnergyIntakeC(xbox.leftTrigger() * xbox.yDouble()));
        //xbox.aRunWhileHeld(new VisionAlignTarget());
        //xbox.backRunWhileHeld(new ElevateC(-0.45, 4.57));
        //xbox.startRunWhileHeld(new ElevateC(-.45, 4.57));
        //xbox.leftStickRunOnPressed(new LockC());


        //Emergency Commands
        SmartDashboard.putData(new LaunchC(1.0));
        SmartDashboard.putData(new EnergyIntakeC(0.60));
        SmartDashboard.putData(new VisionAlignTarget());

    }
}