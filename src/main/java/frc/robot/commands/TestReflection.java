package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.ReflectiveSensor;
import java.io.IOException;

public class TestReflection extends Command{

    ReflectiveSensor reflectiveSensor;

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

  public TestReflection() {
    this.reflectiveSensor = ReflectiveSensor.getInstance();
  }
  @Override
  public void initialize() {
  }
  @Override
  public void execute() {
    clearScreen();
    System.out.println(reflectiveSensor.leftValue());
    System.out.println(reflectiveSensor.rightValue());
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
