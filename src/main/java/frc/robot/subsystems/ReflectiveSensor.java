package frc.robot.subsystems;

import edu.wpi.first.wpilibj.xrp.XRPReflectanceSensor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ReflectiveSensor extends SubsystemBase {
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
}