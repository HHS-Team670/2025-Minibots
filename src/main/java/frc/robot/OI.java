package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.SafeTravelRoute;
import frc.robot.commands.SetCatpult;
import frc.robot.commands.drivetrain.ArcadeDrive;
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
    XboxJoysticButtons.Driver_ButtonX.onTrue(new SetCatpult(CatapultMode.ON));
    XboxJoysticButtons.Driver_ButtonY.onTrue(new SetCatpult(CatapultMode.OFF));
<<<<<<< HEAD
    XboxJoysticButtons.Driver_ButtonA.onTrue(new SafeTravelRoute());
=======
    XboxJoysticButtons.Diver_Button.onTrue(new LineFollow(speed: 0.9; turnSpeed: 0.6);
>>>>>>> f0be3eca7a6d3b2234df92aa3686b4ad61647061
  }

  // Returns the command that will be set as the drive command during tele-op
  public static Command getTeleopDriveCommand() {
    return new ArcadeDrive(
    () -> -XboxJoysticButtons.driverUtils.getLeftStickY(), () -> -XboxJoysticButtons.driverUtils.getRightStickX());
  }
}
