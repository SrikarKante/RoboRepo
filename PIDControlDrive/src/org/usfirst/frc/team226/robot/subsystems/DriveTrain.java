package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.CheesyDrive;
import org.usfirst.frc.team226.robot.CulverDrive;
import org.usfirst.frc.team226.robot.DoubleEncoder;
import org.usfirst.frc.team226.robot.PIDOutputMimic;
import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.HybridDrive;

import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class DriveTrain extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	// right encoder
	public CANTalon rearRightMotor = new CANTalon(RobotMap.REAR_RIGHT_MOTOR); // 2
	public CANTalon frontRightMotor = new CANTalon(RobotMap.FRONT_RIGHT_MOTOR);
	// left encoder
	public CANTalon rearLeftMotor = new CANTalon(RobotMap.REAR_LEFT_MOTOR); // 6
	public CANTalon frontLeftMotor = new CANTalon(RobotMap.FRONT_LEFT_MOTOR);

	RobotDrive drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);

	// Distance PID
	private static double distKp = 1.0;
	private static double distKi = 0.0;
	private static double distKd = 0.0;

	public DoubleEncoder doubleEncoder = new DoubleEncoder(rearLeftMotor, rearRightMotor, PIDSourceType.kDisplacement);
	public PIDOutputMimic distMimic = new PIDOutputMimic();
	public PIDController distController = new PIDController(distKp, distKi, distKd, doubleEncoder, distMimic);

	// Direction PID
	private static double dirKp = 0.0; // 0.051 for just P controller
	private static double dirKi = 0.0;
	private static double dirKd = 0.0;

	public AnalogGyro gyro = new AnalogGyro(0);
	public PIDOutputMimic dirMimic = new PIDOutputMimic();
	public PIDController dirController = new PIDController(dirKp, dirKi, dirKd, gyro, dirMimic);

	public DriveTrain() {
//		  enc1.setDistancePerPulse((Math.PI*8) / 256.0);
//		  enc1.setPIDSourceType(PIDSourceType.kDisplacement);
		  // dpp = wheel circumference / ppr of encoder 
		  // dpp = 8pi" / 256ppr = 0.09817477 in/pulse
		  // 8pi" = 256 pulses = 8pi/256
		  // unit to pulses = unit/(circumference/ppr)
		  // unit to pulses = unit*ppr / circumference
		LiveWindow.addActuator("dirPID", 0, dirController);
		doubleEncoder.setRightEncoderInverted(true);
		dirController.setOutputRange(-1, 1);
		distController.setOutputRange(-1, 1);
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new HybridDrive());
	}
	
	public void cheesyDrive(double throttle, double turn, boolean quickTurn) {
		CheesyDrive.cheesyDrive(drive, throttle, turn, quickTurn);
	}
	
	public void culverDrive(double throttle, double x, double y, boolean quickTurn) {
		CulverDrive.culverDrive(drive, throttle, x, y, quickTurn);
	}

	public void arcadeDrive(double throttle, double turn) {
		drive.arcadeDrive(throttle, turn);
	}
	
	public void tankDrive(double left, double right) {
		drive.tankDrive(left, right);
	}

	public void resetAllSensors() {
		gyro.reset();
		doubleEncoder.reset();
		rearLeftMotor.setPosition(0);
		rearRightMotor.setPosition(0);
		dirController.reset();
	}
}
