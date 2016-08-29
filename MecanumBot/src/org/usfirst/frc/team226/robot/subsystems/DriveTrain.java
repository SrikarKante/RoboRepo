
package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.XboxMecanumDrive;

import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

	public SpeedController frontLeft = new Victor(RobotMap.FRONT_LEFT_MOTOR);
	public SpeedController rearLeft = new Victor(RobotMap.REAR_LEFT_MOTOR);
	public SpeedController frontRight = new Victor(RobotMap.FRONT_RIGHT_MOTOR);
	public SpeedController rearRight = new Victor(RobotMap.REAR_RIGHT_MOTOR);
	
	RobotDrive drive = new RobotDrive(frontLeft, rearLeft, frontRight, rearRight);

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new XboxMecanumDrive());
	}

	public void mecanumDrive(double x, double y, double multiplier) {
		double AfrontLeft = (x - y) * multiplier;
		double BrearLeft = (x + y) * multiplier;
		double CfrontRight = (x + y) * multiplier;
		double DrearRight = (x - y) * multiplier;
		
		this.setMotorSpeed(AfrontLeft, BrearLeft, CfrontRight, DrearRight);
	}
	
	public void mecanumRobotDrive(double x, double y, double rotation, double gyroAngle) {
		drive.mecanumDrive_Cartesian(x, y, rotation, gyroAngle);
	}

	void setMotorSpeed(double frontLeft, double rearLeft, double frontRight, double rearRight) {
		this.frontLeft.set(frontLeft);
		this.rearLeft.set(rearLeft);
		this.frontRight.set(frontRight);
		this.rearRight.set(rearRight);
	}
}
