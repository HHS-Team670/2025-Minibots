package frc.robot.commands.linefollowing;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;

public class LineFollowing extends Command {
  private Drivetrain drivetrain;
  private ReflectiveSensor reflectiveSensor;
  private double forwardSpeed;
  private double turnForwardSpeed;
  private double rotateSpeed;

  private boolean leftDetects;
  private boolean rightDetects;

  public LineFollowing(double forwardSpeed, double turnForwardSpeed, double rotateSpeed) {
    this.drivetrain = Drivetrain.getInstance();
    this.reflectiveSensor = ReflectiveSensor.getInstance();
    this.forwardSpeed = forwardSpeed;
    this.turnForwardSpeed = turnForwardSpeed;
    this.rotateSpeed = rotateSpeed;
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

    // move forward if both sensors detect less light than the color value
    if (leftDetects && rightDetects) {
      drivetrain.arcadeDrive(forwardSpeed, 0);
    } else if (leftDetects) {
      //If swerved too far right and only left sensor detects the tape, move forward and rotate left
      drivetrain.arcadeDrive(turnForwardSpeed, rotateSpeed);
    } else if (rightDetects) {
      drivetrain.arcadeDrive(turnForwardSpeed, -1  * rotateSpeed);
    }
  }

  @Override
  public boolean isFinished() {
    //If both sensors do not detect tape, the line following is finished
    return (!leftDetects && !rightDetects); // ould also be written as (!(leftDetects || rightDetects))
  }

  @Override
  public void end(boolean interrupted) {
    drivetrain.arcadeDrive(0, 0);
  }
}