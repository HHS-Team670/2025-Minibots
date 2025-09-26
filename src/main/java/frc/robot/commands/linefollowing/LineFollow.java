package frc.robot.commands.linefollowing;

import edu.wpi.first.wpilibj2.command.Command;
// import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.Drivetrain;

public class LineFollow extends Command {

    private double speed;
    private Drivetrain drivetrain;
    private double turnSpeed;
    // private static float bottomInterval = 0.0f;

    public LineFollow(double speed, double turnSpeed) {
        this.speed = speed;
        this.drivetrain = Drivetrain.getInstance();
        this.turnSpeed = turnSpeed;
        addRequirements(this.drivetrain);
    }

    @Override
    public void initialize() {
        drivetrain.arcadeDrive(0, 0);
    }

    @Override
    public void execute() {
        System.out.println(SensorMethods.sensor.rightValue() + ", " + SensorMethods.sensor.leftValue());

        if (SensorMethods.isLeft() && SensorMethods.isRight()) {
            this.drivetrain.arcadeDrive(this.speed, 0);
            // System.out.println("Online");
        } else if (!SensorMethods.isLeft() && SensorMethods.isRight()) {
            this.drivetrain.arcadeDrive(this.speed, -this.turnSpeed);
            // System.out.println("swerve left");

        } else if (SensorMethods.isLeft() && !SensorMethods.isRight()) {
            this.drivetrain.arcadeDrive(this.speed, this.turnSpeed);
            // System.out.println("swerve right");

        }
    }

    @Override
    public boolean isFinished() {
        return !SensorMethods.isLeft() && !SensorMethods.isRight();
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("Finished following line");
        drivetrain.arcadeDrive(0, 0);
    }
}
