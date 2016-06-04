package org.usfirst.frc.team226.robot;

import org.usfirst.frc.team226.robot.commands.DriveToDistance;
import org.usfirst.frc.team226.robot.commands.ResetFourbarEncoder;
import org.usfirst.frc.team226.robot.commands.SetFourbarPoint;
import org.usfirst.frc.team226.robot.subsystems.Fourbar;

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
	Button D_B = new JoystickButton(driver, 2);
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
		M_A.whenPressed(new SetFourbarPoint(Fourbar.ZERO));
		M_X.whenPressed(new SetFourbarPoint(Fourbar.HALF));
		M_Y.whenPressed(new SetFourbarPoint(Fourbar.FULL));
		M_B.whenPressed(new ResetFourbarEncoder());
		
		D_A.whenPressed(new DriveToDistance(2.0));
		D_B.whenPressed(new DriveToDistance(4.0));
	}
	
	public double getDriverLeftJoystick() {
		return driver.getY();
	}
	
	public double getDriverRightJoystick() {
		return driver.getRawAxis(5);
	}
	
	public double getManipRightJoystick() {
		return manip.getRawAxis(5);
	}
}

