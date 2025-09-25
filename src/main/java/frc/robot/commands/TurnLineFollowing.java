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
    public static boolean TurnOnLine = false;


    public TurnLineFollowing(double turningSpeed){
        this.reflectiveSensor = ReflectiveSensor.getInstance();
        this.drivetrain = Drivetrain.getInstance();
        this.turningSpeed = turningSpeed;

    }
    

    private boolean seesRightLine(){
        //tape is black while field is white, value should be above sensor to be on line
        return (reflectiveSensor.rightValue() >= 0.80);
    }

    private boolean seesLeftLine(){
        //tape is black while field is white, value should be above sensor to be on line
        return (reflectiveSensor.leftValue() >= 0.80);
    }

    @Override
    public void initialize() {
        TurnOnLine = true;
        


    }

    // Called every time the scheduler runs while the command is scheduled.
    @Override
    public void execute() {
        // System.out.println(seesLeftLine());
        // System.out.println(seesRightLine());
        // System.out.println(reflectiveSensor.leftValue());
        // System.out.println(reflectiveSensor.rightValue());

        System.out.println("I have entered execute");
        drivetrain.arcadeDrive(0, -this.turningSpeed);

        
        
        }
  

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
        
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (seesRightLine() && seesLeftLine()){
    }
    return (seesRightLine() && seesLeftLine()) || !TurnOnLine;
    
  }
}