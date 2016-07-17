package org.usfirst.frc.team226.robot.commands;

import org.usfirst.frc.team226.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class CheesyDrive extends Command {

	double throttle;
	double turn;
	public static boolean turnButton = false;

	public CheesyDrive() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.cheesyDriveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.oi.driveController.getLBButtonPressed()) {
			turnButton = false;
		} else {
			turnButton = true;
		}

		throttle = Robot.oi.driveController.getLeftJoystick_Y();
		turn = Robot.oi.driveController.getRightJoystick_X();

		Robot.cheesyDriveTrain.cheesyDrive(throttle, turn);
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
