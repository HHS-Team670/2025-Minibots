package frc.robot.commands.drivetrain;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;
import edu.wpi.first.wpilibj2.command.Command;

public class LineFollowing extends Command {
  private final Drivetrain mDrivetrain;
  private final double speed;
  private ReflectiveSensor x = ReflectiveSensor.getInstance();
  

  /**
   * Creates a new DriveDistance. This command will drive your your robot for a desired distance at
   * a desired speed.
   *
   * @param speed The speed at which the robot will drive
   * @param inches The number of inches the robot will drive
   * @param drive The drivetrain subsystem on which this command will run
   */
  public LineFollowing(double speed) {
    this.speed = speed;
    this.mDrivetrain = Drivetrain.getInstance();
    addRequirements(mDrivetrain);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    mDrivetrain.arcadeDrive(0, 0);
    mDrivetrain.resetEncoders();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (x.leftValue() <= 0.8 && x.rightValue() <= 0.80) {
        mDrivetrain.arcadeDrive(speed, 0);
    }
    if (x.leftValue() <= 0.80 && x.rightValue() > 0.80) {
        mDrivetrain.arcadeDrive(speed, 0.5);
    }
    if (x.leftValue() > 0.80 && x.rightValue() <= 0.80) {
        mDrivetrain.arcadeDrive(speed, -0.5);
    }
    if (x.leftValue() > 0.80 && x.rightValue() > 0.80) {
        mDrivetrain.arcadeDrive(0, 0);
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    mDrivetrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Compare distance travelled from start to desired distance
    if (x.leftValue() > 0.80 && x.rightValue() > 0.80) {
      return Math.abs(mDrivetrain.getAverageDistanceInch()) >= 0;
    }
    else {
      return Math.abs(mDrivetrain.getAverageDistanceInch()) >= 1000000001;
    }
  }
}