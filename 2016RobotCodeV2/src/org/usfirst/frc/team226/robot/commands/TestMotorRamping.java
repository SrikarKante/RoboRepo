package org.usfirst.frc.team226.robot.commands;

import org.usfirst.frc.team226.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TestMotorRamping extends Command {

    public TestMotorRamping() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	requires(Robot.cheesyDriveTrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	for (double i = 0; i < 1; i+=0.01) {
    		Robot.cheesyDriveTrain.tankDrive(i, i);
    	}
    	
    	for (double i = 1; i > 0; i-=0.01) {
    		Robot.cheesyDriveTrain.tankDrive(i, i);
    	}
    	Robot.cheesyDriveTrain.tankDrive(0, 0);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return true;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}