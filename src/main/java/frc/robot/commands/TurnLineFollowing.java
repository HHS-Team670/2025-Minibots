package frc.robot.commands;

//import frc.robot.commands.drivetrain.*;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;
//import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.InstantCommand;

public class TurnLineFollowing extends InstantCommand{
    private ReflectiveSensor reflectiveSensor;
    private Drivetrain drivetrain;
    private double turningSpeed;
    //public static boolean TurnOnLine = false;


    public TurnLineFollowing(double turningSpeed){
        this.reflectiveSensor = ReflectiveSensor.getInstance();
        this.drivetrain = Drivetrain.getInstance();
        this.turningSpeed = turningSpeed;
        
        addRequirements(drivetrain, reflectiveSensor);

    }
    

    private boolean seesRightLine(){
        //tape is black while field is white, value should be above sensor to be on line
        return (reflectiveSensor.rightValue() >= 0.70);
    }

    private boolean seesLeftLine(){
        //tape is black while field is white, value should be above sensor to be on line
        return (reflectiveSensor.leftValue() >= 0.70);
    }

    @Override
    public void initialize() {
        //TurnOnLine = true;
        drivetrain.arcadeDrive(0,0);
        drivetrain.resetEncoders();


    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        // System.out.println(seesLeftLine());
        // System.out.println(seesRightLine());
        // System.out.println(reflectiveSensor.leftValue());
        // System.out.println(reflectiveSensor.rightValue());

        System.out.println("I have entered execute");
        drivetrain.arcadeDrive(0, turningSpeed);

        
        
        }
  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
        System.out.println("I have entered end");
        drivetrain.arcadeDrive(0,0);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    /* 
    if (seesRightLine() && seesLeftLine()){
        System.out.println("I see line on both sensors");
    } 
    if (seesRightLine() || seesLeftLine()){
        System.out.println("I see line on one sensor");
    }
    */
    return (seesRightLine() && seesLeftLine());
  }
}