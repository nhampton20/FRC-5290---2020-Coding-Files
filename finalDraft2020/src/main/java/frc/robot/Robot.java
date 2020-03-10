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
//import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.TimedRobot;
//import frc.robot.mapping.Xbox;

import frc.robot.commands.drive.*;
//import frc.robot.commands.limelight.*;
//import frc.robot.OI;

import frc.robot.subsystems.*;


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
    //CameraServer.getInstance().startAutomaticCapture();
    // CameraServer.getInstance().startAutomaticCapture();
  }

  
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
  public void autonomousInit() {/*
    Shuffleboard.selectTab("Autonomous");
    double turn = Math.atan(120.0/((locStart.getDouble(1.0)*160.5)-65.84));
    if(turn >= 0){
      list.add(new TurnTo(90));
    } else {
      list.add(new TurnTo(-90));
    }
    list.add(new TurnTo(turn));
    list.add(new DriveForwardC(1, 2));/*Just to get it closer to target
    theBrain = new AutonomousBrainC(list); */
  }

  /**
   * This function is called periodically during autonomous.
   */
  @Override
  public void autonomousPeriodic() {
    //theBrain.start();
  }

  /**
   * This function is called periodically during operator control.
   */
  @Override
  public void teleopPeriodic() {
    //Shuffleboard.selectTab("Teleop");
   // /*if (theBrain.isRunning())*/theBrain.cancel();
    Scheduler.getInstance().run();
    System.out.println(mOI.xbox.rightTrigger());

  }

  /**
   * This function is called periodically during test mode.
   */
  @Override
  public void testPeriodic() {
  }
}

