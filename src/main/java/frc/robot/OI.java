package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.catapult.SetCatapult;
// import frc.robot.commands.catapult.SetCatapult;
import frc.robot.commands.drivetrain.ArcadeDrive;
import frc.robot.commands.linefollowing.AdvancedLineFollow;
import frc.robot.commands.linefollowing.StopLineFollow;
// import frc.robot.commands.linefollowing.LineFollow;
// import frc.robot.commands.linefollowing.TurnUntilLine;
import frc.robot.joystickUtils.XboxJoysticButtons;
import frc.robot.subsystems.Drivetrain;
// import frc.robot.subsystems.Catapult.CatapultMode;
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
    XboxJoysticButtons.Driver_ButtonB.onTrue(new SetCatapult(CatapultMode.ON));
    XboxJoysticButtons.Driver_ButtonB.onFalse(new SetCatapult(CatapultMode.OFF));
    XboxJoysticButtons.Driver_ButtonA.onTrue(new AdvancedLineFollow());
    XboxJoysticButtons.Driver_ButtonY.onTrue(new StopLineFollow());
  }

  // Returns the command that will be set as the drive command during tele-op
  public static Command getTeleopDriveCommand() {
    return new ArcadeDrive(
    () -> -XboxJoysticButtons.driverUtils.getLeftStickY(), () -> -XboxJoysticButtons.driverUtils.getLeftStickX()-XboxJoysticButtons.driverUtils.getRightStickX());
  }
}