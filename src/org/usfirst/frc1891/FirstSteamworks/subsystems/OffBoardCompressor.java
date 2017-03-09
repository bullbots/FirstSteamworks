// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1891.FirstSteamworks.subsystems;

import org.usfirst.frc1891.FirstSteamworks.RobotMap;
import org.usfirst.frc1891.FirstSteamworks.commands.*;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class OffBoardCompressor extends Subsystem {

    Compressor m_compressor = RobotMap.compressor;


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public OffBoardCompressor() {
    	turnOff();
    }
    
    /* (non-Javadoc)
     * @see edu.wpi.first.wpilibj.command.Subsystem#initDefaultCommand()
     */
	public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * 
     */
    public void turnOn()
    {
    	m_compressor.setClosedLoopControl(true);
    }
    
    /**
     * 
     */
    public void turnOff()
    {
    	m_compressor.setClosedLoopControl(false);
    }
    
    public boolean isFull()
    {
    	return !m_compressor.getPressureSwitchValue();
    }
}

