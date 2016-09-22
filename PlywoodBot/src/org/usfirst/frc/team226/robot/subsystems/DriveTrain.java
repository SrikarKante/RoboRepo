
package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.Robot;
import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.XboxArcadeDrive;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.interfaces.Gyro;

/**
 *
 */
public class DriveTrain extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.
	public boolean demoDriveEnabled = false;

	private SpeedController frontLeft = new Jaguar(RobotMap.FRONT_LEFT_MOTOR);
	private SpeedController rearLeft = new Jaguar(RobotMap.REAR_LEFT_MOTOR);
	private SpeedController frontRight = new Jaguar(RobotMap.FRONT_RIGHT_MOTOR);
	private SpeedController rearRight = new Jaguar(RobotMap.REAR_RIGHT_MOTOR);

	private RobotDrive drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new XboxArcadeDrive());
	}

	public void tankDrive(double left, double right) {
		drive.tankDrive(left, right);
	}

	public void arcadeDrive(double throttle, double turn, boolean squaredInputs) {
		drive.arcadeDrive(throttle, turn, squaredInputs);
	}
	
	public void culverDrive(double throttle, double x, double y, boolean quickTurn) {
		.
	}

	public void setMotorsInverted() {
		frontLeft.setInverted(true);
		rearLeft.setInverted(true);
		frontRight.setInverted(true);
		rearRight.setInverted(true);
	}

	public void autonRotate(double speed, boolean turnLeft) {
		if (turnLeft) {
			Robot.driveTrain.tankDrive(-speed, speed);
		} else {
			Robot.driveTrain.tankDrive(speed, -speed);
		}
	}
}
