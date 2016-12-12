package org.usfirst.frc.team226.robot.commands;

import org.usfirst.frc.team226.robot.Robot;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class HybridDrive extends Command {

	public static boolean cd;

	public HybridDrive() {
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.driveTrain);
	}

	// Called just before this Command runs the first time
	protected void initialize() {
		cd = false;
	}

	// Called repeatedly when this Command is scheduled to run
	protected void execute() {
		if (Robot.oi.driver.getBButtonPressed()) {
			cd = !cd;
			Timer.delay(0.25);
		}

		if (cd) {
			double throttle = Robot.oi.driver.getLeftJoystick_Y();
			double x = Robot.oi.driver.getRightJoystick_X();
			double y = Robot.oi.driver.getRightJoystick_Y();
			boolean quickTurn = Robot.oi.driver.getRBButtonPressed();
			Robot.driveTrain.culverDrive(throttle, x, y, quickTurn);
		} else {
			double throttle = Robot.oi.driver.getLeftJoystick_Y();
			double turn = Robot.oi.driver.getRightJoystick_X();
			boolean quickTurn = Robot.oi.driver.getRBButtonPressed();
			Robot.driveTrain.arcadeDrive(throttle, turn);
		}
	}

	// Make this return true when this Command no longer needs to run execute()
	protected boolean isFinished() {
		return false;
	}

	// Called once after isFinished returns true
	protected void end() {
		cd = false;
	}

	// Called when another command which requires one or more of the same
	// subsystems is scheduled to run
	protected void interrupted() {
	}
}
