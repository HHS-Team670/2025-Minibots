package frc.robot.commands.auton;

import edu.wpi.first.wpilibj2.command.InstantCommand;

public class StopFollow extends InstantCommand {
    
    public boolean BState;

    @Override
    public void initialize(){
        LineFollow.IsFollowing = false;
    }
        
}