
package org.usfirst.frc1891.FirstSteamworks.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc1891.FirstSteamworks.RobotMap;

import edu.wpi.first.wpilibj.DriverStation.Alliance;
import edu.wpi.first.wpilibj.I2C;

/**
 * @author 408robot
 *
 */
public class ArdunioController extends Subsystem{

	
	private I2C arduino;
	private byte data[];
	boolean lowBat;
	
	/**
	 *
	 * 
	 */
	public ArdunioController() {
		this.arduino = RobotMap.arduino;
		data = new byte[3];
		
		
		lowBat = false;
	}
	
	/** 
	 * Checks for team, if team is red/blue it sets it to the corresponding setting in the arduino.
	 * @param team what value is
	 */
	public void setTeam(Alliance team) {
		if (Alliance.Blue == team) {
			
		}
		else if (Alliance.Red == team) {
			
		}
	}
	protected void initDefaultCommand() {
		
	}
	
	/**
	 * 
	 */
	public void write() {
		arduino.writeBulk(data);
	}
}
