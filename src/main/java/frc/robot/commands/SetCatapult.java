package frc.robot.commands;

import frc.robot.subsystems.Catapult;
import frc.robot.subsystems.Catapult.CatapultMode;


import edu.wpi.first.wpilibj2.command.InstantCommand;

public class SetCatapult extends InstantCommand {

    private Catapult mCatapult;
    private CatapultMode mMode;
    
    public SetCatapult(CatapultMode mode)
    {
        this.mCatapult= Catapult.getInstance();
        mMode= mode;

    }
      
 @Override
  public void initialize() {
    mCatapult.setCatapultMode(mMode);
    }

  
}