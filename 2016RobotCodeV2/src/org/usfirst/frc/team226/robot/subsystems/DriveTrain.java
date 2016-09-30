package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.CulverDrive;
import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.CheesyDrive;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

	public SpeedController rearRightMotor = new CANTalon(RobotMap.REAR_RIGHT_DRIVE);
	public SpeedController frontRightMotor = new CANTalon(RobotMap.FRONT_RIGHT_DRIVE);
	public SpeedController rearLeftMotor = new CANTalon(RobotMap.REAR_LEFT_DRIVE);
	public SpeedController frontLeftMotor = new CANTalon(RobotMap.FRONT_LEFT_DRIVE);

	RobotDrive drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

	// ENCODERS
	public CANTalon rearLeft = new CANTalon(RobotMap.LEFT_ENCODER);
	public CANTalon rearRight = new CANTalon(RobotMap.RIGHT_ENCODER);

	// TUNE THESE
	private static final double SKIM_GAIN = 0.5;
	private static final double TURN_GAIN = 1.0;

	public void initDefaultCommand() {
		setDefaultCommand(new CheesyDrive());
	}

	public void tankDrive(double left, double right) {
		drive.tankDrive(left, right);
	}

	public void arcadeDrive(double throttle, double turn, boolean squaredInputs) {
		drive.arcadeDrive(throttle, turn, squaredInputs);
	}
	
	public void culverDrive(double throttle, double x, double y, boolean quickTurn) {
		CulverDrive.culverDrive(drive, throttle, x, y, quickTurn);
	}

	public void cheesyDrive(double throttle, double turn, boolean quickTurn) {
		if (!quickTurn) {
			turn = turn * (TURN_GAIN * Math.abs(throttle));
		}

		double t_left = throttle - turn;
		double t_right = throttle + turn;

		double left = t_left + skim(t_right);
		double right = t_right + skim(t_left);

		drive.tankDrive(left, right);
	}

	double skim(double v) {
		if (v > 1.0) {
			return -((v - 1.0) * SKIM_GAIN);
		} else if (v < -1.0) {
			return -((v + 1.0) * SKIM_GAIN);
		} else {
			return 0;
		}
	}

}
