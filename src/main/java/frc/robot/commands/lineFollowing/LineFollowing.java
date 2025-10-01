package frc.robot.commands.lineFollowing;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.drivetrain.ArcadeDrive;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;

public class LineFollowing extends Command {
    private ReflectiveSensor rfs;
    private Drivetrain drive;

    public LineFollowing() {
        this.rfs = ReflectiveSensor.getInstance();
        this.drive = Drivetrain.getInstance();
    }

    // Called when the command is initially scheduled.
    @Override
    public void initialize() {
        // nothing ig
        drive.arcadeDrive(0, 0);
    }

    @Override
    public void execute() {
        boolean leftCheck = rfs.leftOnTrack();
        boolean rightCheck = rfs.rightOnTrack();

        if (leftCheck && rightCheck) {
            // forward
            drive.arcadeDrive(0.8, 0);
           
            
        } else if (leftCheck) {
            // move right motor forward (turn right)
            drive.arcadeDrive(0.8, -0.6);
        
        } else if (rightCheck) {

            // move left motor forward (turn left)
            drive.arcadeDrive(0.8, 0.6);
           
        }
    }

    @Override
    public void end(boolean interrupted) {
        System.out.println("ended");
    }
}
