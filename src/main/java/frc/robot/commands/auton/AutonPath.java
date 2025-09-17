package frc.robot.commands.auton;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.FollowLine;
import frc.robot.commands.testing.Reflection;
import frc.robot.commands.testing.DriveForward;

public class AutonPath extends SequentialCommandGroup {
    // Sequentially runs commands in an auton path
    // NOTE: You can also create parallel command groups which run commands
    // simultaneously (these are also treated like commands and can be nested within
    // sequential command groups)
    public AutonPath() {
        addCommands(
            // new Reflection()
            new FollowLine()
            // new DriveForward(10, 0)
        );
    }
}