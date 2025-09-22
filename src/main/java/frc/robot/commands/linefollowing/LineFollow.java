package frc.robot.commands.linefollowing;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;

public class LineFollow extends Command {
    private ReflectiveSensor sensor;

    private double speed;
    private Drivetrain drivetrain;
    private double turnSpeed;
    private static float bottomInterval = 0.0f;
    private static float topInterval = 0.86f;

    public LineFollow(double speed, double turnSpeed) {
        this.sensor = ReflectiveSensor.getInstance();
        this.speed = speed;
        this.drivetrain = Drivetrain.getInstance();
        this.turnSpeed = turnSpeed;
        addRequirements(this.drivetrain, this.sensor);
    }

    @Override
    public void initialize() {
        drivetrain.arcadeDrive(0, 0);
    }

    public boolean isLeft() {
        return this.sensor.leftValue() >= bottomInterval && this.sensor.leftValue() <= topInterval;
    }

    public boolean isRight() {
        return this.sensor.rightValue() >= bottomInterval && this.sensor.rightValue() <= topInterval;
    }

    @Override
    public void execute() {
        System.out.println(this.sensor.rightValue() + ", " + this.sensor.leftValue());

        if (isLeft() && isRight()) {
            this.drivetrain.arcadeDrive(this.speed, 0);
            // System.out.println("Online");
        } else if (!isLeft() && isRight()) {
            this.drivetrain.arcadeDrive(this.speed, -this.turnSpeed);
            // System.out.println("swerve left");

        } else if (isLeft() && !isRight()) {
            this.drivetrain.arcadeDrive(this.speed, this.turnSpeed);
            // System.out.println("swerve right");

        }
    }

    @Override
    public boolean isFinished() {
        return !isLeft() && !isRight();
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("Finished following line");
        drivetrain.arcadeDrive(0, 0);
    }
}
