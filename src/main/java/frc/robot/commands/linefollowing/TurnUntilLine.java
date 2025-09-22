package frc.robot.commands.linefollowing;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;

public class TurnUntilLine extends Command{
    private ReflectiveSensor sensor;

    private Drivetrain drivetrain;
    private double turnSpeed;
    private int direction;
    private static float bottomInterval = 0.0f;
    private static float topInterval = 0.86f;


    public TurnUntilLine(double speed, int dir) {
        this.sensor = ReflectiveSensor.getInstance();
        this.drivetrain = Drivetrain.getInstance();
        this.turnSpeed = speed;
        this.direction = dir;
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
        // turn in direction with speed
        System.out.println("Test");
        this.drivetrain.arcadeDrive(0, this.turnSpeed*this.direction);
    }

    @Override
    public boolean isFinished() {
        // If you are lined up with the line, finish.
        return isLeft() && isRight();
    }

    @Override
    public void end(boolean interrupted) {
        drivetrain.arcadeDrive(0, 0);
    }
}
