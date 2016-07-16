package org.usfirst.frc.team226.robot.commands;

import org.usfirst.frc.team226.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class AlignVision extends Command {

    public AlignVision() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
//    	requires(Robot.driveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
//    	Robot.driveTrain.setSetpoint(0);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
//        return Math.abs(Robot.driveTrain.getPosition() - 0) < 7.0;
    	return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.driveTrain.disable();
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
