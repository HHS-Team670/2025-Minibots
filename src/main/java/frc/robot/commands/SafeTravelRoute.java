package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ReflectiveSensor;

public class SafeTravelRoute extends SequentialCommandGroup {
    // Sequentially runs commands in an auton path
    // NOTE: You can also create parallel command groups which run commands
    // simultaneously (these are also treated like commands and can be nested within
    // sequential command groups)
    private static final double forwardSpeed = 0.8;
    private static final double turnSpeedTurn = 0.9;
    private static final double rotateSpeed = 0.6;
    private static final double colorValue = 0.7;

    private static final double turnSpeed = 1;

    public SafeTravelRoute() {
        addCommands(
                new LineFollow(forwardSpeed, turnSpeedTurn),
                new TurningLineFollowing(turnSpeed * -1),
                new LineFollow(forwardSpeed, turnSpeedTurn),
                new TurningLineFollowing(turnSpeed),
                new LineFollow(forwardSpeed, turnSpeedTurn));
    }

} 