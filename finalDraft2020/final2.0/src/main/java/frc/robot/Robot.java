/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.shuffleboard.*;

import java.util.ArrayList;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj.DriverStation;
//import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
//import frc.robot.mapping.Xbox;

import frc.robot.commands.drive.*;
//import frc.robot.commands.limelight.*;
//import frc.robot.OI;

import frc.robot.subsystems.*;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  public static DriveS mDriveS;
  public static LimeLight mLimeLight;
  public static LaunchS mLaunchS;
  public static EnergyIntakeS mEnergyIntakeS;
  public static ElevateS mElevateS;
  public static LockS mLockS;
  public static OI mOI;
  public static AutonomousBrainC theBrain;
  public static ArrayList<Command> list = new ArrayList<Command>();
  //public static Shuffler shuffle;

  //A mess with Shuffleboard
  ShuffleboardTab auto = Shuffleboard.getTab("Autonomous");/*feel free to add things of use to these */
  ShuffleboardTab tele = Shuffleboard.getTab("Teleop");
  NetworkTableEntry locStart = auto.add("Location from Center", 1).withWidget(BuiltInWidgets.kNumberSlider).getEntry();

  @Override
  public void robotInit() {

    mDriveS = new DriveS();
    mLimeLight = new LimeLight();
    mLaunchS = new LaunchS();
    mEnergyIntakeS = new EnergyIntakeS();
    mElevateS = new ElevateS();
    mLockS = new LockS();
    mOI = new OI();

    // Sensors
    CameraServer.getInstance().startAutomaticCapture();
    CameraServer.getInstance().startAutomaticCapture();
  }

  /**
   * This function is called every robot packet, no matter the mode. Use this for
   * items like diagnostics that you want ran during disabled, autonomous,
   * teleoperated and test.
   *
   * <p>
   * This runs after the mode specific periodic functions, but before LiveWindow
   * and SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    Scheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {

  }

  @Override
  public void disabledPeriodic() {
    Scheduler.getInstance().run();
  }

  
  @Override
  public void autonomousInit() {
    Shuffleboard.selectTab("Autonomous");
    //double turn = Math.atan(120.0/((locStart.getDouble(1.0)*160.5)-65.84));
    list.add(new DriveForwardC(1.0, 1.0));
    //list.add(new DriveForwardC(0.0, 1.0));
    /*if(turn >= 0){
      list.add(new TurnTo(90));
    } else {
      list.add(new TurnTo(-90));
    }
    list.add(new TurnTo(turn+180));
    list.add(new DriveForwardC(1.0, 1.35));/*Just to get it closer to target*/
    theBrain = new AutonomousBrainC(list); 
    //mDriveS.tankDrive(-1, 1, 0.101);
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    theBrain.start();
    if (theBrain.isRunning())
      System.out.println("running");
    else
      System.out.println("Not Running");
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    Shuffleboard.selectTab("Teleop");
    //theBrain.cancel();
    Scheduler.getInstance().run();

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}

