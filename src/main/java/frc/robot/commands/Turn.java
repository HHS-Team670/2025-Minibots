package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.drivetrain.DriveForward;
import frc.robot.commands.drivetrain.TurnDegrees;

public class Turn extends SequentialCommandGroup {
    public Turn() {
        addCommands (
            new DriveForward(1, 12),
            new TurnDegrees(1, 90),
            new DriveForward(1, 8),
            new TurnDegrees(1, -90),
            new DriveForward(1, 12)
        );
    }
}