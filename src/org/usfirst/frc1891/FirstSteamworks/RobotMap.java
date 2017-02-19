// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1891.FirstSteamworks;

import org.usfirst.frc1891.FirstSteamworks.subsystems.Camera;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.CANTalon;
import com.kauailabs.navx.frc.AHRS;

import edu.wpi.first.wpilibj.AnalogAccelerometer;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.PWM;
import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.Servo;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
	public static AHRS nav;
	
	public static AnalogInput frontSonic;
    public static CANTalon frontLeftMotor;
    public static CANTalon rearLeftMotor;
    public static CANTalon frontRightMotor;
    public static CANTalon rearRightMotor;
    public static Spark climber;
    public static DoubleSolenoid gearCarrierDoubleSolenoid1;
    public static RobotDrive chassis;
    
    public static Camera camera;
    
    public static int targetSize;
    
    public static Compressor compressor;
    
    public static DigitalInput gearLimit;
    
    public static DigitalInput climbLimit;
    
    public static Servo ballServo;

    public static CANTalon shooterMotor;

	public static DigitalInput alignLimit;
    /**
     * 
     */
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    	try {
            nav = new AHRS(SPI.Port.kMXP);
        } catch (RuntimeException ex ) {
            DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
        }
    	
    	frontSonic = new AnalogInput(0);
    	
//        driveSystemAnalogGyro1 = new AnalogGyro(0);
//        LiveWindow.addSensor("DriveSystem", "AnalogGyro 1", driveSystemAnalogGyro1);
//        driveSystemAnalogGyro1.setSensitivity(0.007);
//        driveSystemAnalogAccelerometer1 = new AnalogAccelerometer(1);
//        LiveWindow.addSensor("DriveSystem", "AnalogAccelerometer 1", driveSystemAnalogAccelerometer1);
//        driveSystemAnalogAccelerometer1.setSensitivity(0.0);
//        driveSystemAnalogAccelerometer1.setZero(2.5);
        
//        frontLeftMotor = new CANTalon(4);
    	frontLeftMotor = new CANTalon(1);
//        frontLeftMotor.setInverted(true);
        frontLeftMotor.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
        frontLeftMotor.reverseSensor(true);
//      profile for velocity
        frontLeftMotor.setProfile(0);
//      Final bot gains
        
        frontLeftMotor.setF(0.415);
        frontLeftMotor.setP(0.4);
        frontLeftMotor.setI(0);
        frontLeftMotor.setD(0.04);
        frontLeftMotor.setCloseLoopRampRate(0.01);
        
//      Practice bot gains
//        frontLeftMotor.setF(0.4);
//        frontLeftMotor.setP(0.6);
////        0.4 to 0.6
//        frontLeftMotor.setI(0.004);
//        frontLeftMotor.setD(0);
//      profile for position
//        frontLeftMotor.setProfile(1);
//        frontLeftMotor.setPID(0, 0, 0);
        LiveWindow.addActuator("DriveSystem", "CAN Talon 1", frontLeftMotor);

//        rearLeftMotor = new CANTalon(1);
        rearLeftMotor = new CANTalon(2);
        rearLeftMotor.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
        rearLeftMotor.reverseSensor(true);
//        rearLeftMotor.setInverted(true);
//      profile for velocity
        rearLeftMotor.setProfile(0);
//      Final bot gains
        
        rearLeftMotor.setF(0.33);
        rearLeftMotor.setP(0.05);
        rearLeftMotor.setI(0.0001);
        rearLeftMotor.setD(0);
        rearLeftMotor.setCloseLoopRampRate(0.01);
        
//      Practice bot gains
//        rearLeftMotor.setF(0.535);
//        rearLeftMotor.setP(0.8);
//        rearLeftMotor.setI(0.001);
//        rearLeftMotor.setD(0);        
        LiveWindow.addActuator("DriveSystem", "CAN Talon 2", rearLeftMotor);

//        frontRightMotor = new CANTalon(3);
        frontRightMotor = new CANTalon(3);
        frontRightMotor.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
        frontRightMotor.setInverted(true);
        frontRightMotor.reverseSensor(true);
//      profile for velocity
        frontRightMotor.setProfile(0);
        
        frontRightMotor.setF(0.395);
        frontRightMotor.setP(0.3);
        frontRightMotor.setI(0.0001);
        frontRightMotor.setD(0);
        frontRightMotor.setCloseLoopRampRate(0.01);
        
//    Final bot gains
        
//    Practice bot gains
//        frontRightMotor.setF(0.28);
//        frontRightMotor.setP(0.6);
//        frontRightMotor.setI(0.004);
//        frontRightMotor.setD(0.01);
        LiveWindow.addActuator("DriveSystem", "CAN Talon 3", frontRightMotor);

//        rearRightMotor = new CANTalon(2);
        rearRightMotor = new CANTalon(4);
        rearRightMotor.setFeedbackDevice(CANTalon.FeedbackDevice.CtreMagEncoder_Relative);
        rearRightMotor.setInverted(true);
        rearRightMotor.reverseSensor(true);
//      profile for velocity
        rearRightMotor.setProfile(0);
        
        rearRightMotor.setF(0.31);
        rearRightMotor.setP(0.2);
        rearRightMotor.setI(0);
        rearRightMotor.setD(0);
        rearRightMotor.setCloseLoopRampRate(0.01);
        
//      Final bot gains
        
//      Practice bot gains
//        rearRightMotor.setF(0.52);
//        rearRightMotor.setP(0.4);
//        rearRightMotor.setI(0.002);
//        rearRightMotor.setD(0);
        LiveWindow.addActuator("DriveSystem", "CAN Talon 4", rearRightMotor);
        
        chassis = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
        chassis.setMaxOutput(400);
        SmartDashboard.putBoolean("Use Gyro?", true);

        climber = new Spark(0);
        LiveWindow.addActuator("Climber", "Spark", climber);
        
        gearCarrierDoubleSolenoid1 = new DoubleSolenoid(0, 1);
        LiveWindow.addActuator("GearCarrier", "Double Solenoid 1", gearCarrierDoubleSolenoid1);
        
        compressor = new Compressor();
        
        gearLimit = new DigitalInput(0);
        LiveWindow.addSensor("GearCarrier", "Gear Plate", gearLimit);
        
        climbLimit = new DigitalInput(1);
        LiveWindow.addSensor("Climber", "Climb limit", climbLimit);
        
        alignLimit = new DigitalInput(2);
        LiveWindow.addSensor("Climber", "Climb Align limit", alignLimit);
        
        ballServo = new Servo(1);
        LiveWindow.addActuator("BallServo", "Servo", ballServo);
       
        shooterMotor = new CANTalon(5);
        LiveWindow.addActuator("Shooter","Ball Shooter" , shooterMotor);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
