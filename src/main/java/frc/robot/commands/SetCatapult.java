package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Catapult;
import frc.robot.subsystems.Catapult.CatapultMode;

public class SetCatapult extends InstantCommand{
    private final Catapult catapult;
    private final CatapultMode state;

    public SetCatapult(CatapultMode setState) {
        this.catapult = Catapult.getInstance();
        this.state = setState;
    }

    @Override
    public void initialize() {
        catapult.setCatapultMode(this.state);
    }
    
}