package frc.robot.commands.auton;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;

public class LineFollow extends Command {
    private ReflectiveSensor sensor;

    private double speed;
    private Drivetrain drivetrain;
    private double turnSpeed;

    public LineFollow(double speed, double turnSpeed) {
        this.sensor = ReflectiveSensor.getInstance();
        this.speed = speed;
        this.drivetrain = Drivetrain.getInstance();
        this.turnSpeed = turnSpeed;
    }

    @Override
    public void initialize() {
        
    }

    public boolean isLeft() {
        return this.sensor.leftValue() >= 0.75 && this.sensor.rightValue() <= 0.9;
    }

    public boolean isRight() {
        return this.sensor.rightValue() >= 0.75 && this.sensor.rightValue() <= 0.9;
    }

    @Override
    public void execute() {
        System.out.println(this.sensor.rightValue() + ", " + this.sensor.leftValue());

        if (isLeft() && isRight()) {
            drivetrain.arcadeDrive(speed, 0);
        } else if (!isLeft() && isRight()) {
            drivetrain.arcadeDrive(0, turnSpeed);
        } else if (isLeft() && !isRight()) {
            drivetrain.arcadeDrive(0, turnSpeed);
        }
    }

    @Override
    public boolean isFinished() {
        return !isLeft() && !isRight();
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("Finished with line");
    }
}
