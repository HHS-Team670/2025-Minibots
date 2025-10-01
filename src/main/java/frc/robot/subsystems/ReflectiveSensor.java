package frc.robot.subsystems;

import edu.wpi.first.wpilibj.xrp.XRPReflectanceSensor;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.Catapult.CatapultMode;
import frc.robot.commands.drivetrain.ArcadeDrive;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.SetCatapult;
import frc.robot.joystickUtils.XboxJoysticButtons;
import frc.robot.subsystems.Drivetrain;

public class ReflectiveSensor extends SubsystemBase {
    // Stores the instance to avoid multiple instances of the same subsystem
    private static ReflectiveSensor mInstance = null;

    public static synchronized ReflectiveSensor getInstance() {
        mInstance = mInstance == null ? new ReflectiveSensor() : mInstance;
        return mInstance;
    }

    private XRPReflectanceSensor mReflectanceSensor;

    // main
    private ReflectiveSensor() {
        mReflectanceSensor = new XRPReflectanceSensor();
    }

    public double leftValue() {
        return mReflectanceSensor.getLeftReflectanceValue();
    }

    public double rightValue() {
        return mReflectanceSensor.getRightReflectanceValue();
    }

    public boolean leftOnTrack() {
        return leftValue() > 0.7;
    }

    public boolean rightOnTrack() {
        return rightValue() > 0.7;
    }

    public void periodic() {
        // This method will be called once per scheduler run
        // ???
    }

}