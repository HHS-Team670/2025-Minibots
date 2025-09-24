package frc.robot.commands.catapult;

import frc.robot.subsystems.Catapult;
import frc.robot.subsystems.Catapult.CatapultMode;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class SetCatapult extends InstantCommand {
    private final Catapult catapult;
    private final CatapultMode mode;

  public SetCatapult(CatapultMode mode) {
    this.catapult = Catapult.getInstance();
    this.mode = mode;
  }

  @Override
  public void initialize() {
    catapult.setCatapultMode(this.mode);
    
  }

}