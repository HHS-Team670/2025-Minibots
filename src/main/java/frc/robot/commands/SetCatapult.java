package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Catapult;
import frc.robot.subsystems.Catapult.CatapultMode;

public class SetCatapult extends InstantCommand {
Catapult x;

  public SetCatapult() {
    x = Catapult.getInstance();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    x.setCatapultMode(CatapultMode.ON); 
  }
}