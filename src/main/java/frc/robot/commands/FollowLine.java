package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;
import frc.robot.subsystems.ReflectiveSensor.Marker;

public class FollowLine extends Command {
    private final ReflectiveSensor rSensor;
    private final Drivetrain drivetrain;

    private double speed;
    private double turnSpeed;

    public FollowLine() {
        this.rSensor = ReflectiveSensor.getInstance();
        this.speed = 1;
        this.drivetrain = Drivetrain.getInstance();
        this.turnSpeed = 0.75;
        addRequirements(drivetrain, rSensor);
    }

    @Override
    public void initialize() {
        this.drivetrain.arcadeDrive(0, 0);
    }

    @Override
    public void execute() {
        if (rSensor.isLeftOn(Marker.LINE) && rSensor.isRightOn(Marker.LINE)) {
            this.drivetrain.arcadeDrive(this.speed, 0);
        } else if (!rSensor.isLeftOn(Marker.LINE) && rSensor.isRightOn(Marker.LINE)) {
            this.drivetrain.arcadeDrive(0, -this.turnSpeed);
        } else if (rSensor.isLeftOn(Marker.LINE) && !rSensor.isRightOn(Marker.LINE)) {
            this.drivetrain.arcadeDrive(0, this.turnSpeed);
        }
    }

    @Override
    public boolean isFinished() {
        return (!rSensor.isLeftOn(Marker.LINE) && !rSensor.isRightOn(Marker.LINE));
    }

    @Override
    public void end(boolean interrupted) {
        this.drivetrain.arcadeDrive(0, 0);
    }
}