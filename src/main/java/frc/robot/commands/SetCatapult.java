package frc.robot.commands;

import frc.robot.joystickUtils.XboxJoysticButtons;
import frc.robot.subsystems.Catapult;
import frc.robot.subsystems.Catapult.CatapultMode;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class SetCatapult extends InstantCommand {

    private Catapult mCatapult;
    
    public SetCatapult()
    {
        this.mCatapult= Catapult.getInstance();
    }
      
 @Override
  public void initialize() {
    mCatapult.setCatapultMode(CatapultMode.ON);
    }

  
}