package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;

public class FollowLine extends Command {
  private Drivetrain mDrivetrain;
  private ReflectiveSensor mReflectiveSensor;


  public FollowLine() {
  this.mDrivetrain = Drivetrain.getInstance();
  this.mReflectiveSensor = ReflectiveSensor.getInstance();
  addRequirements(mDrivetrain,mReflectiveSensor);


  
  }

  @Override
  public void initialize() {
  }

  @Override
  public void execute() {
    if (mReflectiveSensor.isLeftOn(0.8) && mReflectiveSensor.isRightOn(0.8)) {
        this.mDrivetrain.arcadeDrive(1, 0);
    } else if (!mReflectiveSensor.isLeftOn(0.8) && mReflectiveSensor.isRightOn(0.8)) {
        this.mDrivetrain.arcadeDrive(0, -0.75);
    } else if (mReflectiveSensor.isLeftOn(0.8) && !mReflectiveSensor.isRightOn(0.8)) {
        this.mDrivetrain.arcadeDrive(0, 0.75); 
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (!(mReflectiveSensor.isLeftOn(0.8) || mReflectiveSensor.isRightOn(0.8)));
  }
}