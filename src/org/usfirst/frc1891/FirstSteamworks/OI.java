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

import org.usfirst.frc1891.FirstSteamworks.commands.*;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    /**
     * 
     */
    public JoystickButton gearButton;
    /**
     * 
     */
    public JoystickButton climbButton;
    
    public JoystickButton ZeroGyroButton;
    /**
     * 
     */
    public Joystick driveStick;
    /**
     * 
     */
    public Joystick coDriverStick;
    
	public JoystickButton overrideButton;
	public JoystickButton alignClimberButton;
	public JoystickButton manualPushGear;
	
	public JoystickButton alignLeftRopeButton;
	public JoystickButton alignLeftPegButton;
	public JoystickButton alignMiddleButton;
	public JoystickButton alignRightPegButton;
	public JoystickButton alignRightRopeButton;
	private SendableChooser<Object> joystickType;
	
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    
    /**
     * 
     */
    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    	
    	joystickType = new SendableChooser<Object>();
    	joystickType.addDefault("JoyStick", 0);
    	joystickType.addObject("Gamecube", 1);
		SmartDashboard.putData("Joystick Profile", joystickType);
		
        SmartDashboard.putBoolean("Use Gyro?", true);
        SmartDashboard.putBoolean("Run Wheel PID?", true);
        
        driveStick = new Joystick(0);
        
        /*  
         * Sneaky gamecube button map cheatsheet
         * 1 - X button or right gray button - align climbing
         * 2 - A button - auto place gear
         * 3 - B button - override
         * 4 - Y button or right gray button
         * 5 - Left trigger - medium damp
         * 6- Right trigger - hard damp
         * 7 - 
         * 8 - Z button
         * 9 - 
         * 10 - Start button - climb
         * 13 - up on the d-pad - reset gyro
         */
        
        climbButton = new JoystickButton(driveStick, 2);
        climbButton.whenPressed(new Climb());
        alignClimberButton = new JoystickButton(driveStick, 11);
        alignClimberButton.whenPressed(new AlignClimber());
        gearButton = new JoystickButton(driveStick, 4);
        gearButton.whenPressed(new PlaceGear());
        manualPushGear = new JoystickButton(driveStick, 1);
        manualPushGear.whenPressed(new PushGear());
        overrideButton = new JoystickButton(driveStick, 3);
        overrideButton.whenPressed(new OverrideCommands());
        ZeroGyroButton = new JoystickButton(driveStick, 12);
        ZeroGyroButton.whenPressed(new ZeroGyro());
        
        coDriverStick = new Joystick(1);
        
        alignLeftRopeButton = new JoystickButton(coDriverStick, 5);
        alignLeftRopeButton.whenPressed(new TurnTo(-120));
        alignLeftPegButton = new JoystickButton(coDriverStick, 4);
        alignLeftRopeButton.whenPressed(new TurnTo(-60));
        alignMiddleButton = new JoystickButton(coDriverStick, 2);
        alignLeftRopeButton.whenPressed(new TurnTo(0));
        alignRightPegButton = new JoystickButton(coDriverStick, 1);
        alignLeftRopeButton.whenPressed(new TurnTo(-300));
        alignRightRopeButton = new JoystickButton(coDriverStick, 6);
        alignLeftRopeButton.whenPressed(new TurnTo(-240));

        // SmartDashboard Buttons
        
        // Match Buttons
        SmartDashboard.putData("Zero Gyro", new ZeroGyro());
        SmartDashboard.putData("Start Compressor", new RunCompressor());
        SmartDashboard.putData("Align Climber", new AlignClimber());
        SmartDashboard.putData("Climb", new Climb());
        SmartDashboard.putData("Place Gear", new PlaceGear());
        /// Test Buttons
        SmartDashboard.putData("PushGear", new PushGear());
        SmartDashboard.putData("Align", new Align());
        SmartDashboard.putData("DriveForward", new DriveForward(60));
        SmartDashboard.putData("Turn", new Turn(0));
        SmartDashboard.putData("DriveForwardVelocity", new DriveForwardVelocity(100));
        SmartDashboard.putData("DriveSidewaysVelocity", new DriveSidewaysVelocity(100));
        
//      SmartDashboard.putData("DriveSideways", new DriveSideways(12));
//      SmartDashboard.putData("testDriveAll", new TestDriveAll());
//      SmartDashboard.putData("TestDriveSideways", new TestDriveSideways(1));
//      SmartDashboard.putData("PlaceGear", new PlaceGear());
//      SmartDashboard.putData("AutonomousCommand", new AutonomousCommand());
//      SmartDashboard.putData("DriveFrontLeftWheel", new DriveOneWheel(0));
//      SmartDashboard.putData("DriveRearLeftWheel", new DriveOneWheel(1));
//      SmartDashboard.putData("DriveFrontRightWheel", new DriveOneWheel(2));
//      SmartDashboard.putData("DriveRearRightWheel", new DriveOneWheel(3));
//      SmartDashboard.putData("tuner", new TuningSpin());
        
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    /**
     * @return
     */
    public Joystick getDriveStick() {
        return driveStick;
    }

    /**
     * @return
     */
    public Joystick getCoDriverStick() {
        return coDriverStick;
    }
    
    public int getControllerProfile() {
    	return (int) joystickType.getSelected();
    }

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

