//package org.usfirst.frc.team226.robot.subsystems;
//
//import org.usfirst.frc.team226.robot.Robot;
//import org.usfirst.frc.team226.robot.RobotMap;
//import org.usfirst.frc.team226.robot.commands.DriveWithJoysticks;
//
//import edu.wpi.first.wpilibj.CANTalon;
//import edu.wpi.first.wpilibj.RobotDrive;
//import edu.wpi.first.wpilibj.SpeedController;
//import edu.wpi.first.wpilibj.command.PIDSubsystem;
//
///**
// *
// */
//public class PIDDriveTrain extends PIDSubsystem {
//
//	private static final double Kp = 0.0;
//	private static final double Ki = 0.0;
//	private static final double Kd = 0.0;
////
////	SpeedController rearRightMotor = new CANTalon(RobotMap.REAR_RIGHT_DRIVE);
////	SpeedController frontRightMotor = new CANTalon(RobotMap.FRONT_RIGHT_DRIVE);
////	SpeedController rearLeftMotor = new CANTalon(RobotMap.REAR_LEFT_DRIVE);
////	SpeedController frontLeftMotor = new CANTalon(RobotMap.FRONT_LEFT_DRIVE);
////
////	RobotDrive drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
//
//	// Initialize your subsystem here
//	public PIDDriveTrain() {
//		super("Drive Train", Kp, Ki, Kd);
//		// Use these to get going:
//		// setSetpoint() - Sets where the PID controller should move the system
//		// to
//		// enable() - Enables the PID controller.
//		// enable();
//		this.disable();
//	}
//
//	public void initDefaultCommand() {
//		// Set the default command for a subsystem here.
//		//setDefaultCommand(new DriveWithJoysticks());
//	}
//
//	protected double returnPIDInput() {
//		// Return your input value for the PID loop
//		// e.g. a sensor, like a potentiometer:
//		// yourPot.getAverageVoltage() / kYourMaxVoltage;
//		return Robot.centerValue;
//	}
//
//	protected void usePIDOutput(double output) {
//		// Use output to drive your system, like a motor
//		// e.g. yourMotor.set(output);
//		tankDrive(output, output);
//	}
//
//	public void tankDrive(double left, double right) {
//		// Correct inversion
//		drive.tankDrive(-left, -right);
//	}
//}