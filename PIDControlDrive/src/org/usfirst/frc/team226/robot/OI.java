package org.usfirst.frc.team226.robot;

import org.usfirst.frc.team226.robot.commands.SetFourBarPoint;
import org.usfirst.frc.team226.robot.subsystems.FourBar;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	Joystick driver = new Joystick(0);
	Joystick manip = new Joystick(1);
	
	Button D_A = new JoystickButton(driver, 1);
	Button D_X= new JoystickButton(driver, 3);
	Button D_LB = new JoystickButton(driver, 5);
	Button D_RB = new JoystickButton(driver, 6);
	Button D_LS = new JoystickButton(driver, 9);
	Button M_A = new JoystickButton(manip, 1);
	Button M_B = new JoystickButton(manip, 2);
	Button M_X = new JoystickButton(manip, 3);
	Button M_Y = new JoystickButton(manip, 4);
	Button M_LB = new JoystickButton(manip, 5);
	Button M_RB = new JoystickButton(manip, 6);
	Button M_SELECT = new JoystickButton(manip, 7);
	Button M_START = new JoystickButton(manip, 8);
	Button M_LS = new JoystickButton(manip, 9);
	Button M_RS = new JoystickButton(manip, 10);
	
	public OI() {
		M_A.whenPressed(new SetFourBarPoint(FourBar.ZERO));
		M_X.whenPressed(new SetFourBarPoint(FourBar.HALF));
		M_Y.whenPressed(new SetFourBarPoint(FourBar.FULL));
	}
	
	public double getLeftJoystick() {
		return driver.getY();
	}
	
	public double getRightJoystick() {
		return driver.getRawAxis(5);
	}
	
	public double getManipRightJoystick() {
		return manip.getRawAxis(5);
	}
}

