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
public class CheesyDriveTrain extends Subsystem {

	public SpeedController rearRightMotor = new CANTalon(RobotMap.REAR_RIGHT_DRIVE);
	public SpeedController frontRightMotor = new CANTalon(RobotMap.FRONT_RIGHT_DRIVE);
	public SpeedController rearLeftMotor = new CANTalon(RobotMap.REAR_LEFT_DRIVE);
	public SpeedController frontLeftMotor = new CANTalon(RobotMap.FRONT_LEFT_DRIVE);

	RobotDrive drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

	// TUNE THESE
	private static final double SKIM_GAIN = 1.0;
	private static final double TURN_GAIN = 1.0;

	public void initDefaultCommand() {
		setDefaultCommand(new CheesyDrive());
	}

	public void cheesyDrive(double throttle, double turn) {
		if (!getTurnButton()) {
			turn = turn * (TURN_GAIN * Math.abs(throttle));
		}

		double t_left = throttle - turn;
		double t_right = throttle + turn;

		drive.tankDrive(t_left + skim(t_right), t_right + skim(t_left));
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

	public void tankDrive(double left, double right) {
		drive.tankDrive(left, right);
	}

	boolean getTurnButton() {
		return CheesyDrive.turnButton;
	}
}
