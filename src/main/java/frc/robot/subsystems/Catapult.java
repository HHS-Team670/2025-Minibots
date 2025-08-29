// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.xrp.XRPMotor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Catapult extends SubsystemBase {
  public enum CatapultMode {
    ON(0.75),
    OFF(0);

    private double speed;

    private CatapultMode(double speed) {
      this.speed = speed;
    }

    public double getSpeed() {
      return this.speed;
    }
  }

  private final XRPMotor motor;

  // Stores the instance to avoid multiple instances of the same subsystem
  private static Catapult mInstance = null;

  public static synchronized Catapult getInstance() {
    mInstance = mInstance == null ? new Catapult() : mInstance;
    return mInstance;
  }

  // Creates a new catapult
  private Catapult() {
    motor = new XRPMotor(2);
  }

  public void setCatapultMode(CatapultMode catapultMode) {
    setSpeed(catapultMode.getSpeed());
  }

  private void setSpeed(double speed) {
    motor.set(speed);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}