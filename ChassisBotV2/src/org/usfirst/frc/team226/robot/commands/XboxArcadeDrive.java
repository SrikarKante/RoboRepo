package org.usfirst.frc.team226.robot.commands;

import org.usfirst.frc.team226.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class XboxArcadeDrive extends Command {

	public static boolean demo = false;

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
		if (!demo) {
			double throttle = Robot.oi.driveController.getLeftJoystick_Y();
			double turn = Robot.oi.driveController.getRightJoystick_X();

			Robot.driveTrain.arcadeDrive(throttle, turn, true);
		}
		else if (demo) {
			if (Robot.oi.driveController.getLeftJoystick_Y() > ) {
			double throttle = (0.5*Robot.oi.demoController.getLeftJoystick_Y());
			}
			double turn = (0.5*Robot.oi.demoController.getRightJoystick_X());

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
