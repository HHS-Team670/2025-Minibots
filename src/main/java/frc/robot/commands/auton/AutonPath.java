package frc.robot.commands.auton;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.LineFollowing;
import frc.robot.commands.TurnLineFollowing;
import frc.robot.commands.drivetrain.ArcadeDrive;
import frc.robot.subsystems.Drivetrain;

public class AutonPath extends SequentialCommandGroup {
    private Drivetrain drivetrain;
    // Sequentially runs commands in an auton path
    // NOTE: You can also create parallel command groups which run commands
    // simultaneously (these are also treated like commands and can be nested within
    // sequential command groups)
    public AutonPath() {
        //addCommands(
        //        drivetrain.arcadeDrive(1, 0) );
            
    }
}