package org.usfirst.frc1891.FirstSteamworks.commands;

import org.usfirst.frc1891.FirstSteamworks.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class OverrideCommands extends Command {
		public OverrideCommands() {
			requires(Robot.driveSystem);
			requires(Robot.climber);
			requires(Robot.gearCarrier);
			requires(Robot.shooter);
			requires(Robot.ballServo);
			requires(Robot.camera);
			requires(Robot.compressor);
	    }

	    // Called just before this Command runs the first time
	    protected void initialize() {
	    	
	    }

	    // Called repeatedly when this Command is scheduled to run
	    protected void execute() {
	    	
	    }

	    // Make this return true when this Command no longer needs to run execute()
	    protected boolean isFinished() {
	        return true;
	    }

	    // Called once after isFinished returns true
	    protected void end() {
	    }

	    // Called when another command which requires one or more of the same
	    // subsystems is scheduled to run
	    protected void interrupted() {
	    }
}
