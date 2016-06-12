package org.usfirst.frc.team226.robot;
/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // For example to map the left and right motors, you could define the
    // following variables to use with your drivetrain subsystem.
    // public static int leftMotor = 1;
    // public static int rightMotor = 2;
    
    // If you are using multiple modules, make sure to define both the port
    // number and the module. For example you with a rangefinder:
    // public static int rangefinderPort = 1;
    // public static int rangefinderModule = 1;
	
	public static final int REAR_LEFT_DRIVE = 6;
	public static final int FRONT_LEFT_DRIVE = 5;
	public static final int REAR_RIGHT_DRIVE = 2;
	public static final int FRONT_RIGHT_DRIVE = 1;
	
	public static final int LEFT_ARM_MOTOR = 7;
	public static final int RIGHT_ARM_MOTOR = 8;
	
	public static final int LEFT_LIFT_MOTOR = 4;
	public static final int RIGHT_LIFT_MOTOR = 3;
	
	public static final int INTAKE_MOTOR = 10;
	
	public static final int LEFT_SHOOTER_MOTOR = 9;
	public static final int RIGHT_SHOOTER_MOTOR = 11;
	
	public static final int WINCH_SERVO = 0;
	public static final int CAMERA_SERVO = 1;
	
	public static final int LIFT_ENCODER_A = 8;
	public static final int LIFT_ENCODER_B = 9;
	
	public static final int WINCH_DELAY = 120;
	
	public static final int LIGHT_SPIKE = 0;
	
	public static final int LEFT_ENCODER = 6;
	public static final int RIGHT_ENCODER = 2;
	
	public static final double SHOOTER_DELAY = 5.0;
}
