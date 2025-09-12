package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ReflectiveSensor;
import frc.robot.subsystems.Drivetrain;

public class FollowLine extends Command {

  ReflectiveSensor reflectiveSensor;
  Drivetrain drivtrain;

  double speed;
  double lineReflectionVal;
  double threshold;
  boolean rightOnLine;
  boolean leftOnLine;

  public FollowLine() {
    this.reflectiveSensor = ReflectiveSensor.getInstance();
    this.drivtrain = Drivetrain.getInstance();
    this.speed = 2;
    this.lineReflectionVal = 0.77;
    this.threshold = 0.06;
  }

  public static void clearScreen() {
    try {
        final String os = System.getProperty("os.name");

        if (os.contains("Windows")) {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } else {
            // For Linux/macOS
            new ProcessBuilder("clear").inheritIO().start().waitFor();
        }
    } catch (final Exception e) {
        // Handle exceptions, e.g., if the command fails
        System.out.println("Error clearing console: " + e.getMessage());
    }
}

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

  }

  public boolean rightOnLine(){
    return (Math.abs(this.reflectiveSensor.rightValue()-this.lineReflectionVal) <= this.threshold);
  }

  public boolean leftOnLine(){
    return (Math.abs(this.reflectiveSensor.leftValue()-this.lineReflectionVal) <= this.threshold);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (rightOnLine() && !leftOnLine()){
      
    }else if (!rightOnLine() && leftOnLine()){
      
    }else if (rightOnLine() && leftOnLine()){
      
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    clearScreen();
    System.out.println("You suck at coding");
    System.out.println(leftOnLine());
    System.out.println(rightOnLine());
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (!rightOnLine() && !leftOnLine());
  }
}