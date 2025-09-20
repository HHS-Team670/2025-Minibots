package frc.robot.commands.testing;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Catapult;
import frc.robot.subsystems.Catapult.CatapultMode;

public class Test extends InstantCommand{

    private Catapult catapult = Catapult.getInstance();

    public Test () {

    }

    @Override
    public void initialize(){
        catapult.setCatapultMode(CatapultMode.ON);
    }

}
