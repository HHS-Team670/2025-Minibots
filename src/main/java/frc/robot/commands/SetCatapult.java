package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Catapult;
import frc.robot.subsystems.Catapult.CatapultMode;

public class SetCatapult extends InstantCommand {
  Catapult catapult;
  CatapultMode mode;
  public SetCatapult(CatapultMode mode) {
    catapult = Catapult.getInstance();
    this.mode = mode;
    addRequirements(catapult);
  }

  @Override
  public void initialize() {
    catapult.setCatapultMode(this.mode);
  }

}
