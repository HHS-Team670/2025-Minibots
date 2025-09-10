package frc.robot.commands.drivetrain;

import frc.robot.subsystems.Catapult;
import frc.robot.subsystems.Catapult.CatapultMode;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class SetCatapult extends InstantCommand {
  Catapult mCatapult;
  CatapultMode mode;

  public SetCatapult(CatapultMode mode) {
    this.mode = mode;
    mCatapult = Catapult.getInstance();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    mCatapult.setCatapultMode(mode);
  }
}