package frc.robot.subsystems;

import edu.wpi.first.wpilibj.xrp.XRPRangefinder;

public class UltrasonicSensor {
    private static UltrasonicSensor mInstance = null;

    public static synchronized UltrasonicSensor getInstance() {
        mInstance = mInstance == null ? new UltrasonicSensor() : mInstance;
        return mInstance;
    }

    private XRPRangefinder mRangefinder;

    private UltrasonicSensor() {
        mRangefinder = new XRPRangefinder();
    }
    
    public double inches() {
        return mRangefinder.getDistanceInches();
    }

    public double centimeters() {
        return 100 * mRangefinder.getDistanceMeters();
    }
}
