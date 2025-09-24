package frc.robot.subsystems;

import edu.wpi.first.wpilibj.xrp.XRPReflectanceSensor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ReflectiveSensor extends SubsystemBase {
    public enum Marker {
        LINE(0.8);

        private double reflectiveValue;

        private Marker(double reflectiveValue) {
            this.reflectiveValue = reflectiveValue;
        }

        public double getVal(){
            return reflectiveValue;
        }
    }

    // Stores the instance to avoid multiple instances of the same subsystem
    private static ReflectiveSensor mInstance = null;

    public static synchronized ReflectiveSensor getInstance() {
        mInstance = mInstance == null ? new ReflectiveSensor() : mInstance;
        return mInstance;
    }

    private XRPReflectanceSensor mReflectanceSensor;

    private ReflectiveSensor() {
        mReflectanceSensor = new XRPReflectanceSensor();
    }

    public double leftValue() {
        return mReflectanceSensor.getLeftReflectanceValue();
    }

    public double rightValue() {
        return mReflectanceSensor.getRightReflectanceValue();
    }

    public boolean isLeftOn(double val) {
        return (leftValue() <= val);
    }

    public boolean isRightOn(double val) {
        return (rightValue() <= val);
    }
}