package frc.robot.mapping;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
import edu.wpi.first.wpilibj.command.Command;

public class rJStick {

    private static Joystick rJoystick;
    private static JoystickButton rsOneTrigger;
    private static JoystickButton rsTwoThumb;
    private static JoystickButton rsThreeTopLeftDown;
    private static JoystickButton rsFourTopRightDown;
    private static JoystickButton rsFiveTopLeftUpper;
    private static JoystickButton rsSixTopRightUpper;
    private static JoystickButton rsSevenBottomLeftUpperLeft;
    private static JoystickButton rsEightBottomLeftUpperRight;
    private static JoystickButton rsNineBottomLeftMiddleLeft;
    private static JoystickButton rsTenBottomLeftMiddleRight;
    private static JoystickButton rsElevenBottomLeftDownLeft;
    private static JoystickButton rsTwelveBottomLeftDownRight;

    private static POVButton dPadUp;
    private static POVButton dPadDown;
    private static POVButton dPadLeft;
    private static POVButton dPadRight;
    private static POVButton dPadUpLeft;
    private static POVButton dPadUpRight;
    private static POVButton dPadDownLeft;
    private static POVButton dPadDownRight;
    private static POVButton dPadCenter;
private enum POV {
        UP, DOWN, LEFT, RIGHT, UPRIGHT, UPLEFT, DOWNLEFT, DOWNRIGHT, CENTER;
}
private static int dPad(POV pov) {
        switch (pov) {
        case UP: return 0;
        case UPRIGHT: return 45;
        case RIGHT: return 90;
        case DOWNRIGHT: return 135;
        case DOWN: return 180;
        case DOWNLEFT: return 225;
        case LEFT: return 270;
        case UPLEFT: return 315;
        case CENTER: return -1;
        default: return -1;
        }
}

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
    private final static int button12 = 12;

    private final static int axisX = 0;
    private final static int axisY = 1;
    private final static int axisZ = 2;
    private final static int axisThrot = 3;

    private final static int dPadUP = dPad(POV.UP);
    private final static int dPadDOWN = dPad(POV.DOWN);
    private final static int dPadLEFT = dPad(POV.LEFT);
    private final static int dPadRIGHT = dPad(POV.RIGHT);
    private final static int dPadUPLEFT = dPad(POV.UPLEFT);
    private final static int dPadUPRIGHT = dPad(POV.UPRIGHT);
    private final static int dPadDOWNLEFT = dPad(POV.DOWNLEFT);
    private final static int dPadDOWNRIGHT = dPad(POV.DOWNRIGHT);
    private final static int dPadCENTER = dPad (POV.CENTER);
 
  public rJStick(int port) {
        rJoystick = new Joystick(port);
        rsOneTrigger = new JoystickButton(rJoystick, button1);
        rsTwoThumb = new JoystickButton(rJoystick, button2);
        rsThreeTopLeftDown = new JoystickButton(rJoystick, button3);
        rsFourTopRightDown = new JoystickButton(rJoystick, button4);
        rsFiveTopLeftUpper = new JoystickButton(rJoystick, button5);
        rsSixTopRightUpper = new JoystickButton(rJoystick, button6);
        rsSevenBottomLeftUpperLeft = new JoystickButton(rJoystick, button7);
        rsEightBottomLeftUpperRight = new JoystickButton(rJoystick, button8);
        rsNineBottomLeftMiddleLeft = new JoystickButton(rJoystick, button9);
        rsTenBottomLeftMiddleRight = new JoystickButton(rJoystick, button10);
        rsElevenBottomLeftDownLeft = new JoystickButton(rJoystick, button11);
        rsTwelveBottomLeftDownRight = new JoystickButton(rJoystick, button12);
        dPadUp = new POVButton(rJoystick, dPadUP);
        dPadDown = new POVButton(rJoystick, dPadDOWN);
        dPadLeft = new POVButton(rJoystick, dPadLEFT);
        dPadRight = new POVButton(rJoystick, dPadRIGHT);
        dPadUpLeft = new POVButton(rJoystick, dPadUPLEFT);
        dPadUpRight = new POVButton(rJoystick, dPadUPRIGHT);
        dPadDownLeft = new POVButton(rJoystick, dPadDOWNLEFT);
        dPadDownRight = new POVButton(rJoystick, dPadDOWNRIGHT);
        dPadCenter = new POVButton(rJoystick, dPadCENTER);
    }

 public double axisX() {
        return rJoystick.getRawAxis(axisX);
    }

    public double axisY() {
        return rJoystick.getRawAxis(axisY);
    }

    public double axisZ() {
        return rJoystick.getRawAxis(axisZ);
    }

    public double throttle() {
        return rJoystick.getRawAxis(axisThrot); 
    }



public boolean buttonRs1() {
        return rsOneTrigger.get();
    }
    public void buttonRs1RunOnPress(Command command) {
        rsOneTrigger.whenPressed(command);
    }
    public void buttonRs1RunOnRelease(Command command) {
        rsOneTrigger.whenReleased(command);
    }
    public void buttonRs1ToggleOnPress(Command command) {
        rsOneTrigger.toggleWhenPressed(command);
    }
    public void buttonRs1CancelOnPress(Command command) {
        rsOneTrigger.cancelWhenPressed(command);
    }
    public void buttonRs1RunWhileHeld(Command command) {
        rsOneTrigger.whileHeld(command);
    }

    public boolean buttonRs2() {
        return rsTwoThumb.get();
    }
    public void buttonRs2RunOnPress(Command command) {
        rsTwoThumb.whenPressed(command);
    }
    public void buttonRs2RunOnRelease(Command command) {
        rsTwoThumb.whenReleased(command);
    }
    public void buttonRs2ToggleOnPress(Command command) {
        rsTwoThumb.toggleWhenPressed(command);
    }
    public void buttonRs2CancelOnPress(Command command) {
        rsTwoThumb.cancelWhenPressed(command);
    }
    public void buttonRs2RunWhileHeld(Command command) {
        rsTwoThumb.whileHeld(command);
    }

    public boolean buttonRs3() {
        return rsThreeTopLeftDown.get();
    }
    public void buttonRs3RunOnPress(Command command) {
        rsThreeTopLeftDown.whenPressed(command);
    }
    public void buttonRs3RunOnRelease(Command command) {
        rsThreeTopLeftDown.whenReleased(command);
    }
    public void buttonRs3ToggleOnPress(Command command) {
        rsThreeTopLeftDown.toggleWhenPressed(command);
    }
    public void buttonRs3CancelOnPress(Command command) {
        rsThreeTopLeftDown.cancelWhenPressed(command);
    }
    public void buttonRs3RunWhileHeld(Command command) {
        rsThreeTopLeftDown.whileHeld(command);
    }

    public boolean buttonRs4() {
        return rsFourTopRightDown .get();
    }
    public void buttonRs4RunOnPress(Command command) {
        rsFourTopRightDown.whenPressed(command);
    }
    public void buttonRs4RunOnRelease(Command command) {
        rsFourTopRightDown.whenReleased(command);
    }
    public void buttonRs4ToggleOnPress(Command command) {
        rsFourTopRightDown.toggleWhenPressed(command);
    }
    public void buttonRs4CancelOnPress(Command command) {
        rsFourTopRightDown.cancelWhenPressed(command);
    }
    public void buttonRs4RunWhileHeld(Command command) {
        rsFourTopRightDown.whileHeld(command);
    }

    public boolean buttonRs5() {
        return rsFiveTopLeftUpper.get();
    }
    public void buttonRs5RunOnPress(Command command) {
        rsFiveTopLeftUpper.whenPressed(command);
    }
    public void buttonRs5RunOnRelease(Command command) {
        rsFiveTopLeftUpper.whenReleased(command);
    }
    public void buttonRs5ToggleOnPress(Command command) {
        rsFiveTopLeftUpper.toggleWhenPressed(command);
    }
    public void buttonRs5CancelOnPress(Command command) {
        rsFiveTopLeftUpper.cancelWhenPressed(command);
    }
    public void buttonRs5RunWhileHeld(Command command) {
        rsFiveTopLeftUpper.whileHeld(command);
    }

    public boolean buttonRs6() {
        return rsSixTopRightUpper.get();
    }
    public void buttonRs6RunOnPress(Command command) {
        rsSixTopRightUpper.whenPressed(command);
    }
    public void buttonRs6RunOnRelease(Command command) {
        rsSixTopRightUpper .whenReleased(command);
    }
    public void buttonRs6ToggleOnPress(Command command) {
        rsSixTopRightUpper.toggleWhenPressed(command);
    }
    public void buttonRs6CancelOnPress(Command command) {
        rsSixTopRightUpper.cancelWhenPressed(command);
    }
    public void buttonRs6RunWhileHeld(Command command) {
        rsSixTopRightUpper.whileHeld(command);
    }

    public boolean buttonRs7() {
        return rsSevenBottomLeftUpperLeft.get();
    }
    public void buttonRs7RunOnPress(Command command) {
        rsSevenBottomLeftUpperLeft.whenPressed(command);
    }
    public void buttonRs7RunOnRelease(Command command) {
        rsSevenBottomLeftUpperLeft.whenReleased(command);
    }
    public void buttonRs7ToggleOnPress(Command command) {
        rsSevenBottomLeftUpperLeft.toggleWhenPressed(command);
    }
    public void buttonRs7CancelOnPress(Command command) {
        rsSevenBottomLeftUpperLeft.cancelWhenPressed(command);
    }
    public void buttonRs7RunWhileHeld(Command command) {
        rsSevenBottomLeftUpperLeft.whileHeld(command);
    }

    public boolean buttonRs8() {
        return rsEightBottomLeftUpperRight.get();
    }
    public void buttonRs8RunOnPress(Command command) {
        rsEightBottomLeftUpperRight.whenPressed(command);
    }
    public void buttonRs8RunOnRelease(Command command) {
        rsEightBottomLeftUpperRight.whenReleased(command);
    }
    public void buttonRs8ToggleOnPress(Command command) {
        rsEightBottomLeftUpperRight.toggleWhenPressed(command);
    }
    public void buttonRs8CancelOnPress(Command command) {
        rsEightBottomLeftUpperRight.cancelWhenPressed(command);
    }
    public void  buttonRs8RunWhileHeld(Command command) {
        rsEightBottomLeftUpperRight.whileHeld(command);
    }

    public boolean buttonRs9() {
        return rsNineBottomLeftMiddleLeft.get();
    }
    public void buttonRs9RunOnPress(Command command) {
        rsNineBottomLeftMiddleLeft.whenPressed(command);
    }
    public void buttonRs9RunOnRelease(Command command) {
        rsNineBottomLeftMiddleLeft.whenReleased(command);
    }
    public void buttonRs9ToggleOnPress(Command command) {
        rsNineBottomLeftMiddleLeft.toggleWhenPressed(command);
    }
    public void buttonRs9CancelOnPress(Command command) {
        rsNineBottomLeftMiddleLeft.cancelWhenPressed(command);
    }
    public void buttonRs9RunWhileHeld(Command command) {
        rsNineBottomLeftMiddleLeft.whileHeld(command);
    }

    public boolean buttonRs10() {
        return rsTenBottomLeftMiddleRight.get();
    }
    public void buttonRs10RunOnPress(Command command) {
        rsTenBottomLeftMiddleRight.whenPressed(command);
    }
    public void buttonRs10RunOnRelease(Command command) {
        rsTenBottomLeftMiddleRight.whenReleased(command);
    }
    public void buttonRs10ToggleOnPress(Command command) {
        rsTenBottomLeftMiddleRight.toggleWhenPressed(command);
    }
    public void buttonRs10CancelOnPress(Command command) {
        rsTenBottomLeftMiddleRight.cancelWhenPressed(command);
    }
    public void buttonRs10RunWhileHeld(Command command) {
       rsTenBottomLeftMiddleRight.whileHeld(command);
    }

    public boolean buttonRs11() {
        return rsElevenBottomLeftDownLeft.get();
    }
    public void buttonRs11RunOnPress(Command command) {
        rsElevenBottomLeftDownLeft.whenPressed(command);
    }
    public void buttonRs11RunOnRelease(Command command) {
        rsElevenBottomLeftDownLeft.whenReleased(command);
    }
    public void buttonRs11ToggleOnPress(Command command) {
        rsElevenBottomLeftDownLeft.toggleWhenPressed(command);
    }
    public void buttonRs11CancelOnPress(Command command) {
        rsElevenBottomLeftDownLeft.cancelWhenPressed(command);
    }
    public void buttonRs11RunWhileHeld(Command command) {
        rsElevenBottomLeftDownLeft.whileHeld(command);
    }

    public boolean buttonRs12() {
        return rsTwelveBottomLeftDownRight.get();
    }
    public void buttonRs12RunOnPress(Command command) {
        rsTwelveBottomLeftDownRight.whenPressed(command);
    }
    public void buttonRs12RunOnRelease(Command command) {
        rsTwelveBottomLeftDownRight.whenReleased(command);
    }
    public void buttonRs12ToggleOnPress(Command command) {
        rsTwelveBottomLeftDownRight.toggleWhenPressed(command);
    }
    public void button12CancelOnPress(Command command) {
        rsTwelveBottomLeftDownRight.cancelWhenPressed(command);
    }
    public void button12RunWhileHeld(Command command) {
        rsTwelveBottomLeftDownRight.whileHeld(command);
    }

    public boolean DPadUp() {
        return dPadUp.get();
    }
    public void dPadUprunOnPress(Command command) {
        dPadUp.whenPressed(command);
    }
    public void dPadUprunOnRelease(Command command) {
        dPadUp.whenReleased(command);
    }
    public void dPadUptoggleOnPress(Command command) {
        dPadUp.toggleWhenPressed(command);
    }
    public void dPadUpcancelOnPress(Command command) {
        dPadUp.cancelWhenPressed(command);
    }
    public void dPadUprunWhileHeld(Command command) {
        dPadUp.whileHeld(command);
    }

    public boolean dPadDown() {
        return dPadDown.get();
    }
    public void dPadDownrunOnPress(Command command) {
        dPadDown.whenPressed(command);
    }
    public void dPadDownrunOnRelease(Command command) {
        dPadDown.whenReleased(command);
    }
    public void dPadDowntoggleOnPress(Command command) {
        dPadDown.toggleWhenPressed(command);
    }
    public void dPadDowncancelOnPress(Command command) {
        dPadDown.cancelWhenPressed(command);
    }
    public void dPadDownrunWhileHeld(Command command) {
        dPadDown.whileHeld(command);
    }

    public boolean dPadLeft() {
        return dPadLeft.get();
    }
    public void dPadLeftrunOnPress(Command command) {
        dPadLeft.whenPressed(command);
    }
    public void dPadLeftrunOnRelease(Command command) {
        dPadLeft.whenReleased(command);
    }
    public void dPadLefttoggleOnPress(Command command) {
        dPadLeft.toggleWhenPressed(command);
    }
    public void dPadLeftcancelOnPress(Command command) {
        dPadLeft.cancelWhenPressed(command);
    }
    public void dPadLeftrunWhileHeld(Command command) {
        dPadLeft.whileHeld(command);
    }

    public boolean dPadRight() {
        return dPadRight.get();
    }
    public void dPadRightrunOnPress(Command command) {
        dPadRight.whenPressed(command);
    }
    public void dPadRightrunOnRelease(Command command) {
        dPadRight.whenReleased(command);
    }
    public void dPadRighttoggleOnPress(Command command) {
        dPadRight.toggleWhenPressed(command);
    }
    public void dPadRightcancelOnPress(Command command) {
        dPadRight.cancelWhenPressed(command);
    }
    public void dPadRightrunWhileHeld(Command command) {
        dPadRight.whileHeld(command);
    }

    public boolean dPadUpLeft() {
        return dPadUpLeft.get();
    }
    public void dPadUpLeftRunOnPress(Command command) {
        dPadUpLeft.whenPressed(command);
    }
    public void dPadUpLeftRunOnRelease(Command command) {
        dPadUpLeft.whenReleased(command);
    }
    public void dPadUpLeftToggleOnPress(Command command) {
        dPadUpLeft.toggleWhenPressed(command);
    }
    public void dPadUpLeftCancelOnPress(Command command) {
        dPadUpLeft.cancelWhenPressed(command);
    }
    public void dPadUpLeftRunWhileHeld(Command command) {
        dPadUpLeft.whileHeld(command);
    }

    public boolean dPadUpRight() {
        return dPadUpRight.get();
    }
    public void dPadUpRightrunOnPress(Command command) {
        dPadUpRight.whenPressed(command);
    }
    public void dPadUpRightrunOnRelease(Command command) {
        dPadUpRight.whenReleased(command);
    }
    public void dPadUpRighttoggleOnPress(Command command) {
        dPadUpRight.toggleWhenPressed(command);
    }
    public void dPadUpRightcancelOnPress(Command command) {
        dPadUpRight.cancelWhenPressed(command);
    }
    public void dPadUpRightrunWhileHeld(Command command) {
        dPadUpRight.whileHeld(command);
    }

    public boolean dPadDownleft() {
        return dPadDownLeft.get();
    }
    public void dPadDownLeftRunOnPress(Command command) {
        dPadDownLeft.whenPressed(command);
    }
    public void dPadDownLeftTunOnRelease(Command command) {
        dPadDownLeft.whenReleased(command);
    }
    public void dPadDownLeftToggleOnPress(Command command) {
        dPadDownLeft.toggleWhenPressed(command);
    }
    public void dPadDownLeftCancelOnPress(Command command) {
        dPadDownLeft.cancelWhenPressed(command);
    }
    public void dPadDownLeftRunWhileHeld(Command command) {
        dPadDownLeft.whileHeld(command);
    }

    public boolean dPadDownright() {
        return dPadDownRight.get();
    }
    public void dPadDownRightRunOnPress(Command command) {
        dPadDownRight.whenPressed(command);
    }
    public void dPadDownRightRunOnRelease(Command command) {
        dPadDownRight.whenReleased(command);
    }
    public void dPadDownRightToggleOnPress(Command command) {
        dPadDownRight.toggleWhenPressed(command);
    }
    public void dPadDownRightCancelOnPress(Command command) {
        dPadDownRight.cancelWhenPressed(command);
    }
    public void dPadDownRightRunWhileHeld(Command command) {
        dPadDownRight.whileHeld(command);
    }

    public boolean dPadCenter() {
        return dPadCenter.get();
    }
    public void dPadcenter_runOnPress(Command command) {
        dPadCenter.whenPressed(command);
    }
    public void dPadcenter_runOnRelease(Command command) {
        dPadCenter.whenReleased(command);
    }
    public void dPadcenter_toggleOnPress(Command command) {
        dPadCenter.toggleWhenPressed(command);
    }
    public void dPadcenter_cancelOnPress(Command command) {
        dPadCenter.cancelWhenPressed(command);
    }
    public void dPadcenter_runWhileHeld(Command command) {
        dPadCenter.whileHeld(command);
    }
}







