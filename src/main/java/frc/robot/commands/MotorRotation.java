package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.DigitalOutput;

import java.util.Map;
import static java.util.Map.entry;

public class MotorRotation extends Command{
  DigitalOutput led;
  String message;
  String coded;
  int unit;
  int index;
  Map<Character, String> codeKey = Map.ofEntries(
    entry('a', ".-"),
    entry('b', "-..."),
    entry('c', "-.-."),
    entry('d', "-.."),
    entry('e', "."),
    entry('f', "..-."),
    entry('g', "--."),
    entry('h', "...."),
    entry('i', ".."),
    entry('j', ".---"),
    entry('k', "-.-"),
    entry('l', ".-.."),
    entry('m', "--"),
    entry('n', "-."),
    entry('o', "---"),
    entry('p', ".--."),
    entry('q', "--.-"),
    entry('r', ".-."),
    entry('s', "..."),
    entry('t', "-"),
    entry('u', "..-"),
    entry('v', "...-"),
    entry('w', ".--"),
    entry('x', "-..-"),
    entry('y', "-.--"),
    entry('z', "--.."),

    entry('1', ".----"),
    entry('2', "..---"),
    entry('3', "...--"),
    entry('4', "....-"),
    entry('5', "....."),
    entry('6', "-...."),
    entry('7', "--..."),
    entry('8', "---.."),
    entry('9', "----."),
    entry('0', "-----"),

    entry(' ', " ")
    );

  public MotorRotation(String message, int unit) {
    this.message = message.toLowerCase();
    this.unit = unit;
    this.led = new DigitalOutput(25);
  }

  public String wordsToMorse(String phrase){
    String ciphered = "";
    for(int i = 0; i < phrase.length(); i++){
      ciphered += codeKey.get(phrase.charAt(i));
    }
    return ciphered;
  }

  public void sleep(int time){
    try {
        Thread.sleep(time);
    } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        System.err.println("Thread interrupted during sleep: " + e.getMessage());
    }
  }

  @Override
  public void initialize() {
    this.coded = wordsToMorse(this.message);
  }

  @Override
  public void execute() {
    for (this.index = 0; this.index < coded.length(); this.index++){
      char type = this.coded.charAt(this.index);
      if (type == '.'){
        led.set(true);
        sleep(unit);
      }else if (type == '-'){
        led.set(true);
        sleep(3*unit);
      }
      led.set(false);
      if (type == ' '){
        sleep(unit);
      }else{
        sleep(7*unit);
      }
    }
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
