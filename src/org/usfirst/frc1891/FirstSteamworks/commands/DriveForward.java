// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1891.FirstSteamworks.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc1891.FirstSteamworks.Robot;

/**
 *
 */
public class DriveForward extends Command {

	private double m_rotations;
	
    /**
     * Drives straight forward or backward, without turning or moving sideways
     * @param distance distance in inches to be traveled
     */
    public DriveForward(double distance) {
        requires(Robot.driveSystem);
        m_rotations = distance/25.13;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.driveSystem.zeroPosition();
    	System.out.println("distance: " + m_rotations);
    	Robot.driveSystem.driveForwardPosition(m_rotations);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Robot.driveSystem.driveForwardPosition(m_rotations);
    	Robot.driveSystem.publishDistances();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return Robot.driveSystem.onTargetPosition();
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveSystem.setPercentageMode();
    	Robot.driveSystem.zeroAngleError();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    	end();
    }
}
