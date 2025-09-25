package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;
import edu.wpi.first.wpilibj2.command.Command;

public class Turn extends Command {
    ReflectiveSensor rf;
    Drivetrain mDrivetrain;
    double lValue, rValue, tapeColor = 0.8;
    int direction;

    public Turn (int direction) {
        this.rf = ReflectiveSensor.getInstance();
        this.mDrivetrain = Drivetrain.getInstance();
        addRequirements(mDrivetrain);

        this.direction = direction;
    }

    @Override
    public void initialize () {
    }

    @Override
    public void execute () {
        lValue = rf.leftValue();
        rValue = rf.rightValue();

        mDrivetrain.arcadeDrive(0.6, 0.8 * direction);
    }

    @Override
    public boolean isFinished() {
        return (lValue >= tapeColor && rValue >= tapeColor);
    }

    @Override
    public void end(boolean interrupted) {
    }
}
