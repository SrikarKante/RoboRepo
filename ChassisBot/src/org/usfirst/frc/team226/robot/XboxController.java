package org.usfirst.frc.team226.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * @author Alec Minchington
 */

public class XboxController extends Joystick {

	public XboxController(int usbPort) {
		super(usbPort);
	}

	Button A = new JoystickButton(this, 1);
	Button B = new JoystickButton(this, 2);
	Button X = new JoystickButton(this, 3);
	Button Y = new JoystickButton(this, 4);
	Button LB = new JoystickButton(this, 5);
	Button RB = new JoystickButton(this, 6);
	Button BACK = new JoystickButton(this, 7);
	Button START = new JoystickButton(this, 8);
	Button LS = new JoystickButton(this, 9);
	Button RS = new JoystickButton(this, 10);

	// STICKS

	/**
	 * @return X-value of the left joystick
	 */
	public double getLeftJoystick_X() {
		return getRawAxis(1);
	}

	/**
	 * @return Y-value of the left joystick
	 */
	public double getLeftJoystick_Y() {
		return getRawAxis(2);
	}

	/**
	 * @return X-value of the right joystick
	 */
	public double getRightJoystick_X() {
		return getRawAxis(4);
	}

	/**
	 * @return Y-value of the right joystick
	 */
	public double getRightJoystick_Y() {
		return getRawAxis(5);
	}

	// BUTTONS

	/**
	 * Gets current state of the A button.
	 * <p>
	 * 
	 * @return {@code true} if the A button is pressed, {@code false} otherwise
	 */
	public boolean getAButtonPressed() {
		return getRawButton(1);
	}

	/**
	 * Gets current state of the B button.
	 * <p>
	 * 
	 * @return {@code true} if the B button is pressed, {@code false} otherwise
	 */
	public boolean getBButtonPressed() {
		return getRawButton(2);
	}

	/**
	 * Gets current state of the X button.
	 * <p>
	 * 
	 * @return {@code true} if the X button is pressed, {@code false} otherwise
	 */
	public boolean getXButtonPressed() {
		return getRawButton(3);
	}

	/**
	 * Gets current state of the Y button.
	 * <p>
	 * 
	 * @return {@code true} if the Y button is pressed, {@code false} otherwise
	 */
	public boolean getYButtonPressed() {
		return getRawButton(4);
	}

	/**
	 * Gets current state of the left bumper.
	 * <p>
	 * 
	 * @return {@code true} if the left bumper is pressed, {@code false}
	 *         otherwise
	 */
	public boolean getLBButtonPressed() {
		return getRawButton(5);
	}

	/**
	 * Gets current state of the right bumper.
	 * <p>
	 * 
	 * @return {@code true} if the right bumper is pressed, {@code false}
	 *         otherwise
	 */
	public boolean getRBButtonPressed() {
		return getRawButton(6);
	}

	/**
	 * Gets current state of the BACK button.
	 * <p>
	 * 
	 * @return {@code true} if the BACK button is pressed, {@code false}
	 *         otherwise
	 */
	public boolean getBACKButtonPressed() {
		return getRawButton(7);
	}

	/**
	 * Gets current state of the START button.
	 * <p>
	 * 
	 * @return {@code true} if the START button is pressed, {@code false}
	 *         otherwise
	 */
	public boolean getSTARTButtonPressed() {
		return getRawButton(8);
	}

	/**
	 * Gets current state of the left stick.
	 * <p>
	 * 
	 * @return {@code true} if the left stick is clicked in, {@code false}
	 *         otherwise
	 */
	public boolean getL3ButtonPressed() {
		return getRawButton(9);
	}

	/**
	 * Gets current state of the right stick.
	 * <p>
	 * 
	 * @return {@code true} if the right stick is clicked in, {@code false}
	 *         otherwise
	 */
	public boolean getR3ButtonPressed() {
		return getRawButton(10);
	}

	/**
	 * Both triggers use the same axis. The left is positive and right is
	 * negative. This means that the two triggers' values add to give the
	 * result, so pressing both gives 0.
	 * <p>
	 * 
	 * @return value of the axis of the triggers
	 */
	public double getTriggers() {
		return getRawAxis(3);
	}

	/**
	 * Gets current angle of the directional pad.
	 * <p>
	 * 
	 * @return value of the directional pad POV-hat (angle 0-360)
	 */
	public int getDPad() {
		return getPOV(0);
	}
}