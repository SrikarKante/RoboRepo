package org.usfirst.frc.team226.robot.commands;

import org.usfirst.frc.team226.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class XboxArcadeDrive extends Command {

	public XboxArcadeDrive() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.oi.driveController.getAButtonPressed()) {
			Robot.driveTrain.demoDriveEnabled = !Robot.driveTrain.demoDriveEnabled;
		}

		if (!Robot.driveTrain.demoDriveEnabled) {
			double throttle = Robot.oi.driveController.getLeftJoystick_Y();
			double turn = Robot.oi.driveController.getRightJoystick_X();

			Robot.driveTrain.arcadeDrive(throttle, turn, true);
		} else if (Robot.driveTrain.demoDriveEnabled) {
			double throttle = (Robot.oi.driveController.getLeftJoystick_Y()
					+ (0.5 * Robot.oi.demoController.getLeftJoystick_Y()));
			
			double turn = (Robot.oi.driveController.getRightJoystick_X()
					+ (0.8 * Robot.oi.demoController.getRightJoystick_X()));
			/*
			 * if (Robot.oi.driveController.getLeftJoystick_Y() != 0 ||
			 * Robot.oi.driveController.getRightJoystick_X() != 0) { throttle =
			 * Robot.oi.driveController.getLeftJoystick_Y(); turn =
			 * Robot.oi.driveController.getRightJoystick_X(); } else { throttle
			 * = (0.5 * Robot.oi.demoController.getLeftJoystick_Y()); turn =
			 * (0.5 * Robot.oi.demoController.getRightJoystick_X()); }
			 */ 
			Robot.driveTrain.arcadeDrive(throttle, turn, true);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
