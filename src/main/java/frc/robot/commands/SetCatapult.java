package frc.robot.commands;
import frc.robot.subsystems.Catapult;
import frc.robot.subsystems.Catapult.CatapultMode;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class SetCatapult extends InstantCommand {
  Catapult catapult;
  CatapultMode mode;  
  public SetCatapult(CatapultMode setmodes){
    
    this.catapult = Catapult.getInstance();
    this.mode = setmodes;
      
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    catapult.setCatapultMode(this.mode);

  }




}