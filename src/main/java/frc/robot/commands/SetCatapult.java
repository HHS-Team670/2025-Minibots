package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Catapult;
import frc.robot.subsystems.Catapult.CatapultMode;

public class SetCatapult extends InstantCommand {
    private Catapult mCatapult;
    private CatapultMode catapultMode;

    public SetCatapult(CatapultMode catapultMode) {
        this.mCatapult = Catapult.getInstance();
        this.catapultMode = catapultMode;
        addRequirements(mCatapult);
    }

    @Override
    public void initialize() {
        mCatapult.setCatapultMode(catapultMode);
    }
}