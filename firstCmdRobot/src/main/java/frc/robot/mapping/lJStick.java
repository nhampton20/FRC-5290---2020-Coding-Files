package frc.robot.mapping;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

public class lJStick {

    private static Joystick lJoystick;
    private static JoystickButton lsOneTrigger;
    private static JoystickButton lsTwoThumb;
    private static JoystickButton lsThreeTopLeftDown;
    private static JoystickButton lsFourTopRightDown;
    private static JoystickButton lsFiveTopLeftUpper;
    private static JoystickButton lsSixTopRightUpper;
    private static JoystickButton lsSevenBottomLeftUpperLeft;
    private static JoystickButton lsEightBottomLeftUpperRight;
    private static JoystickButton lsNineBottomLeftMiddleLeft;
    private static JoystickButton lsTenBottomLeftMiddleRight;
    private static JoystickButton lsElevenBottomLeftDownLeft;



    private final static int button1  = 1;
    private final static int button2 = 2;
    private final static int button3 = 3;
    private final static int button4 = 4;
    private final static int button5 = 5;
    private final static int button6 = 6;
    private final static int button7 = 7;
    private final static int button8 = 8;
    private final static int button9 = 9;
    private final static int button10 = 10;
    private final static int button11 = 11;

    private final static int axisX = 0;
    private final static int axisY = 1;
    private final static int axisThrot = 2;

 
  public lJStick(int port) {
        lJoystick = new Joystick(port);
        lsOneTrigger = new JoystickButton(lJoystick, button1);
        lsTwoThumb = new JoystickButton(lJoystick, button2);
        lsThreeTopLeftDown = new JoystickButton(lJoystick, button3);
        lsFourTopRightDown = new JoystickButton(lJoystick, button4);
        lsFiveTopLeftUpper = new JoystickButton(lJoystick, button5);
        lsSixTopRightUpper = new JoystickButton(lJoystick, button6);
        lsSevenBottomLeftUpperLeft = new JoystickButton(lJoystick, button7);
        lsEightBottomLeftUpperRight = new JoystickButton(lJoystick, button8);
        lsNineBottomLeftMiddleLeft = new JoystickButton(lJoystick, button9);
        lsTenBottomLeftMiddleRight = new JoystickButton(lJoystick, button10);
        lsElevenBottomLeftDownLeft = new JoystickButton(lJoystick, button11);
    }

 public double axisX() {
        return lJoystick.getRawAxis(axisX);
    }

    public double axisY() {
        return lJoystick.getRawAxis(axisY);
    }

    public double throttle() {
        return lJoystick.getRawAxis(axisThrot); 
    }



public boolean buttonLs1() {
        return lsOneTrigger.get();
    }
    public void buttonLs1RunOnPress(Command command) {
        lsOneTrigger.whenPressed(command);
    }
    public void buttonLs1RunOnRelease(Command command) {
        lsOneTrigger.whenReleased(command);
    }
    public void buttonLs1ToggleOnPress(Command command) {
        lsOneTrigger.toggleWhenPressed(command);
    }
    public void buttonLs1CancelOnPress(Command command) {
        lsOneTrigger.cancelWhenPressed(command);
    }
    public void buttonLs1RunWhileHeld(Command command) {
        lsOneTrigger.whileHeld(command);
    }

    public boolean buttonLs2() {
        return lsTwoThumb.get();
    }
    public void buttonLs2RunOnPress(Command command) {
        lsTwoThumb.whenPressed(command);
    }
    public void buttonLs2RunOnRelease(Command command) {
        lsTwoThumb.whenReleased(command);
    }
    public void buttonLs2ToggleOnPress(Command command) {
        lsTwoThumb.toggleWhenPressed(command);
    }
    public void buttonLs2CancelOnPress(Command command) {
        lsTwoThumb.cancelWhenPressed(command);
    }
    public void buttonLs2RunWhileHeld(Command command) {
        lsTwoThumb.whileHeld(command);
    }

    public boolean buttonLs3() {
        return lsThreeTopLeftDown.get();
    }
    public void buttonLs3RunOnPress(Command command) {
        lsThreeTopLeftDown.whenPressed(command);
    }
    public void buttonLs3RunOnRelease(Command command) {
        lsThreeTopLeftDown.whenReleased(command);
    }
    public void buttonLs3ToggleOnPress(Command command) {
        lsThreeTopLeftDown.toggleWhenPressed(command);
    }
    public void buttonLs3CancelOnPress(Command command) {
        lsThreeTopLeftDown.cancelWhenPressed(command);
    }
    public void buttonLs3RunWhileHeld(Command command) {
        lsThreeTopLeftDown.whileHeld(command);
    }

    public boolean buttonLs4() {
        return lsFourTopRightDown .get();
    }
    public void buttonLs4RunOnPress(Command command) {
        lsFourTopRightDown.whenPressed(command);
    }
    public void buttonLs4RunOnRelease(Command command) {
        lsFourTopRightDown.whenReleased(command);
    }
    public void buttonLs4ToggleOnPress(Command command) {
        lsFourTopRightDown.toggleWhenPressed(command);
    }
    public void buttonLs4CancelOnPress(Command command) {
        lsFourTopRightDown.cancelWhenPressed(command);
    }
    public void buttonLs4RunWhileHeld(Command command) {
        lsFourTopRightDown.whileHeld(command);
    }

    public boolean buttonLs5() {
        return lsFiveTopLeftUpper.get();
    }
    public void buttonLs5RunOnPress(Command command) {
        lsFiveTopLeftUpper.whenPressed(command);
    }
    public void buttonLs5RunOnRelease(Command command) {
        lsFiveTopLeftUpper.whenReleased(command);
    }
    public void buttonLs5ToggleOnPress(Command command) {
        lsFiveTopLeftUpper.toggleWhenPressed(command);
    }
    public void buttonLs5CancelOnPress(Command command) {
        lsFiveTopLeftUpper.cancelWhenPressed(command);
    }
    public void buttonLs5RunWhileHeld(Command command) {
        lsFiveTopLeftUpper.whileHeld(command);
    }

    public boolean buttonLs6() {
        return lsSixTopRightUpper.get();
    }
    public void buttonLs6RunOnPress(Command command) {
        lsSixTopRightUpper.whenPressed(command);
    }
    public void buttonLs6RunOnRelease(Command command) {
        lsSixTopRightUpper .whenReleased(command);
    }
    public void buttonLs6ToggleOnPress(Command command) {
        lsSixTopRightUpper.toggleWhenPressed(command);
    }
    public void buttonLs6CancelOnPress(Command command) {
        lsSixTopRightUpper.cancelWhenPressed(command);
    }
    public void buttonLs6RunWhileHeld(Command command) {
        lsSixTopRightUpper.whileHeld(command);
    }

    public boolean buttonLs7() {
        return lsSevenBottomLeftUpperLeft.get();
    }
    public void buttonLs7RunOnPress(Command command) {
        lsSevenBottomLeftUpperLeft.whenPressed(command);
    }
    public void buttonLs7RunOnRelease(Command command) {
        lsSevenBottomLeftUpperLeft.whenReleased(command);
    }
    public void buttonLs7ToggleOnPress(Command command) {
        lsSevenBottomLeftUpperLeft.toggleWhenPressed(command);
    }
    public void buttonLs7CancelOnPress(Command command) {
        lsSevenBottomLeftUpperLeft.cancelWhenPressed(command);
    }
    public void buttonLs7RunWhileHeld(Command command) {
        lsSevenBottomLeftUpperLeft.whileHeld(command);
    }

    public boolean buttonLs8() {
        return lsEightBottomLeftUpperRight.get();
    }
    public void buttonLs8RunOnPress(Command command) {
        lsEightBottomLeftUpperRight.whenPressed(command);
    }
    public void buttonLs8RunOnRelease(Command command) {
        lsEightBottomLeftUpperRight.whenReleased(command);
    }
    public void buttonLs8ToggleOnPress(Command command) {
        lsEightBottomLeftUpperRight.toggleWhenPressed(command);
    }
    public void buttonLs8CancelOnPress(Command command) {
        lsEightBottomLeftUpperRight.cancelWhenPressed(command);
    }
    public void  buttonLs8RunWhileHeld(Command command) {
        lsEightBottomLeftUpperRight.whileHeld(command);
    }

    public boolean buttonLs9() {
        return lsNineBottomLeftMiddleLeft.get();
    }
    public void buttonLs9RunOnPress(Command command) {
        lsNineBottomLeftMiddleLeft.whenPressed(command);
    }
    public void buttonLs9RunOnRelease(Command command) {
        lsNineBottomLeftMiddleLeft.whenReleased(command);
    }
    public void buttonLs9ToggleOnPress(Command command) {
        lsNineBottomLeftMiddleLeft.toggleWhenPressed(command);
    }
    public void buttonLs9CancelOnPress(Command command) {
        lsNineBottomLeftMiddleLeft.cancelWhenPressed(command);
    }
    public void buttonLs9RunWhileHeld(Command command) {
        lsNineBottomLeftMiddleLeft.whileHeld(command);
    }

    public boolean buttonLs10() {
        return lsTenBottomLeftMiddleRight.get();
    }
    public void buttonLs10RunOnPress(Command command) {
        lsTenBottomLeftMiddleRight.whenPressed(command);
    }
    public void buttonLs10RunOnRelease(Command command) {
        lsTenBottomLeftMiddleRight.whenReleased(command);
    }
    public void buttonLs10ToggleOnPress(Command command) {
        lsTenBottomLeftMiddleRight.toggleWhenPressed(command);
    }
    public void buttonLs10CancelOnPress(Command command) {
        lsTenBottomLeftMiddleRight.cancelWhenPressed(command);
    }
    public void buttonLs10RunWhileHeld(Command command) {
       lsTenBottomLeftMiddleRight.whileHeld(command);
    }

    public boolean buttonLs11() {
        return lsElevenBottomLeftDownLeft.get();
    }
    public void buttonLs11RunOnPress(Command command) {
        lsElevenBottomLeftDownLeft.whenPressed(command);
    }
    public void buttonLs11RunOnRelease(Command command) {
        lsElevenBottomLeftDownLeft.whenReleased(command);
    }
    public void buttonLs11ToggleOnPress(Command command) {
        lsElevenBottomLeftDownLeft.toggleWhenPressed(command);
    }
    public void buttonLs11CancelOnPress(Command command) {
        lsElevenBottomLeftDownLeft.cancelWhenPressed(command);
    }
    public void buttonLs11RunWhileHeld(Command command) {
        lsElevenBottomLeftDownLeft.whileHeld(command);
    }

}



