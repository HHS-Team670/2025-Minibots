package frc.robot.commands.testing;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;
import frc.robot.subsystems.ReflectiveSensor.Marker;

import edu.wpi.first.wpilibj2.command.Command;

public class CheckByTurn extends Command {

  private final Drivetrain mDrivetrain;
  private final ReflectiveSensor rSensor;

  private int direction;
  private double speed;
  
  public CheckByTurn(int direction, double speed) {
    this.direction = direction;
    this.speed = speed;
    this.mDrivetrain = Drivetrain.getInstance();
    this.rSensor = ReflectiveSensor.getInstance();
    
    addRequirements(mDrivetrain, rSensor);
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
    mDrivetrain.arcadeDrive(0, direction*speed);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}