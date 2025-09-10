package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Catapult;
import frc.robot.subsystems.Catapult.CatapultMode;

public class SetCatapult extends Command { // or extends InstantCommand

//Instant command only runs so dont need end and isfinished
//Single Tin

  Catapult catapult;
  CatapultMode mode;
  public SetCatapult(CatapultMode mode) {
    catapult = Catapult.getInstance();
    this.mode = mode;
  }
  
  @Override
  public void initialize() {
        catapult.setCatapultMode(mode);
  }

}