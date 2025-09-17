package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.drivetrain.ArcadeDrive;
import frc.robot.joystickUtils.XboxJoysticButtons;
import frc.robot.subsystems.Drivetrain;
import frc.robot.commands.catapult.SetCatapult;
import frc.robot.subsystems.Catapult.CatapultMode;
import frc.robot.commands.auton.StopFollow;
import frc.robot.commands.auton.LineFollow;

public final class OI {
  public boolean Bstate = false;
  // Controllers
  public static XboxController driver = new XboxController(0);

  public static XboxController getDriverController() {
    return driver;
  }

  public static void configureDefaultDriveCommand(){
    // Set the default drive command of the drivebase to the teleop drive command
    Drivetrain mDrivetrain = Drivetrain.getInstance();
    mDrivetrain.setDefaultCommand(getTeleopDriveCommand());
  }

  public static void configureDriverControls() {
    XboxJoysticButtons.Driver_ButtonA.onTrue(new SetCatapult(CatapultMode.ON));
    XboxJoysticButtons.Driver_ButtonA.onFalse(new SetCatapult(CatapultMode.OFF));

    XboxJoysticButtons.Driver_ButtonB.onTrue(new LineFollow(1,0.5));
    XboxJoysticButtons.Driver_ButtonX.onTrue(new StopFollow());
  }

  // Returns the command that will be set as the drive command during tele-op
  public static Command getTeleopDriveCommand() {
    return new ArcadeDrive(
    () -> -XboxJoysticButtons.driverUtils.getLeftStickY(), () -> -XboxJoysticButtons.driverUtils.getRightStickX());
  }
}