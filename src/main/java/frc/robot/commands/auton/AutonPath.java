package frc.robot.commands.auton;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.CheckByTurn;
import frc.robot.commands.FollowLine;
import frc.robot.commands.testing.LEDOnCommand;

public class AutonPath extends SequentialCommandGroup {
    public AutonPath() {
        addCommands(
            // new FollowLine()
            new LEDOnCommand()
        );
    }
}