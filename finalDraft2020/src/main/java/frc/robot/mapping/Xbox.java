package frc.robot.mapping;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.POVButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * The Xbox class takes the 3 different control implimentations that the xbox
 * requires to use all of its functions and combines it into one easy to use
 * class. This class combines: {@link edu.wpi.first.wpilibj.XboxController},
 * {@link edu.wpi.first.wpilibj.buttons.JoystickButton}, and
 * {@link edu.wpi.first.wpilibj.buttons.POVButton}
 * 
 * @author Elijah Sauder and Noah Hampton
 */

public class Xbox {
    public static XboxController xbox;
    private static JoystickButton a;
    private static JoystickButton b;
    private static JoystickButton x;
    private static JoystickButton y;
    private static JoystickButton leftStick;
    private static JoystickButton rightStick;
    private static JoystickButton leftBumper;
    private static JoystickButton rightBumper;
    private static JoystickButton start;
    private static JoystickButton back;

    private static POVButton dPadCenter;
    private static POVButton dPadUp;
    private static POVButton dPadDown;
    private static POVButton dPadLeft;
    private static POVButton dPadRight;
    private static POVButton dPadUpLeft;
    private static POVButton dPadUpRight;
    private static POVButton dPadDownLeft;
    private static POVButton dPadDownRight;

    private enum POV {
        up, down, left, right, upRight, upLeft, downLeft, downRight, center;
    }

    private static int dPad(POV pov) {
        switch (pov) {
        case up: return 0;
        case upRight: return 45;
        case right: return 90;
        case downRight: return 135;
        case down: return 180;
        case downLeft: return 225;
        case left: return 270;
        case upLeft: return 315;
        case center: return -1;
        default: return -1;
        }
    }

    // BUTTONS
    private final static int buttonA = 1;
    private final static int buttonB = 2;
    private final static int buttonX = 3;
    private final static int buttonY = 4;
    private final static int buttonLeftBumper = 5;
    private final static int buttonRightBumper = 6;
    private final static int buttonStart = 7;
    private final static int buttonBack = 8;
    private final static int buttonLeftStick = 9;
    private final static int buttonRightStick = 10;

    // AXIS
    private final static int axisLeftStickX = 0;
    private final static int axisLeftStickY = 1;
    private final static int axisRightStickX = 4;
    private final static int axisRightStickY = 5;
    //private final static int axisLeftTrigger= 2;
    //private final static int axisRightTrigger = 3;

    // dPad
    private final static int dPadU = dPad(POV.up);
    private final static int dPadL = dPad(POV.left);
    private final static int dPadD = dPad(POV.left);
    private final static int dPadR = dPad(POV.right);
    private final static int dPadUR = dPad(POV.upRight);
    private final static int dPadUL = dPad(POV.upLeft);
    private final static int dPadDR = dPad(POV.downRight);
    private final static int dPadDL = dPad(POV.downRight);
    private final static int dPadC = dPad(POV.center);

    /**
     * Construct instance of the Xbox class.
     * 
     * @param port : the port on the driver station that the Xbox is plugged into.
     */
    public Xbox(int port) {
        xbox = new XboxController(port);
        a = new JoystickButton(xbox, buttonA);
        b = new JoystickButton(xbox, buttonB);
        x = new JoystickButton(xbox, buttonX);
        y = new JoystickButton(xbox, buttonY);
        leftStick = new JoystickButton(xbox, buttonLeftStick);
        rightStick = new JoystickButton(xbox, buttonRightStick);
        leftBumper = new JoystickButton(xbox, buttonLeftBumper);
        rightBumper = new JoystickButton(xbox, buttonRightBumper);
        start = new JoystickButton(xbox, buttonStart);
        back = new JoystickButton(xbox, buttonBack);
        dPadUp = new POVButton(xbox, dPadU);
        dPadDown = new POVButton(xbox, dPadD);
        dPadLeft = new POVButton(xbox, dPadL);
        dPadRight = new POVButton(xbox, dPadR);
        dPadUpLeft = new POVButton(xbox, dPadUL);
        dPadUpRight = new POVButton(xbox, dPadUR);
        dPadDownLeft = new POVButton(xbox, dPadDL);
        dPadDownRight = new POVButton(xbox, dPadDR);
        dPadCenter = new POVButton(xbox, dPadC); 
    }

    public void setRumble(double strength) {
        xbox.setRumble(RumbleType.kRightRumble, strength);
    }

    /**
     * AXIS
     */
    /**
     * Returns the X axis value from the Xbox's left stick.
     * 
     * @return double
     */
    public double leftStickX() {
        return xbox.getRawAxis(axisLeftStickX);
    }

    /**
     * Returns the Y axis value from the Xbox's left stick.
     * 
     * @return double
     */
    public double leftStickY() {
        return xbox.getRawAxis(axisLeftStickY);
    }

    /**
     * Returns the X axis value from the Xbox's right stick.
     * 
     * @return double
     */
    public double rightStickX() {
        return xbox.getRawAxis(axisRightStickX);
    }

    /**
     * Returns the Y axis value from the Xbox's right stick.
     * 
     * @return double
     */
    public double rightStickY() {
        return xbox.getRawAxis(axisRightStickY);
    }

    /**
     * Returns the value from the Xbox's right trigger.
     * 
     * @return double
     */
    public double rightTrigger() {
        return xbox.getTriggerAxis(Hand.kRight);
    }

    /**
     * Returns the value from the Xbox's left trigger.
     * 
     * @return double
     */
    public double leftTrigger() {
        return xbox.getTriggerAxis(Hand.kLeft);
    }
    
    /**
     * BUTTONS
     */
    /**
     * Returns the value of the Xbox A button
     * 
     * @return boolean
     */
    public boolean a() {
        return xbox.getAButton();
    }

    /**
     * Runs a command when the Xbox A button is pressed.
     * 
     * @param
     */
    public void aRunOnPressed(Command command) {
        a.whenPressed(command);
    }

    /**
     * Runs a command when the Xbox A button is released.
     * 
     * @param
     */
    public void aRunOnRelease(Command command) {
        a.whenReleased(command);
    }

    /**
     * Toggles a command when the Xbox A button is pressed.
     * 
     * @param
     */
    public void aToggleOnPress(Command command) {
        a.toggleWhenPressed(command);
    }

    /**
     * Stops a command when the Xbox A button is pressed.
     * 
     * @param
     */
    public void aCancelOnPress(Command command) {
        a.cancelWhenPressed(command);
    }

    /**
     * Runs a command while the Xbox A button is pressed.
     * 
     * @param
     */
    public void aRunWhileHeld(Command command) {
        a.whileHeld(command);
    }

    /**
     * Returns the value of the Xbox B button
     * 
     * @return boolean
     */
    public boolean b() {
        return xbox.getBButton();
    }

    /**
     * Runs a command when the Xbox B button is pressed.
     * 
     * @param
     */
    public void bRunOnPressed(Command command) {
        b.whenPressed(command);
    }

    /**
     * Runs a command when the Xbox B button is released.
     * 
     * @param
     */
    public void bRunOnRelease(Command command) {
        b.whenReleased(command);
    }

    /**
     * Toggles a command when the Xbox B button is pressed.
     * 
     * @param
     */
    public void bToggleOnPress(Command command) {
        b.toggleWhenPressed(command);
    }

    /**
     * Cancels a command when the Xbox B button is pressed.
     * 
     * @param
     */
    public void bCancelOnPress(Command command) {
        b.cancelWhenPressed(command);
    }

    /**
     * Runs a command while the Xbox B button is pressed.
     * 
     * @param
     */
    public void bRunWhileHeld(Command command) {
        b.whileHeld(command);
    }
    /**
     * Runs a command while the Xbox B button is not being pressed.
     * 
     * @param
     */
    public void bRunWhileNotHeld(Command command){
        b.cancelWhenActive(command);
    }
    /**
     * Returns the value of the Xbox X button
     * 
     * @return boolean
     */
    public boolean x() {
        return xbox.getXButton();
    }

    /**
     * Runs a command when the Xbox X button is pressed.
     * 
     * @param
     */
    public void xRunOnPressed(Command command) {
        x.whenPressed(command);
    }

    /**
     * Runs a command when the Xbox X button is released.
     * 
     * @param
     */
    public void xRunOnRelease(Command command) {
        x.whenReleased(command);
    }

    /**
     * Toggles a command when the Xbox X button is pressed.
     * 
     * @param
     */
    public void xToggleOnPress(Command command) {
        x.toggleWhenPressed(command);
    }

    /**
     * Cancels a command when the Xbox X button is pressed.
     * 
     * @param
     */

    public void xCancelOnPress(Command command) {
        x.cancelWhenPressed(command);
    }

    /**
     * Runs a command while the Xbox X button is pressed.
     * 
     * @param
     */
    public void xRunWhileHeld(Command command) {
        x.whileHeld(command);
    }
    /**
     * Runs a command while the Xbox X button is not being pressed.
     * 
     * @param
     */
    public void xRunWhileNotHeld(Command command){
        x.cancelWhenActive(command);
    }
    /**
     * Returns the value of the Xbox Y button.
     * 
     * @return boolean
     */
    public boolean y() {
        return xbox.getYButton();
    }

    /**
     * Runs a command when the Xbox Y button is pressed.
     * 
     * @param
     */
    public void yRunOnPressed(Command command) {
        y.whenPressed(command);
    }

    /**
     * Runs a command when the Xbox Y button is released.
     * 
     * @param
     */
    public void yRunOnRelease(Command command) {
        y.whenReleased(command);
    }

    /**
     * Toggles a command when the Xbox Y button is pressed.
     * 
     * @param
     */
    public void yToggleOnPress(Command command) {
        y.toggleWhenPressed(command);
    }

    /**
     * Cancels a command when the Xbox Y button is pressed.
     * 
     * @param
     */
    public void yCancelOnPress(Command command) {
        y.cancelWhenPressed(command);
    }

    /**
     * Runs a command while the Xbox Y button is pressed.
     * 
     * @param
     */
    public void yRunWhileHeld(Command command) {
        y.whileHeld(command);
    }

    public void yRunWhileNotHeld(Command command){
        y.cancelWhenActive(command);
    }
    /**
     * Returns a positive or negative double based on if why is pressed.
     * 
     * @param
     */
    public double yDouble(){
        if (y())
            return 1.0;
        else
            return -1.0;
    }

    /**
     * Returns the value of the Xbox Back button.
     * 
     * @return boolean
     */
    public boolean back() {
        return xbox.getBackButton();
    }

    /**
     * Runs a command when the Xbox Back button is pressed.
     * 
     * @param
     */
    public void backRunOnPressed(Command command) {
        back.whenPressed(command);
    }

    /**
     * Runs a command when the Xbox Back button is released.
     * 
     * @param
     */
    public void backRunOnRelease(Command command) {
        back.whenReleased(command);
    }

    /**
     * Toggles a command when the Xbox Back button is pressed.
     * 
     * @param
     */
    public void backToggleOnPress(Command command) {
        back.toggleWhenPressed(command);
    }

    /**
     * Cancels a command when the Xbox Back button is pressed.
     * 
     * @param
     */
    public void backCancelOnPress(Command command) {
        back.cancelWhenPressed(command);
    }

    /**
     * Runs a command while the Xbox Back button is pressed.
     * 
     * @param
     */
    public void backRunWhileHeld(Command command) {
        back.whileHeld(command);
    }

    /**
     * Returns the value of the start button
     * 
     * @return boolean
     */
    public boolean start() {
        return xbox.getStartButton();
    }

    /**
     * Runs a command when the Xbox Start button is pressed.
     * 
     * @param
     */
    public void startRunOnPressed(Command command) {
        start.whenPressed(command);
    }

    /**
     * Runs a command when the Xbox Start button is released.
     * 
     * @param
     */
    public void startRunOnRelease(Command command) {
        start.whenReleased(command);
    }

    /**
     * Toggles a command when the Xbox Start button is pressed.
     * 
     * @param
     */
    public void startToggleOnPress(Command command) {
        start.toggleWhenPressed(command);
    }

    /**
     * Cancels a command when the Xbox Start button is pressed.
     * 
     * @param
     */
    public void startCancelOnPress(Command command) {
        start.cancelWhenPressed(command);
    }

    /**
     * Runs a command while the Xbox Start button is pressed.
     * 
     * @param
     */
    public void startRunWhileHeld(Command command) {
        start.whileHeld(command);
    }

    /**
     * Returns the value of the Xbox Left Stick button.
     * 
     * @return boolean
     */
    public boolean leftStick() {
        return xbox.getStickButton(Hand.kLeft);
    }

    /**
     * Runs a command when the Xbox Left Stick button is pressed.
     * 
     * @param
     */
    public void leftStickRunOnPressed(Command command) {
        leftStick.whenPressed(command);
    }

    /**
     * Runs a command when the Xbox Left Stick button is released.
     * 
     * @param
     */
    public void leftStickRunOnRelease(Command command) {
        leftStick.whenReleased(command);
    }

    /**
     * Toggles a command when the Xbox Left Stick button is pressed.
     * 
     * @param
     */
    public void leftStickToggleOnPress(Command command) {
        leftStick.toggleWhenPressed(command);
    }

    /**
     * Cancels a command when the Xbox Left Stick button is pressed.
     * 
     * @param
     */
    public void leftStickCancelOnPress(Command command) {
        leftStick.cancelWhenPressed(command);
    }

    /**
     * Runs a command while the Xbox Left Stick button is pressed.
     * 
     * @param
     */
    public void leftStickRunWhileHeld(Command command) {
        leftStick.whileHeld(command);
    }

    /**
     * Returns the value of the Xbox Right Stick button.
     * 
     * @return boolean
     */
    public boolean rightStick() {
        return xbox.getStickButton(Hand.kRight);
    }

    /**
     * Runs a command when the Xbox Right Stick button is pressed.
     * 
     * @param
     */
    public void rightStickRunOnPressed(Command command) {
        rightStick.whenPressed(command);
    }

    /**
     * Runs a command when the Xbox Right Stick button is released.
     * 
     * @param
     */
    public void rightStickRunOnRelease(Command command) {
        rightStick.whenReleased(command);
    }

    /**
     * Toggles a command when the Xbox Right Stick button is pressed.
     * 
     * @param
     */
    public void rightStickToggleOnPress(Command command) {
        rightStick.toggleWhenPressed(command);
    }

    /**
     * Cancels a command when the Xbox Right Stick button is pressed.
     * 
     * @param
     */
    public void rightStickCancelOnPress(Command command) {
        rightStick.cancelWhenPressed(command);
    }

    /**
     * Runs a command while the Xbox Right Stick button is pressed.
     * 
     * @param
     */
    public void rightStick_RunWhileHeld(Command command) {
        rightStick.whileHeld(command);
    }

    /**
     * Returns the value of the Xbox Left Bumper button.
     * 
     * @return boolean
     */
    public boolean leftBumper() {
        return xbox.getBumper(Hand.kLeft);
    }

    public boolean leftBumperPressed(){
        return xbox.getBumperPressed(Hand.kLeft);
    }

    /**
     * Runs a command when the Xbox Left Bumper button is pressed.
     * 
     * @param
     */
    public void leftBumperRunOnPressed(Command command) {
        leftBumper.whenPressed(command);
    }

    /**
     * Runs a command when the Xbox Left Bumper button is released.
     * 
     * @param
     */
    public void leftBumperRunOnRelease(Command command) {
        leftBumper.whenReleased(command);
    }

    /**
     * Toggles a command when the Xbox Left Bumper button is pressed.
     * 
     * @param
     */
    public void leftBumperToggleOnPress(Command command) {
        leftBumper.toggleWhenPressed(command);
    }

    /**
     * Cancels a command when the Xbox Left Bumper button is pressed.
     * 
     * @param
     */
    public void leftBumperCancelOnPress(Command command) {
        leftBumper.cancelWhenPressed(command);
    }

    /**
     * Runs a command while the Xbox Left Bumper button is pressed.
     * 
     * @param
     */
    public void leftBumperRunWhileHeld(Command command) {
        leftBumper.whileHeld(command);
    }

    /**
     * Returns the value of the Xbox Right Bumper button.
     * 
     * @return boolean
     */
    public boolean rightBumper() {
        return xbox.getBumper(Hand.kRight);
    }

    /**
     * Runs a command when the Xbox Right Bumper button is pressed.
     * 
     * @param
     */
    public void rightBumperRunOnPressed(Command command) {
        rightBumper.whenPressed(command);
    }

    /**
     * Runs a command when the Xbox Right Bumper button is released.
     * 
     * @param
     */
    public void rightBumperRunOnRelease(Command command) {
        rightBumper.whenReleased(command);
    }

    /**
     * Toggles a command when the Xbox Right Bumper button is pressed.
     * 
     * @param
     */
    public void rightBumperToggleOnPress(Command command) {
        rightBumper.toggleWhenPressed(command);
    }

    /**
     * Cancels a command when the Xbox Right Bumper button is pressed.
     * 
     * @param
     */
    public void rightBumperCancelOnPress(Command command) {
        rightBumper.cancelWhenPressed(command);
    }

    /**
     * Runs a command while the Xbox Right Bumper button is pressed.
     * 
     * @param
     */
    public void rightBumperRunWhileHeld(Command command) {
        rightBumper.whileHeld(command);
    }

    /**
     * POV
     */
    /**
     * Returns whether or not the Xbox POV is in the up position.
     * 
     * @return boolean
     */
    public boolean PDadUp() {
        return dPadUp.get();
    }

    /**
     * Runs a command when the Xbox POV is in the up position.
     * 
     * @param
     */
    public void dPadUpRunOnPressed(Command command) {
        dPadUp.whenPressed(command);
    }

    /**
     * Runs a command when the Xbox Dpad POV is no longer in the up position.
     * 
     * @param
     */
    public void dPadUpRunOnRelease(Command command) {
        dPadUp.whenReleased(command);
    }

    /**
     * Toggles a command when the Xbox POV is in the up position.
     * 
     * @param
     */
    public void dPadUpToggleOnPress(Command command) {
        dPadUp.toggleWhenPressed(command);
    }

    /**
     * Cancels a command when the Xbox POV is in the up position.
     * 
     * @param
     */
    public void dPadUpCancelOnPress(Command command) {
        dPadUp.cancelWhenPressed(command);
    }

    /**
     * Runs a command while the Xbox POV is in the up position.
     * 
     * @param
     */
    public void dPadUpRunWhileHeld(Command command) {
        dPadUp.whileHeld(command);
    }

    /**
     * Returns whether or not the xbox POV is in the down position.
     * 
     * @return boolean
     */
    public boolean dPadDown() {
        return dPadDown.get();
    }

    /**
     * Runs a command when the Xbox POV is in the down position.
     * 
     * @param
     */
    public void dPadDownRunOnPressed(Command command) {
        dPadDown.whenPressed(command);
    }

    /**
     * Runs a command when the Xbox POV is no longer in the down position.
     * 
     * @param
     */
    public void dPadDownRunOnRelease(Command command) {
        dPadDown.whenReleased(command);
    }

    /**
     * Toggles a command when the Xbox POV is in the down position.
     * 
     * @param
     */
    public void dPadDownToggleOnPress(Command command) {
        dPadDown.toggleWhenPressed(command);
    }

    /**
     * Cancels a command when the Xbox POV is in the down position.
     * 
     * @param
     */
    public void dPadDownCancelOnPress(Command command) {
        dPadDown.cancelWhenPressed(command);
    }

    /**
     * Runs a command while the Xbox POV is in the down position.
     * 
     * @param
     */
    public void dPadDownRunWhileHeld(Command command) {
        dPadDown.whileHeld(command);
    }

    /**
     * Returns whether or not the Xbox POV is in the left position.
     * 
     * @return boolean
     */
    public boolean dPadLeft() {
        return dPadLeft.get();
    }

    /**
     * Runs a command when the Xbox POV is in the left position.
     * 
     * @param
     */
    public void dPadLeftRunOnPressed(Command command) {
        dPadLeft.whenPressed(command);
    }

    /**
     * Runs a command when the Xbox POV is no longer in the left position.
     * 
     * @param
     */
    public void dPadLeftRunOnRelease(Command command) {
        dPadLeft.whenReleased(command);
    }

    /**
     * Toggles a command when the Xbox POV is in the left position.
     * 
     * @param
     */
    public void dPadLeftToggleOnPress(Command command) {
        dPadLeft.toggleWhenPressed(command);
    }

    /**
     * Cancels a command when the Xbox POV is in the left position.
     * 
     * @param
     */
    public void dPadLeftCancelOnPress(Command command) {
        dPadLeft.cancelWhenPressed(command);
    }

    /**
     * Runs a command while the Xbox POV is in the left position.
     * 
     * @param
     */
    public void dPadLeftRunWhileHeld(Command command) {
        dPadLeft.whileHeld(command);
    }

    /**
     * Returns whether or not the Xbox POV is in the right position.
     * 
     * @return boolean
     */
    public boolean dPadRight() {
        return dPadRight.get();
    }

    /**
     * Runs a command when the Xbox POV is in the right position.
     * 
     * @param
     */
    public void dPadRightRunOnPressed(Command command) {
        dPadRight.whenPressed(command);
    }

    /**
     * Runs a command when the Xbox POV is no longer in the right position.
     * 
     * @param
     */
    public void dPadRightRunOnRelease(Command command) {
        dPadRight.whenReleased(command);
    }

    /**
     * Toggles a command when the Xbox POV is in the right position.
     * 
     * @param
     */
    public void dPadRightToggleOnPress(Command command) {
        dPadRight.toggleWhenPressed(command);
    }

    /**
     * Cancels a command when the Xbox POV is in the right position.
     * 
     * @param
     */
    public void dPadRightCancelOnPress(Command command) {
        dPadRight.cancelWhenPressed(command);
    }

    /**
     * Runs a command while the Xbox POV is in the right position.
     * 
     * @param
     */
    public void dPadRightRunWhileHeld(Command command) {
        dPadRight.whileHeld(command);
    }

    /**
     * Returns whether or not the Xbox POV is in the up light position.
     * 
     * @return boolean
     */
    public boolean dPadUpRight() {
        return dPadUpRight.get();
    }

    /**
     * Runs a command when the Xbox POV is in the up right position.
     * 
     * @param
     */
    public void PadUpRightRunOnPressed(Command command) {
        dPadUpRight.whenPressed(command);
    }

    /**
     * Runs a command when the Xbox POV is no longer in the up right position.
     * 
     * @param
     */
    public void dPadUpRightRunOnRelease(Command command) {
        dPadUpRight.whenReleased(command);
    }

    /**
     * Toggles a command when the Xbox POV is in the up right position.
     * 
     * @param
     */
    public void dPadUpRightToggleOnPress(Command command) {
        dPadUpRight.toggleWhenPressed(command);
    }

    /**
     * Cancels a command when the Xbox POV is in the up right position.
     * 
     * @param
     */
    public void dPadUpRightCancelOnPress(Command command) {
        dPadUpRight.cancelWhenPressed(command);
    }

    /**
     * Runs a command while the Xbox POV is in the up right position.
     * 
     * @param
     */
    public void dPadUpRightRunWhileHeld(Command command) {
        dPadUpRight.whileHeld(command);
    }

    /**
     * Returns whether or not the Xbox POV is in the up left position.
     * 
     * @return boolean
     */
    public boolean dPadUpLeft() {
        return dPadUpLeft.get();
    }

    /**
     * Runs a command when the Xbox POV is in the up left position.
     * 
     * @param
     */
    public void dPadUpLeftRunOnPressed(Command command) {
        dPadUpLeft.whenPressed(command);
    }

    /**
     * Runs a command when the Xbox POV is no longer in the up left position.
     * 
     * @param
     */
    public void dPadUpLeftRunOnRelease(Command command) {
        dPadUpLeft.whenReleased(command);
    }

    /**
     * Toggles a command when the Xbox POV is in the up left position.
     * 
     * @param
     */
    public void dPadUpLeftToggleOnPress(Command command) {
        dPadUpLeft.toggleWhenPressed(command);
    }

    /**
     * Cancels a command when the Xbox POV is in the up left position.
     * 
     * @param
     */
    public void dPadUpLeftCancelOnPress(Command command) {
        dPadUpLeft.cancelWhenPressed(command);
    }

    /**
     * Runs a command while the Xbox POV is in the up left position.
     * 
     * @param
     */
    public void dPadUpLeftRunWhileHeld(Command command) {
        dPadUpLeft.whileHeld(command);
    }

    /**
     * Returns whether or not the Xbox POV is in the down right position.
     * 
     * @return boolean
     */
    public boolean dPadDownRight() {
        return dPadDownRight.get();
    }

    /**
     * Runs a command when the Xbox POV is in the down right position.
     * 
     * @param
     */
    public void dPadDownRightRunOnPressed(Command command) {
        dPadDownRight.whenPressed(command);
    }

    /**
     * Runs a command when the Xbox POV is no longer in the down right position.
     * 
     * @param
     */
    public void dPadDownRightRunOnRelease(Command command) {
        dPadDownRight.whenReleased(command);
    }

    /**
     * Toggles a command when the Xbox POV is in the down right position.
     * 
     * @param
     */
    public void dPadDownRightToggleOnPress(Command command) {
        dPadDownRight.toggleWhenPressed(command);
    }

    /**
     * Cancels a command when the Xbox POV is in the down right position.
     * 
     * @param
     */
    public void dPadDownRightCancelOnPress(Command command) {
        dPadDownRight.cancelWhenPressed(command);
    }

    /**
     * Runs a command while the Xbox POV is in the down right position.
     * 
     * @param
     */
    public void dPadDownRightRunWhileHeld(Command command) {
        dPadDownRight.whileHeld(command);
    }

    /**
     * Returns whether or not the Xbox POV is in the down left position.
     * 
     * @return boolean
     */
    public boolean dPadDownLeft() {
        return dPadDownLeft.get();
    }

    /**
     * Runs a command when the Xbox POV is in the down left position.
     * 
     * @param
     */
    public void dPadDownLeftRunOnPressed(Command command) {
        dPadDownLeft.whenPressed(command);
    }

    /**
     * Runs a command when the Xbox POV is no longer in the down left position.
     * 
     * @param
     */
    public void dPadDownLeftRunOnRelease(Command command) {
        dPadDownLeft.whenReleased(command);
    }

    /**
     * Toggles a command when the Xbox POV is in the down left position.
     * 
     * @param
     */
    public void dPadDownLeftToggleOnPress(Command command) {
        dPadDownLeft.toggleWhenPressed(command);
    }

    /**
     * Cancels a command when the Xbox POV is in the down left position.
     * 
     * @param
     */
    public void dPadDownLeftCancelOnPress(Command command) {
        dPadDownLeft.cancelWhenPressed(command);
    }

    /**
     * Runs a command while the Xbox POV is in the down left position.
     * 
     * @param
     */
    public void dPadDownLeftRunWhileHeld(Command command) {
        dPadDownLeft.whileHeld(command);
    }

    /**
     * Returns whether or not the Xbox POV is in the center position.
     * 
     * @return boolean
     */
    public boolean dPadCenter() {
        return dPadCenter.get();
    }

    /**
     * Runs a command when the Xbox POV is in the center position.
     * 
     * @param
     */
    public void dPadCenterRunOnPressed(Command command) {
        dPadCenter.whenPressed(command);
    }

    /**
     * Runs a command when the Xbox POV is no longer in the center position.
     * 
     * @param
     */
    public void dPadCenterRunOnRelease(Command command) {
        dPadCenter.whenReleased(command);
    }

    /**
     * Toggles a command when the Xbox POV is in the center position.
     * 
     * @param
     */
    public void dPadCenterToggleOnPress(Command command) {
        dPadCenter.toggleWhenPressed(command);
    }

    /**
     * Cancels a command when the Xbox POV is in the center position.
     * 
     * @param
     */
    public void dPadCenterCancelOnPress(Command command) {
        dPadCenter.cancelWhenPressed(command);
    }

    /**
     * Runs a command while the Xbox POV is in the center position.
     * 
     * @param
     */
    public void dPadCenterRunWhileHeld(Command command) {
        dPadCenter.whileHeld(command);
    }
}

