package frc.robot.commands.linefollowing;

import edu.wpi.first.wpilibj2.command.Command;
// import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.Drivetrain;

public class TurnUntilLine extends Command{
    private Drivetrain drivetrain;
    private double turnSpeed;
    private int direction;


    public TurnUntilLine(double speed, int dir) {
        this.drivetrain = Drivetrain.getInstance();
        this.turnSpeed = speed;
        this.direction = dir;
        addRequirements(this.drivetrain);
    }

    @Override
    public void initialize() {
        drivetrain.arcadeDrive(0, 0);
        System.out.println("Started turning until line.");
    }

    @Override
    public void execute() {
        // turn in direction with speed
        System.out.println("Turning");
        this.drivetrain.arcadeDrive(0, this.turnSpeed*this.direction);
    }

    @Override
    public boolean isFinished() {
        // If you are lined up with the line, finish.
        return (SensorMethods.isLeft() && SensorMethods.isRight());
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("Finished Turning");
        drivetrain.arcadeDrive(0, 0);
    }
}
