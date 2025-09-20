package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;
import frc.robot.subsystems.ReflectiveSensor.Marker;

import edu.wpi.first.wpilibj2.command.Command;

public class CheckByTurn extends Command {

  private final Drivetrain mDrivetrain;
  private final ReflectiveSensor rSensor;

  private int direction;
  private double speed;
  private double startingAngle;
  
  public CheckByTurn(int direction, double speed, double ... startingAngle) {
    this.direction = direction;
    this.speed = speed;
    
    this.mDrivetrain = Drivetrain.getInstance();
    this.rSensor = ReflectiveSensor.getInstance();
    addRequirements(mDrivetrain, rSensor);
    
    this.startingAngle = (startingAngle.length > 0) ? startingAngle[0] : mDrivetrain.getGyroAngleX();
  }
  
  @Override
  public void initialize() {
    mDrivetrain.arcadeDrive(0, 0);
    mDrivetrain.resetEncoders();
  }

  @Override
  public void execute() {
    mDrivetrain.arcadeDrive(0, direction*this.speed);
  }

  @Override
  public void end(boolean interrupted) {
    if (direction == 1 && !this.isFinished()){
      new CheckByTurn(-1, speed, this.startingAngle);
    }
  }

  @Override
  public boolean isFinished() {
    return ((rSensor.isLeftOn(Marker.LINE) || rSensor.isRightOn(Marker.LINE)) ||
            (Math.abs(mDrivetrain.getGyroAngleX()-startingAngle) < 100));
  }
}