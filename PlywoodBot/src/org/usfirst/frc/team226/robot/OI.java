package org.usfirst.frc.team226.robot;

import org.usfirst.frc.team226.robot.commands.DemoDriveToggle;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public XboxController driveController = new XboxController(0);
	public XboxController demoController = new XboxController(1);
	
	public void OI() {
//		driveController.A.whenPressed(new DemoDriveToggle());
	}
}

