package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;
import edu.wpi.first.wpilibj2.command.Command;

public class Turn extends Command {
    ReflectiveSensor rf;
    Drivetrain mDrivetrain;
    double lValue, rValue, tapeColor = 0.8;

    public Turn () {
        this.rf = ReflectiveSensor.getInstance();
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

        mDrivetrain.arcadeDrive(1,0.8);
    }

    @Override
    public boolean isFinished() {
        return (lValue >= tapeColor && rValue >= tapeColor);
    }

    @Override
    public void end(boolean interrupted) {
    }
}
