package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
// import frc.robot.commands.drivetrain.DriveForward;
// import frc.robot.commands.drivetrain.TurnDegrees;
import frc.robot.commands.Turn;
import frc.robot.commands.LineFollowing;

// Hardcode direction not degrees

// Direction
// 1 for right
// -1 for left

public class LineFollowingCommand extends SequentialCommandGroup {
    public LineFollowingCommand() {
        addCommands (
            new LineFollowing(),
            new Turn(1),
            new LineFollowing(),
            new Turn(-1),
            new LineFollowing()

            
        );
    }
}