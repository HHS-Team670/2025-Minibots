package frc.robot.commands.auton;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.FollowLine;
import frc.robot.commands.SetCatapult;
import frc.robot.commands.testing.Reflection;
import frc.robot.commands.testing.Test;
import frc.robot.subsystems.Catapult;
import frc.robot.subsystems.Catapult.CatapultMode;
import frc.robot.commands.testing.CheckByTurn;

public class AutonPath extends SequentialCommandGroup {
    // Sequentially runs commands in an auton path
    // NOTE: You can also create parallel command groups which run commands
    // simultaneously (these are also treated like commands and can be nested within
    // sequential command groups)

    

    public AutonPath() {
        addCommands(
            // new Reflection()
            new Test()
        );
    }
}