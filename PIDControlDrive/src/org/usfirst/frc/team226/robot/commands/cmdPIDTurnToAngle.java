package org.usfirst.frc.team226.robot.commands;

import org.usfirst.frc.team226.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class cmdPIDTurnToAngle extends Command {
	
	private int angle;

    public cmdPIDTurnToAngle(int angle) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.driveTrain);
    	this.angle = angle;
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	if (Math.abs(angle) <= 15) {
//    		Robot.driveTrain.dirController.setPID(0.045, 0.0075, 0);
//    		Robot.driveTrain.dirController.setAbsoluteTolerance(0.05);
//    	}
//    	else {
//    		Robot.driveTrain.dirController.setPID(0.075, 0.008, 0.1);
//    		Robot.driveTrain.dirController.setAbsoluteTolerance(0.2);
//    	}
    	Robot.driveTrain.dirController.setSetpoint(angle);
    	Robot.driveTrain.dirController.enable();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	double turn = Robot.driveTrain.dirController.get();
    	
    	Robot.driveTrain.tankDrive(turn, -turn);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        return Robot.oi.driver.getBACKButtonPressed();
    	 return Math.abs(Robot.driveTrain.dirController.getError()) < 0.05;
    }

    // Called once after isFinished returns true
    protected void end() {
    	Robot.driveTrain.dirController.disable();
//    	Robot.driveTrain.resetAllSensors();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
