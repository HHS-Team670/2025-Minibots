package frc.robot.commands;

//import frc.robot.commands.drivetrain.*;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;
//import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class LineFollowing extends InstantCommand{
    private ReflectiveSensor reflectiveSensor;
    private Drivetrain drivetrain;
    private double speed; 
    private double turningSpeed;
    public static boolean FollowLine = false;


    public LineFollowing(double speed, double turningSpeed){
        this.reflectiveSensor = ReflectiveSensor.getInstance();
        this.drivetrain = Drivetrain.getInstance();
        this.speed = speed;
        this.turningSpeed = turningSpeed;

    }
    

    private boolean seesRightLine(){
        //tape is blue while field is white, value should be above sensor to be on line
        return (reflectiveSensor.rightValue() >= 0.80);
    }

    private boolean seesLeftLine(){
        //tape is blue while field is white, value should be above sensor to be on line
        return (reflectiveSensor.leftValue() >= 0.80);
    }

    @Override
    public void initialize() {
        FollowLine = true;
        


    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        System.out.println("I have entered execute");
        // System.out.println(seesLeftLine());
        // System.out.println(seesRightLine());
         System.out.println("left value: " + reflectiveSensor.leftValue());
         System.out.println("right value: " +reflectiveSensor.rightValue());



        if (seesRightLine() && seesLeftLine()){
            drivetrain.arcadeDrive(this.speed, 0);
            System.out.println("I see line on BOTH sensors");
        }

        else if (seesLeftLine() && !seesRightLine()){
            drivetrain.arcadeDrive(this.speed, this.turningSpeed);
            System.out.println("I now see only left");
        }

        else if(seesRightLine() && !seesLeftLine()){
            drivetrain.arcadeDrive(this.speed, -this.turningSpeed);
            System.out.println("I now see only right");
        
        } else {
            System.out.println("This is the else");
        }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
        
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return (!seesRightLine() && !seesLeftLine()) || !FollowLine;
  }
}