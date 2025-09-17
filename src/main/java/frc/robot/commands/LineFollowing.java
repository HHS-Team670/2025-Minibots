package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;
import edu.wpi.first.wpilibj2.command.Command;

public class LineFollowing extends Command{
    ReflectiveSensor rf;
    Drivetrain mDrivetrain;
    double lValue, rValue, tapeColor = 0.5;

    public LineFollowing (ReflectiveSensor rf) {
        this.rf = rf;
        this.mDrivetrain = Drivetrain.getInstance();
        addRequirements(mDrivetrain);
    }

    @Override
    public void initialize () {
    }

    @Override
    public void execute () {
        lValue = rf.leftValue();
        rValue = rf.rightValue();
        
        
// In future change to move forward while turning

        if (lValue <= tapeColor && rValue <= tapeColor) {
            // continue going forward
            mDrivetrain.arcadeDrive(1,0);
        }
        else if (lValue <= tapeColor && rValue != tapeColor ) {
            // turn left
            mDrivetrain.arcadeDrive(0,-1);
        }
        else if (lValue != tapeColor && rValue <= tapeColor) {
            // turn right
            mDrivetrain.arcadeDrive(0,1);
        }
    }

    @Override
    public boolean isFinished() {
        return (lValue >= tapeColor && rValue >= tapeColor);
    }

    @Override
    public void end(boolean interrupted) {
    }
}
