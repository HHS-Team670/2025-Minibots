package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ReflectiveSensor;

public class FollowLine extends Command {

  ReflectiveSensor reflectiveSensor;
  boolean rightOnLine;
  boolean leftOnLine;

  public FollowLine() {
    this.reflectiveSensor = ReflectiveSensor.getInstance();
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    this.rightOnLine = (Math.abs(this.reflectiveSensor.rightValue()-lineReflectionVal) <= threshold);
    this.leftOnLine = (Math.abs(this.reflectiveSensor.leftValue()-lineReflectionVal) <= threshold);
    if (this.rightOnLine && !this.leftOnLine){
      //move toward the right
    }else if (!this.rightOnLine && this.leftOnLine){
      //move toward the left
    }else if (this.rightOnLine && this.leftOnLine){
      //move forward
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {

  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (!this.rightOnLine && !this.leftOnLine);
  }
}