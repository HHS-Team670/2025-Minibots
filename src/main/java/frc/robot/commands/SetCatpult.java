package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Catapult;
import frc.robot.subsystems.Catapult.CatapultMode;


public class SetCatpult extends InstantCommand {
  private Catapult catapult;
  CatapultMode mode;
  public SetCatpult(CatapultMode mode){
    this.catapult = Catapult.getInstance();
    this.mode = mode;
  }
  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    catapult.setCatapultMode(this.mode);
    
  }

} 