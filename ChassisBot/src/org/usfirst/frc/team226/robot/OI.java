package org.usfirst.frc.team226.robot;

import org.usfirst.frc.team226.robot.commands.RefreshDriveTrain;
import org.usfirst.frc.team226.robot.commands.SetDefaultCommand;
import org.usfirst.frc.team226.robot.commands.XboxArcadeDrive;
import org.usfirst.frc.team226.robot.commands.XboxTankDrive;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public XboxController driveController = new XboxController(0);
	
	public void OI() {
		driveController.X.whenPressed(new SetDefaultCommand(new XboxTankDrive()));
		driveController.B.whenPressed(new SetDefaultCommand(new XboxArcadeDrive()));
		driveController.A.whenPressed(new RefreshDriveTrain());
	}
}

