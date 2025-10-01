package frc.robot.commands.drivetrain;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;

import edu.wpi.first.wpilibj2.command.Command;

public class LineFollowing extends Command {
  private final Drivetrain mDrivetrain;
  private final double speed;
  public static boolean ForceStop;
  private ReflectiveSensor reflector = ReflectiveSensor.getInstance();
  

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

  private boolean doesLeftDetect () {
    if (reflector.leftValue() > 0.7) {
      return true;
    }
    else {
      return false;
    }
  }

  private boolean doesRightDetect () {
    if (reflector.rightValue() > 0.7) {
      return true;
    }
    else {
      return false;
    }
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    mDrivetrain.arcadeDrive(0, 0);
    mDrivetrain.resetEncoders();
    ForceStop = false;
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (!ForceStop) {
      if (doesLeftDetect() && doesRightDetect()) { // straight
        mDrivetrain.arcadeDrive(speed, 0);
      }
    if (doesLeftDetect() && !doesRightDetect()) { //turns left
        mDrivetrain.arcadeDrive(speed, 0.5);
      }
    if (!doesLeftDetect() && doesRightDetect()) { //turns right
        mDrivetrain.arcadeDrive(speed, -0.5);
      }
    }
  }
  
  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("Line Following end");
    mDrivetrain.arcadeDrive(0, 0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // Compare distance travelled from start to desired distance
    return (!doesLeftDetect() && !doesRightDetect());
  }
}