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

import org.usfirst.frc1891.FirstSteamworks.Robot;
import org.usfirst.frc1891.FirstSteamworks.RobotMap;
import org.usfirst.frc1891.FirstSteamworks.commands.*;
import com.ctre.CANTalon;
import edu.wpi.first.wpilibj.AnalogAccelerometer;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import com.kauailabs.navx.frc.*;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 *
 */
public class DriveSystem extends Subsystem implements PIDOutput {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final AHRS nav = RobotMap.nav;
//    private final AnalogAccelerometer analogAccelerometer1 = RobotMap.driveSystemAnalogAccelerometer1;
    private final CANTalon frontLeftMotor = RobotMap.frontLeftMotor;
//    private final Encoder quadratureEncoder1 = RobotMap.driveSystemQuadratureEncoder1;
    private final CANTalon rearLeftMotor = RobotMap.rearLeftMotor;
//    private final Encoder quadratureEncoder2 = RobotMap.driveSystemQuadratureEncoder2;
    private final CANTalon frontRightMotor = RobotMap.frontRightMotor;
//    private final Encoder quadratureEncoder3 = RobotMap.driveSystemQuadratureEncoder3;
    private final CANTalon rearRightMotor = RobotMap.rearRightMotor;
//    private final Encoder quadratureEncoder4 = RobotMap.driveSystemQuadratureEncoder4;
    
    private final RobotDrive chassis = RobotMap.chassis; 
    
    private double zeroAngle;
    
    private boolean useGyro = true;
    private PIDMode m_PIDMode;
    private PIDDirection m_PIDDirection;

    /**
     * @author Edgar Schafer
     *
     */
    public enum PIDDirection
    {
    	/**
    	 * 
    	 */
    	Sideways,
    	/**
    	 * 
    	 */
    	forward,
    	/**
    	 * 
    	 */
    	rotation
    }
    
    public enum PIDMode
    {
    	Percentage,
    	Position,
    	voltage
    }
    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    	setDefaultCommand(new JoyStickDrive());
//    	setDefaultCommand(new DriveOneWheel());
    	
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
    	useGyro = SmartDashboard.getBoolean("Use Gyro?", true);
    	double gyro = 0;
    	if (useGyro == true)
    	{
    		gyro = getGyro();
    		SmartDashboard.putNumber("gyro", getGyro());
    	}
    	chassis.mecanumDrive_Cartesian(Db(driverJoy.getX(),0.1), Db(driverJoy.getY(),0.1), Db(driverJoy.getZ(),0.4), gyro);
//    	SmartDashboard.putNumber("Joystick X", driverJoy.getX());
//    	SmartDashboard.putNumber("Joystick Y", driverJoy.getY());
//    	SmartDashboard.putNumber("Joystick Z", driverJoy.getZ());
    }
    
    double Db(double axisVal, double deadBand)
	{
		if(axisVal < -deadBand)
			return axisVal;
		if(axisVal > +deadBand)
			return axisVal;
		return 0;
	}
    
    
    /**
     * @param power positive is right, negative is left
     */
    public void driveSideways(double power)
    {
    	setPercentageMode();
    	setFrontLeftWheel(power);
    	setFrontRightWheel(-power);
    	setRearLeftWheel(-power);
    	setRearRightWheel(power);
    }
    
    /**
     * @param power
     */
    public void setFrontLeftWheel(double power)
    {
    	frontLeftMotor.set(power);
    	
    }
    
    /**
     * @return
     */
    public double getFrontLeftWheelError()
    {
		return frontLeftMotor.getClosedLoopError();
    }
    
    /**
     * @return
     */
    public double getFrontLeftWheelFeedback()
    {
    	return frontLeftMotor.getSpeed();
    }
    
    /**
     * @param power
     */
    public void setRearLeftWheel(double power)
    {
    	rearLeftMotor.set(power);
    }
    
    /**
     * @return
     */
    public double getRearLeftWheelError()
    {
		return rearLeftMotor.getClosedLoopError();
    }
    
    /**
     * @return
     */
    public double getRearLeftWheelFeedback()
    {
    	return rearLeftMotor.getSpeed();
    }
    
    /**
     * @param power
     */
    public void setFrontRightWheel(double power)
    {
    	frontRightMotor.set(power);
    }
    
    /**
     * @return
     */
    public double getFrontRightWheelError()
    {
		return frontRightMotor.getClosedLoopError();
    }
    
    /**
     * @return
     */
    public double getFrontRightWheelFeedback()
    {
    	return frontRightMotor.getSpeed();
    }
    
    /**
     * @param power
     */
    public void setRearRightWheel(double power)
    {
    	rearRightMotor.set(power);
    }
    
    /**
     * @return
     */
    public double getRearRightWheelError()
    {
		return rearRightMotor.getClosedLoopError();
    }
    
    /**
     * @return
     */
    public double getRearRightWheelFeedback()
    {
    	return rearRightMotor.getSpeed();
    }
    
    /**
     * @param value
     */
    public void setAllMotors(double value)
    {
    	frontLeftMotor.set(value);
    	rearLeftMotor.set(value);
    	frontRightMotor.set(value);
    	rearRightMotor.set(value);
    }
    
    public void setPositionMode()
    {
    	frontLeftMotor.changeControlMode(CANTalon.TalonControlMode.Position);
    	frontLeftMotor.setProfile(1);
    	rearLeftMotor.changeControlMode(CANTalon.TalonControlMode.Position);
    	rearLeftMotor.setProfile(1);
    	frontRightMotor.changeControlMode(CANTalon.TalonControlMode.Position);
    	frontRightMotor.setProfile(1);
    	rearRightMotor.changeControlMode(CANTalon.TalonControlMode.Position);
    	rearRightMotor.setProfile(1);
    }
    
    public void setPercentageMode()
    {
    	frontLeftMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	rearLeftMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	frontRightMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    	rearRightMotor.changeControlMode(CANTalon.TalonControlMode.PercentVbus);
    }
    
    public void setVelocityMode()
    {
    	frontLeftMotor.changeControlMode(CANTalon.TalonControlMode.Speed);
    	frontLeftMotor.setProfile(0);
    	rearLeftMotor.changeControlMode(CANTalon.TalonControlMode.Speed);
    	rearLeftMotor.setProfile(0);
    	frontRightMotor.changeControlMode(CANTalon.TalonControlMode.Speed);
    	frontRightMotor.setProfile(0);
    	rearRightMotor.changeControlMode(CANTalon.TalonControlMode.Speed);
    	rearRightMotor.setProfile(0);
    }
    
    public void setVoltageMode()
    {
    	frontLeftMotor.changeControlMode(CANTalon.TalonControlMode.Voltage);
    	rearLeftMotor.changeControlMode(CANTalon.TalonControlMode.Voltage);
    	frontRightMotor.changeControlMode(CANTalon.TalonControlMode.Voltage);
    	rearRightMotor.changeControlMode(CANTalon.TalonControlMode.Voltage);
    }
    
    public void zeroGyro()
    {
    	zeroAngle = nav.getAngle();
    }
    
    /**
     * @return
     */
    public double getGyro()
    {
    	double angle = nav.getAngle() - zeroAngle;
//    	double angle = nav.getAngle();
    	return angle;
    }
    
    /**
     * @param mode
     */
    public void setPIDMode(PIDDirection mode)
    {
    	m_PIDDirection = mode;
    }

	@Override
	public void pidWrite(double output) {
		switch(m_PIDDirection)
		{
			case Sideways:
				this.driveSideways(output);
				break;
			case forward:
				this.setAllMotors(output);
				break;
			case rotation:
				break;
			default:
				break;
		}
	}
}

