package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.XboxArcadeDrive;
import org.usfirst.frc.team226.robot.commands.XboxTankDrive;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.RobotDrive.MotorType;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public SpeedController frontLeft = new Jaguar(RobotMap.FRONT_LEFT_MOTOR);
	public SpeedController rearLeft = new Jaguar(RobotMap.REAR_LEFT_MOTOR);
	public SpeedController frontRight = new Jaguar(RobotMap.FRONT_RIGHT_MOTOR);
	public SpeedController rearRight = new Jaguar(RobotMap.REAR_RIGHT_MOTOR);

	RobotDrive drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);

	int DEFAULT_COMMAND = 0;

	public DriveTrain() {
		drive.setSafetyEnabled(false);
		drive.setInvertedMotor((MotorType) frontRight, true);
		drive.setInvertedMotor((MotorType) rearRight, true);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		if (DEFAULT_COMMAND == 0) {
			setDefaultCommand(new XboxTankDrive());
		} else if (DEFAULT_COMMAND == 1) {
			setDefaultCommand(new XboxArcadeDrive());
		}
	}

	public void tankDrive(double left, double right) {
		drive.tankDrive(left, right);
	}

	public void arcadeDrive(double throttle, double turn, boolean squaredInputs) {
		drive.arcadeDrive(throttle, turn, squaredInputs);
	}

	public void setNewDefaultCommand(Command cmd) {
		if (cmd.equals(new XboxTankDrive())) {
			DEFAULT_COMMAND = 0;
		} else if (cmd.equals(new XboxArcadeDrive())) {
			DEFAULT_COMMAND = 1;
		} else {
			DEFAULT_COMMAND = 0;
		}
	}
}
