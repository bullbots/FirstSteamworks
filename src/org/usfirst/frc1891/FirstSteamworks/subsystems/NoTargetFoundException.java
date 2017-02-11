package org.usfirst.frc1891.FirstSteamworks.subsystems;

public class NoTargetFoundException extends Exception {
	public NoTargetFoundException()
	{
		super("no target found, check camera output");
	}
}
