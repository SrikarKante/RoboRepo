package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.CheesyDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class RampAlgDriveTrain extends Subsystem {

	public SpeedController rearRightMotor = new CANTalon(RobotMap.REAR_RIGHT_DRIVE);
	public SpeedController frontRightMotor = new CANTalon(RobotMap.FRONT_RIGHT_DRIVE);
	public SpeedController rearLeftMotor = new CANTalon(RobotMap.REAR_LEFT_DRIVE);
	public SpeedController frontLeftMotor = new CANTalon(RobotMap.FRONT_LEFT_DRIVE);

	RobotDrive drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

	public CANTalon rearLeft = new CANTalon(RobotMap.LEFT_ENCODER);
	public CANTalon rearRight = new CANTalon(RobotMap.RIGHT_ENCODER);

	// Constants
	final int NORMAL = 0, RAMPING_UP = 1, RAMPING_DOWN = 2;

	final double RAMPING_CONSTANT = 0.005;
	
	double rightAdjustment = 0;
	
	double leftAdjustment = 0;

	final double DELTA_LIMIT = 0.5;

	// Accelerometer accel = new BuiltInAccelerometer();

	// Gyro gyro = new AnalogGyro(channel); //0 or 1

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new CheesyDrive());
	}

	public void tankDrive(double leftJoystick, double rightJoystick) {
		drive.tankDrive(leftJoystick, rightJoystick);
	}

	double oldInputLeft = 0;
	
	int leftMode = 0;

	public double driveRampLeft(double leftInput) {

		double delta = leftInput - this.oldInputLeft;

		if (delta >= DELTA_LIMIT) {
			leftMode = RAMPING_UP;
		} else if (delta <= -DELTA_LIMIT) {
			leftMode = RAMPING_DOWN;
		}

		switch (leftMode) {
		case RAMPING_UP:
			leftAdjustment += RAMPING_CONSTANT;
			if (leftAdjustment >= leftInput) {
				leftMode = NORMAL;
			}
			break;

		case RAMPING_DOWN:
			leftAdjustment -= RAMPING_CONSTANT;
			if (leftAdjustment <= leftInput) {
				leftMode = NORMAL;
			}
			break;

		case NORMAL:
			leftAdjustment = leftInput;
			break;
		}

		this.oldInputLeft = leftInput;

		return leftAdjustment;
	}

	double oldInputRight = 0;
	
	int rightMode = 0;

	public double driveRampRight(double rightInput) {

		double delta = rightInput - this.oldInputRight;

		if (delta >= DELTA_LIMIT) {
			rightMode = RAMPING_UP;
		} else if (delta <= -DELTA_LIMIT) {
			rightMode = RAMPING_DOWN;
		}

		switch (rightMode) {
		// RAMPING UP
		case 1:
			rightAdjustment += RAMPING_CONSTANT;
			if (rightAdjustment >= rightInput) {
				rightMode = NORMAL;
			}
			break;

		// RAMPING DOWN
		case 2:
			rightInput -= RAMPING_CONSTANT;
			if (rightAdjustment <= rightInput) {
				rightMode = NORMAL;
			}
			break;

		case 0:
			rightAdjustment = rightInput;
			break;
		}

		this.oldInputRight = rightInput;

		return rightAdjustment;
	}
}
