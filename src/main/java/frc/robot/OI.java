package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.drivetrain.ArcadeDrive;
import frc.robot.commands.drivetrain.LineFollowing;
import frc.robot.commands.drivetrain.SetCatapult;
import frc.robot.joystickUtils.XboxJoysticButtons;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Catapult.CatapultMode;

public final class OI {
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
    XboxJoysticButtons.Driver_Dpad_North.onTrue(new SetCatapult(CatapultMode.ON));
    XboxJoysticButtons.Driver_Dpad_South.onTrue(new SetCatapult(CatapultMode.OFF));
    XboxJoysticButtons.Driver_Dpad_East.onTrue(new LineFollowing(0.75));
  }

  // Returns the command that will be set as the drive command during tele-op
  public static Command getTeleopDriveCommand() {
    return new ArcadeDrive(
    () -> -XboxJoysticButtons.driverUtils.getLeftStickY(), () -> -XboxJoysticButtons.driverUtils.getRightStickX());
  }
}