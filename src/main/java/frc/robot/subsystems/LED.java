package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class LED extends SubsystemBase{
    private static LED instance;

    private static DigitalOutput led = new DigitalOutput(25);

    public enum LEDMode {
        ON(0, 0),
        OFF(1, 0),
        BLINK(2, 1);

        private int mode;
        private double rate;

        private LEDMode(int mode, double rate) {
            this.mode = mode;
            this.rate = rate;
        }
    }

    private LED() {
        led.set(false);
    }

    public static LED getInstance() {
        if (instance == null) {
            return new LED();
        }
        return instance;
    }

    public void setMode(LEDMode mode) {
        led.set(false);

        if (mode == LEDMode.ON) {
            led.set(true);
        } else if (mode == LEDMode.OFF) {
            led.set(false);
        } else {
            led.setPWMRate(mode.rate);
        }
    }

    public int getModeIndex(LEDMode mode) {
        return mode.mode;
    }
}
