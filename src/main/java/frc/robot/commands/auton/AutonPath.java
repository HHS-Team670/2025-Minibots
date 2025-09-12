package frc.robot.commands.auton;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.FollowLine;
import frc.robot.commands.TestReflection;
import frc.robot.commands.drivetrain.DriveForward;
import frc.robot.commands.drivetrain.TurnDegrees;

public class AutonPath extends SequentialCommandGroup {
    // Sequentially runs commands in an auton path
    // NOTE: You can also create parallel command groups which run commands
    // simultaneously (these are also treated like commands and can be nested within
    // sequential command groups)
    public AutonPath() {
        addCommands(

            // new DriveForward(1, 14),
            // new TurnDegrees(1, 50),
            // new DriveForward(1, 24),
            // new TurnDegrees(-1, 50),
            // new DriveForward(1, 24)
            // new TestReflection()
            new FollowLine()
        );
    }
}