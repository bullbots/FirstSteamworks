package org.usfirst.frc1891.FirstSteamworks.commands;

import org.usfirst.frc1891.FirstSteamworks.Robot;

import edu.wpi.first.wpilibj.command.Command;

public class TuningSpin extends Command {
	
	private static final double power = 200;

	public TuningSpin()
	{
		requires(Robot.driveSystem);
	}
	
	protected void initialize()
	{
		Robot.driveSystem.setVelocityMode();
	}
	
	protected void execute()
	{
		Robot.driveSystem.setFrontLeftWheel(power);
		Robot.driveSystem.setRearLeftWheel(power);
		Robot.driveSystem.setFrontRightWheel(-power);
		Robot.driveSystem.setRearRightWheel(-power);
		Robot.driveSystem.publishSpeeds();
	}
	
	@Override
	protected boolean isFinished() {
		// TODO Auto-generated method stub
		return false;
	}
	
	protected void end()
	{
		Robot.driveSystem.setAllMotors(0);
	}
	
	protected void interrupted()
	{
		end();
	}

}
