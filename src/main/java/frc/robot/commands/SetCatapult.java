package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Catapult;

public class SetCatapult extends Command { // or extends InstantCommand

//Instant command only runs so dont need end and isfinished
//Single Tin

  Catapult catapult;

  public SetCatapult() {
    catapult = Catapult.getInstance();
  }

  
  
  @Overide
  public void initialize() {
    catapult.setCatapultMode(CatapultMode.ON);
  }


  // @Override
  // public void execute() {
  //   //
  // }


  // @Override
  // public void end(boolean interrupted) {

  // }


  // @Override
  // public boolean isFinished() {
  //   return false;
  // }
}