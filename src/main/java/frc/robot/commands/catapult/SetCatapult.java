package frc.robot.commands.catapult;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Catapult;
import frc.robot.subsystems.Catapult.CatapultMode;

public class SetCatapult extends InstantCommand{
    private final Catapult catapult;

    public SetCatapult() {
        this.catapult = Catapult.getInstance();
    }

    @Override
    public void initialize() {
        catapult.setCatapultMode(CatapultMode.ON);
    }
    
}
