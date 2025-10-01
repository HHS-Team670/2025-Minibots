package frc.robot.commands;

import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.ReflectiveSensor;
import edu.wpi.first.wpilibj2.command.Command; 
import edu.wpi.first.wpilibj2. command.InstantCommand;

public class LineFollow extends InstantCommand{
    private ReflectiveSensor reflectiveSensor;
    private Drivetrain drivetrain;
    private double speed;
    private double turnspeed;
    public  static boolean FollowLine = false;

    public LineFollow(double speed, double turnSpeed){
        this.reflectiveSensor = ReflectiveSensor.getInstance();
        this.drivetrain = Drivetrain.getInstance();
        this.speed = speed;
        this.turnspeed = speed;
    }

    private boolean seesRightLine(){
        // 0.75 is the number of between the color of white and black, not change it
        return (reflectiveSensor.rightValue() <= 0.80);
    }

    private boolean seesLeftLine(){
        // 0.75 is the number of between the color of white and black, not change it
        return (reflectiveSensor.leftValue() <= 0.80);
    }

    @Override
    public void initialize() {
        FollowLine = true;
    }

    @Override
    public void execute(){
        System.out.println(seesLeftLine());
        System.out.println(seesRightLine());
        System.out.println(reflectiveSensor.leftValue());
        System.out.println(reflectiveSensor.rightValue());

        if (seesRightLine() && seesLeftLine()) {
            drivetrain.arcadeDrive(this.speed, 0);
        }
        else if (seesRightLine() && seesLeftLine()) {
                drivetrain.arcadeDrive(this.speed, 0);
            }
        else if (seesRightLine() && !seesLeftLine()) {
            drivetrain.arcadeDrive(-this.speed, 0);
        }
    }


    @Override
    public boolean isFinished(){
        return (!seesLeftLine() && !seesRightLine()) || FollowLine;

    }

    @Override
    public void end(boolean interrupted) {
         FollowLine = false;     
    }    

    
    




}