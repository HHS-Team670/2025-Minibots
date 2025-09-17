package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;

public class FollowLine extends Command {
    private ReflectiveSensor sensor;

    private double speed;
    private Drivetrain drivetrain;
    private double turnSpeed;
    private static double topInterval = 0.80;

    public FollowLine() {
        this.sensor = ReflectiveSensor.getInstance();
        this.speed = 1;
        this.drivetrain = Drivetrain.getInstance();
        this.turnSpeed = 0.75;
        addRequirements(drivetrain, sensor);
    }
    
    public boolean isLeft() {
        return this.sensor.leftValue() <= topInterval;
    }

    public boolean isRight() {
        return this.sensor.rightValue() <= topInterval;
    }

    @Override
    public void initialize() {
        this.drivetrain.arcadeDrive(0, 0);
    }

    @Override
    public void execute() {
        if (isLeft() && isRight()) {
            this.drivetrain.arcadeDrive(this.speed, 0);
        } else if (!isLeft() && isRight()) {
            this.drivetrain.arcadeDrive(0, -this.turnSpeed);
        } else if (isLeft() && !isRight()) {
            this.drivetrain.arcadeDrive(0, this.turnSpeed);
        }
    }

    @Override
    public boolean isFinished() {
        return (!isLeft() && !isRight());
    }

    @Override
    public void end(boolean interrupted) {
        this.drivetrain.arcadeDrive(0, 0);
    }
}