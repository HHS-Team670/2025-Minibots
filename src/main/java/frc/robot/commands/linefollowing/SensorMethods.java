package frc.robot.commands.linefollowing;

import frc.robot.subsystems.ReflectiveSensor;

public class SensorMethods {
    //Blue on gray
    // public static float topInterval = 0.85f;
    // Black on white
    public static float topInterval = 0.89f;
    public static ReflectiveSensor sensor = ReflectiveSensor.getInstance();


    // Blue on gray
    // public static boolean isLeft() {
    //     return sensor.leftValue() <= topInterval;
    // }

    // public static boolean isRight() {
    //     return sensor.rightValue() <= topInterval;
    // }

    // Black on white

    public static boolean isLeft() {
        return sensor.leftValue() >= topInterval;
    }

    public static boolean isRight() {
        return sensor.rightValue() >= topInterval;
    }
}
