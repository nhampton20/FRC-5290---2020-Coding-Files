package frc.robot.commands.drive;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class TurnTo extends Command {
    private boolean isThere = false;
    private double targetAngle = 0;
    private double maxTwist = 1.0;
    private double thresholdAngle = 2.0;

    public TurnTo(double targetAngle) {
        this.targetAngle = targetAngle;
    }

    @Override
    protected void execute() {
        /*
         * The angle given by the robots gyroscope is unbounded meaning it stretches
         * from negative infinity to positive infinity. This creates problems which will
         * be solved when finding the error
         */
        double currentAngle = Robot.mDriveS.gyroAngle();

        /*
         * Generally the error would just be the targetAngle minus the currentAngle but
         * due to the unbounded value of the currentAngle, an extra function has been
         * added to the equation to clamp the result to -180 to 180
         */
        double error = (360.0 * Math.ceil(((currentAngle - targetAngle) / 360.0) - 0.5)) + (targetAngle - currentAngle);

        /*
         * If the robot is within thresholdAngle degrees, the thereAngle boolean will
         * read true.
         */
        if (Math.abs(error) <= thresholdAngle) {
            isThere = true;
        } else {
            isThere = false;
        }

        /*
         * What follows is a speed adaptor that strives to get the robot to get as close
         * to the targetAngle as possible without overshooting… this has been a problem
         * in the past and may benefit from some tweaking
         */
        double twistSpeed = (error * error * error) / 27.0;
        if (twistSpeed > maxTwist || twistSpeed < maxTwist) {
            Robot.mDriveS.tankDrive(maxTwist, -maxTwist, 1.0);
        } else {
            Robot.mDriveS.tankDrive(twistSpeed, -twistSpeed, 1.0);
        }
    }

    @Override
    protected void initialize() {
    }

    @Override
    protected boolean isFinished() {
        return isThere;
    }

    @Override
    protected void end() {
        Robot.mDriveS.tankDrive(0.0, 0.0, 0.0); /* stops robot, allowing for transition to human control */
    }

    @Override
    protected void interrupted() {
        Robot.mDriveS.tankDrive(0.0, 0.0, 0.0); /* stops robot, for safety */
    }
}
