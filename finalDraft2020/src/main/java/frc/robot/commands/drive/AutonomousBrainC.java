package frc.robot.commands.drive;

import java.util.*;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class AutonomousBrainC extends Command {
  private ArrayList<Command> instructionOrg = null;
  private int stage = -1;
  private int stageL = -1;
  private int numOfStages;
  private boolean stageComplete = true;
  private double distanceO = 0;
  private double distanceC = 0;
  
  /* By having the ArrayList<Command> you can pass it whatever Command you want 
   * and it will run it on its turn before moving onto the next when the command is complete*/
  public AutonomousBrainC(ArrayList<Command> instructions) {
    instructionOrg = instructions;
  }
  
  @Override
  protected void execute() {
    if(stage == stageL && (stageComplete || distanceO == distanceC)){
      stage++; /*checks to see if current stage is completed before moving on*/
      stageComplete = false;
      Robot.mDriveS.tankDrive(0.0, 0.0, 0.0);
      if(stage<3)
      instructionOrg.get(stage).start();
    }
    else{
        stageComplete = instructionOrg.get(stage).isCompleted();
        if(!stageComplete){
          instructionOrg.get(stage).start();
        }
    }
    stageL = stage; /*insures that the starting check works*/
  }

  @Override
  protected void initialize() {
    setTimeout(15); /*Sets timeout to the same as the autonomous period*/
    numOfStages = instructionOrg.size();
  }
  
  @Override
  protected boolean isFinished() {
    System.out.println(stage);
    if(stage == numOfStages-1){
      return true;
    }
    
    return isTimedOut(); /*returns if the autonomous period has passed*/
  }
  
  @Override
  protected void end() {
    Robot.mDriveS.tankDrive(0.0, 0.0, 0.0); /*stops robot, allowing for transition to human control*/
    
  }
  
  @Override
  protected void interrupted() {
      //instructionOrg.get(stage).cancel(); /*should do nothing but is just a precaution*/
      end();
  }
}
