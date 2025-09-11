package frc.robot.commands.auton;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
<<<<<<< HEAD
=======
import frc.robot.commands.drivetrain.DriveForward;
import frc.robot.commands.drivetrain.TurnDegrees;
>>>>>>> 5a122bb (Create setCatapult, working on FollowLine)

public class AutonPath extends SequentialCommandGroup {
    // Sequentially runs commands in an auton path
    // NOTE: You can also create parallel command groups which run commands
    // simultaneously (these are also treated like commands and can be nested within
    // sequential command groups)
    public AutonPath() {
        addCommands(
<<<<<<< HEAD
=======
            new DriveForward(1, 14),
            new TurnDegrees(1, 50),
            new DriveForward(1, 24),
            new TurnDegrees(-1, 50),
            new DriveForward(1, 24)
>>>>>>> 5a122bb (Create setCatapult, working on FollowLine)
        );
    }
}