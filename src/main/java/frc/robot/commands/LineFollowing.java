package frc.robot.commands;

//import frc.robot.subsystems.Drivetrain;
import frc.robot.commands.drivetrain.DriveForward;
import frc.robot.commands.drivetrain.TurnDegrees;
import frc.robot.subsystems.ReflectiveSensor;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

//drive train + ref sensor
// do thing with sensor same as set catapult
public class LineFollowing extends SequentialCommandGroup{


    double lValue, rValue, tapeColor = 0.5;

    public LineFollowing () {

    }

    // public void initialize () {
        
    // }

    public void execute (ReflectiveSensor rf) {
        lValue = rf.leftValue();
        rValue = rf.rightValue();
        
        if (lValue == tapeColor && rValue == tapeColor) {
            // continue going forward
            addCommands (
                new DriveForward(1, 2)
            );
        }
        else if (rValue != tapeColor && lValue == tapeColor) {
            // turn left
            addCommands (
                new TurnDegrees(1, -20)
            );
        }
        else if (lValue != tapeColor && rValue == tapeColor) {
            // turn right
            addCommands (
                new TurnDegrees(1, 20)
            );
        }


        // get right and left sensor values
        // check if they detect the tape
        // if statements for sides and turn the corresponding direction
        // if both detect continue forward
    }

    // public void isFinished() {

    // }

    public void end() {

    }
}
