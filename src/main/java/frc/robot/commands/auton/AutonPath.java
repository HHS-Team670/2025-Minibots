package frc.robot.commands.auton;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.drivetrain.DriveForward;
import frc.robot.commands.drivetrain.TurnDegrees;

public class AutonPath extends SequentialCommandGroup {
    // Sequentially runs commands in an auton path
    // NOTE: You can also create parallel command groups which run commands
    // simultaneously (these are also treated like commands and can be nested within
    // sequential command groups)
    public AutonPath() {
        addCommands(
            new DriveForward(1, 29),
            new TurnDegrees(1, -45),
            new DriveForward(1, 36),
            new TurnDegrees(1, 45),
            new DriveForward(1, 40)
        );
    }
}