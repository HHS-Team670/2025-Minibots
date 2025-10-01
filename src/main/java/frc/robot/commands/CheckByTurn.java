package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;

public class CheckByTurn extends Command {
    private Drivetrain drivetrain;
    private ReflectiveSensor reflectiveSensor;
    private double turnSpeed;

    private boolean leftDetects;
    private boolean rightDetects;

    public CheckByTurn(double turnSpeed) {
        this.drivetrain = Drivetrain.getInstance();
        this.reflectiveSensor = ReflectiveSensor.getInstance();
        this.turnSpeed = turnSpeed;
        addRequirements(drivetrain, reflectiveSensor);
    }

    @Override
    public void initialize() {
        drivetrain.arcadeDrive(0, 0);
        drivetrain.resetEncoders();
    }

    @Override
    public void execute() {
        leftDetects = SafeTravelRoute.leftSensorDetectsLine();
        rightDetects = SafeTravelRoute.rightSensorDetectsLine();

        drivetrain.arcadeDrive(0, turnSpeed);
    }

    @Override
    public boolean isFinished() {
        return leftDetects && rightDetects;
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.arcadeDrive(0, 0);
    }
}