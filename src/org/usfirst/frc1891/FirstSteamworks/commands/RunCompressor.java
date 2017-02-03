package org.usfirst.frc1891.FirstSteamworks.commands;

import org.usfirst.frc1891.FirstSteamworks.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class RunCompressor extends Command {

    public RunCompressor() {
    	requires(Robot.compressor);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.compressor.turnOn();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.compressor.turnOff();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
