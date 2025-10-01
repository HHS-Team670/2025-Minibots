package frc.robot.commands.testing;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj.xrp.XRPOnBoardIO;  // Assuming XRPOnBoardIO is correct

public class LEDOnCommand extends Command {
    private static XRPOnBoardIO xrpBoard; // Static variable to hold instance

    public LEDOnCommand() {
        // Initialize the XRPOnBoardIO instance only once if it's not already created
        if (xrpBoard == null) {
            xrpBoard = new XRPOnBoardIO();  // Instantiate the XRPOnBoardIO object once
            System.out.println("XRPOnBoardIO Initialized");
        }
        ;  // Turn the LED on
    }

    @Override
    public void initialize() {
        System.out.println("LED On Command Executed");
    }
    @Override
    public void execute(){
        xrpBoard.setLed(true);
        System.out.println("LED On Command Executed");
    }
    @Override
    public boolean isFinished() {
        return false;
    }
}
