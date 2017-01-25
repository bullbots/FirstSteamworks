package org.usfirst.frc1891.FirstSteamworks.commands;

import org.usfirst.frc1891.FirstSteamworks.Robot;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class DriveOneWheel extends Command {

	
	private int wheel;
	private static final double power = 200;
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS
 
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_DECLARATIONS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
    public DriveOneWheel(int wheel) {
    	requires(Robot.driveSystem);
    	this.wheel = wheel;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTOR
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=VARIABLE_SETTING
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES

        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveSystem.setVelocityMode();
//    	Robot.driveSystem.setPercentageMode();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	//Nintendo
    	switch(wheel)
    	{
    	case 0:
    		Robot.driveSystem.setFrontLeftWheel(power);
    		break;
    	case 1:
    		Robot.driveSystem.setRearLeftWheel(power);
    		break;
    	case 2:
    		Robot.driveSystem.setFrontRightWheel(power);
    		break;
    	case 3:
    		Robot.driveSystem.setRearRightWheel(power);
    		break;
    	}
    	Robot.driveSystem.publishSpeeds();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveSystem.setAllMotors(0);
//    	Robot.driveSystem.setAllSetPoints(0);
    }
    
    protected void interrupted()
    {
    	end();
    }
}
