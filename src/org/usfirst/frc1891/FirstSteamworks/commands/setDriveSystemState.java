package org.usfirst.frc1891.FirstSteamworks.commands;

import org.usfirst.frc1891.FirstSteamworks.Robot;
import org.usfirst.frc1891.FirstSteamworks.subsystems.DriveSystem.drivePowerState;

import edu.wpi.first.wpilibj.command.InstantCommand;

/**
 * @author Edgar Schafer
 *
 */
public class setDriveSystemState extends InstantCommand {
	
	private drivePowerState speed;
	
	public setDriveSystemState(drivePowerState speed) {
		requires(Robot.driveSystem);
		this.speed = speed;
		
	}
	
	protected void initialize() {
    	Robot.driveSystem.setSpeed(speed);
	}
	
}
