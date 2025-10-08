package frc.robot.commands.LED;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.LED;
import frc.robot.subsystems.LED.LEDMode;

public class SetLED extends InstantCommand{

    private LEDMode mode;

    private LED led;

    public SetLED(LEDMode mode) {
        this.mode = mode;
        this.led = LED.getInstance();
    }

    @Override
    public void initialize() {
        led.setMode(this.mode);
    }
}
