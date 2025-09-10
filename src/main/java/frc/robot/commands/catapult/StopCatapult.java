package frc.robot.commands.catapult;

import frc.robot.subsystems.Catapult;
import frc.robot.subsystems.Catapult.CatapultMode;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class StopCatapult extends InstantCommand {
    private final Catapult catapult;

  public StopCatapult() {
    this.catapult = Catapult.getInstance();
  }

  @Override
  public void initialize() {
    catapult.setCatapultMode(CatapultMode.OFF);
  }

}