package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.DigitalOutput;

public class EasterEgg extends Command{
  DigitalOutput led;
  String message;
  int index;

  public EasterEgg(String message) {
    this.message = message;
    this.led = new DigitalOutput(25);
  }
  @Override
  public void initialize() {
    this.index = 0;
  }

  @Override
  public void execute() {
    this.message.charAt(this.index);
    led.set(true);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    this.led.set(false);
    this.led.close();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (this.message.length() == this.index);
  }
}
