package frc.robot.commands.linefollowing;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ReflectiveSensor;

public class SafeTravelRoute extends SequentialCommandGroup {
    // Sequentially runs commands in an auton path
    // NOTE: You can also create parallel command groups which run commands
    // simultaneously (these are also treated like commands and can be nested within
    // sequential command groups)
    private static final double forwardSpeed = 0.6;
    private static final double turnForwardSpeed = 0.8;
    private static final double rotateSpeed = 0.6;
    private static final double colorValue = 0.7;

    private static final double turnSpeed = 0.8;

    public SafeTravelRoute() {
        addCommands(
                new LineFollowing(forwardSpeed, turnForwardSpeed, rotateSpeed),
                new TurnUntilLine(turnSpeed * -1),
                new LineFollowing(forwardSpeed, turnForwardSpeed, rotateSpeed),
                new TurnUntilLine(turnSpeed),
                new LineFollowing(forwardSpeed, turnForwardSpeed, rotateSpeed));
    }

    public static boolean rightSensorDetectsLine() {
        return ReflectiveSensor.getInstance().rightValue() > colorValue;
    }

    public static boolean leftSensorDetectsLine() {
        return ReflectiveSensor.getInstance().leftValue() > colorValue;
    }
}