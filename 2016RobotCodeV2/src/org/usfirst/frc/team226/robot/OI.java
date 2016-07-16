package org.usfirst.frc.team226.robot;

import org.usfirst.frc.team226.robot.commands.AlignVision;
import org.usfirst.frc.team226.robot.commands.Test;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public XboxController driver = new XboxController(0);
	public XboxController manip = new XboxController(1);

	public OI() {
		driver.A.whenPressed(new AlignVision());
		driver.X.whenPressed(new Test());
	}
	
}

