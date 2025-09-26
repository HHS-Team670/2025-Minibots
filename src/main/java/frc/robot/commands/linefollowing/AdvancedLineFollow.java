package frc.robot.commands.linefollowing;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.drivetrain.DriveForward;

public class AdvancedLineFollow extends SequentialCommandGroup{

    public AdvancedLineFollow() {
        addCommands(
            new LineFollow(0.75, 0.75),
            new DriveForward(0.85, 1),
            new TurnUntilLine(0.75, -1),
            new LineFollow(0.75, 0.75),
            new DriveForward(0.85, 1),
            new TurnUntilLine(0.75, 1),
            new LineFollow(0.75, 0.75)
        );
    }
    
}
