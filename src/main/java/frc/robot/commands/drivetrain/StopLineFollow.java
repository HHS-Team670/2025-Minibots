package frc.robot.commands.drivetrain;

import edu.wpi.first.wpilibj2.command.Command;

public class StopLineFollow extends Command{
    
    public StopLineFollow () {
        LineFollowing.ForceStop = true;
    }
}
