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
import edu.wpi.first.wpilibj.buttons.JoystickButton;
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
    /**
     * 
     */
    public Joystick driveStick;
    /**
     * 
     */
    public Joystick coDriverStick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
     * 
     */
    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        coDriverStick = new Joystick(1);
        
        driveStick = new Joystick(0);
        
        climbButton = new JoystickButton(driveStick, 10);
        climbButton.whileHeld(new Climb());
        gearButton = new JoystickButton(driveStick, 2);
//        gearButton.whenPressed(new PlaceGear());


        // SmartDashboard Buttons
//        SmartDashboard.putData("Align", new Align());
        
        SmartDashboard.putNumber("Wheel", 0);
        SmartDashboard.putData("DriveForward", new DriveForward(12));
        SmartDashboard.putData("DriveSideways", new DriveSideways(12));
        SmartDashboard.putData("testDriveAll", new TestDriveAll());
        SmartDashboard.putData("TestDriveSideways", new TestDriveSideways(1));
        SmartDashboard.putData("Turn", new Turn(360));
        SmartDashboard.putData("Align", new Align());
//        SmartDashboard.putData("PlaceGear", new PlaceGear());
//        SmartDashboard.putData("AutonomousCommand", new AutonomousCommand());
        SmartDashboard.putData("Climb", new Climb());
        SmartDashboard.putData("PushGear", new PushGear());
        SmartDashboard.putData("DriveFrontLeftWheel", new DriveOneWheel(0));
        SmartDashboard.putData("DriveRearLeftWheel", new DriveOneWheel(1));
        SmartDashboard.putData("DriveFrontRightWheel", new DriveOneWheel(2));
        SmartDashboard.putData("DriveRearRightWheel", new DriveOneWheel(3));
        SmartDashboard.putData("tuner", new TuningSpin());

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


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

