package frc.robot.commands.linefollowing;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class StopLineFollow extends InstantCommand{
    @Override
    public void initialize() {
        System.out.println("Tried to stop");
        LineFollow.isLineFollowing = false;
    }
}
