package frc.robot.commands.auton;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;

public class LineFollow extends Command {
    private ReflectiveSensor sensor;
    private Drivetrain drivetrain;
    private double speed;
    private double turnSpeed;
    public static boolean IsFollowing = false;

  public 
  LineFollow(double speed, double turnSpeed) {
    this.sensor = ReflectiveSensor.getInstance();
    this.drivetrain = Drivetrain.getInstance();
    this.speed = speed;
    this.turnSpeed = turnSpeed;
    System.out.println(this.sensor);
  }
  
  public boolean isLeft() {
    return this.sensor.leftValue() > 0.8;
  }

  public boolean isRight() {
    return this.sensor.rightValue() > 0.8;
  }

  @Override
  public void initialize() {
  IsFollowing = true;
    
  }

  @Override
  public void execute() {
    if (isLeft() && isRight()){
      drivetrain.arcadeDrive(this.speed, 0);
    } else if (!isLeft() && isRight()) {
      drivetrain.arcadeDrive(0, -this.turnSpeed);
    } else if (isLeft() && !isRight()){
      drivetrain.arcadeDrive(0, this.turnSpeed);
    }
    System.out.println(this.sensor.leftValue() + ", " + this.sensor.rightValue());
}

@Override
public void end(boolean interrupted) {
  System.out.println("Finished line following");
}

@Override
public boolean isFinished(){
  return (!isLeft() && !isRight()) || !IsFollowing;
}
}