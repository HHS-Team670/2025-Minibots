package frc.robot.commands.auton;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.drivetrain.LineFollowing;
import frc.robot.commands.drivetrain.TurnUntilLine;

public class SafeTravelRoute extends SequentialCommandGroup {
    // Sequentially runs commands in an auton path
    // NOTE: You can also create parallel command groups which run commands
    // simultaneously (these are also treated like commands and can be nested within
    // sequential command groups)
    public SafeTravelRoute() {
        while (!LineFollowing.ForceStop) {
            addCommands(
                new LineFollowing(0.75),
                new TurnUntilLine(-0.75),
                new LineFollowing(0.75),
                new TurnUntilLine(0.75),
                new LineFollowing(0.75)
            );
        }
    }
}