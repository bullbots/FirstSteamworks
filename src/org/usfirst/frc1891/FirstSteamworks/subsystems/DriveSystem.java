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
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.AnalogAccelerometer;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.RobotDrive;
import com.kauailabs.navx.frc.*;

import edu.wpi.first.wpilibj.command.Subsystem;


/**
 *
 */
public class DriveSystem extends Subsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final AnalogGyro analogGyro1 = RobotMap.driveSystemAnalogGyro1;
//    private final AnalogAccelerometer analogAccelerometer1 = RobotMap.driveSystemAnalogAccelerometer1;
    private final CANTalon frontLeftMotor = RobotMap.frontLeftMotor;
//    private final Encoder quadratureEncoder1 = RobotMap.driveSystemQuadratureEncoder1;
    private final PIDController pIDController1 = RobotMap.driveSystemPIDController1;
    private final CANTalon rearLeftMotor = RobotMap.rearLeftMotor;
//    private final Encoder quadratureEncoder2 = RobotMap.driveSystemQuadratureEncoder2;
    private final PIDController pIDController2 = RobotMap.driveSystemPIDController2;
    private final CANTalon frontRightMotor = RobotMap.frontRightMotor;
//    private final Encoder quadratureEncoder3 = RobotMap.driveSystemQuadratureEncoder3;
    private final PIDController pIDController3 = RobotMap.driveSystemPIDController3;
    private final CANTalon rearRightMotor = RobotMap.rearRightMotor;
//    private final Encoder quadratureEncoder4 = RobotMap.driveSystemQuadratureEncoder4;
    private final PIDController pIDController4 = RobotMap.driveSystemPIDController4;
    
    private final RobotDrive chassis = RobotMap.chassis; 

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * @param driverJoy 
     * 
     */
    public void joyDrive(Joystick driverJoy)
    {
    	chassis.mecanumDrive_Polar(driverJoy.getX(), driverJoy.getY(), driverJoy.getZ());
    }
    
    /**
     * @param power
     */
    public void setFrontLeftWheel(int power)
    {
    	
    }
    
    /**
     * @return
     */
    public double getFrontLeftWheelFeedback()
    {
		return 0;
    }
    
    /**
     * @param power
     */
    public void setRearLeftWheel(int power)
    {
    	
    }
    
    /**
     * @return
     */
    public double getRearLeftWheelFeedback()
    {
		return 0;
    }
    
    /**
     * @param power
     */
    public void setFrontRightWheel(int power)
    {
    	
    }
    
    /**
     * @return
     */
    public double getFrontRightWheelFeedback()
    {
		return 0;
    }
    
    /**
     * @param power
     */
    public void setRearRightWheel(int power)
    {
    	
    }
    
    /**
     * @return
     */
    public double getRearRightWheelFeedback()
    {
		return 0;
    }
}

