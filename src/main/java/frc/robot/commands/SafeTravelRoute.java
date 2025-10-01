package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.ReflectiveSensor;

public class SafeTravelRoute extends SequentialCommandGroup {
    // Sequentially runs commands in an auton path
    // NOTE: You can also create parallel command groups which run commands
    // simultaneously (these are also treated like commands and can be nested within
    // sequential command groups)
    private static final double forwardDriveSpeed = 0.6;
    private static final double turnSpeedTurn = 0.8;

    private static final double turnSpeedLine = 0.8;

    public SafeTravelRoute() {
        addCommands(
                new LineFollowing(forwardDriveSpeed, turnSpeedLine),
                new TurnLineFollowing(-1 * turnSpeedTurn),
                new LineFollowing(forwardDriveSpeed, turnSpeedLine),
                new TurnLineFollowing(turnSpeedTurn),
                new LineFollowing(forwardDriveSpeed, turnSpeedLine)

        );
        System.out.println("I HAVE FINISHED SAFE TRAVEL ROUTE");
               
            }
    
}

