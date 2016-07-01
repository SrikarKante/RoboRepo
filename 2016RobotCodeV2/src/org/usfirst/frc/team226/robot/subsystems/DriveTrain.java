package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {

	public SpeedController rearRightMotor = new CANTalon(RobotMap.REAR_RIGHT_DRIVE);
	public SpeedController frontRightMotor = new CANTalon(RobotMap.FRONT_RIGHT_DRIVE);
	public SpeedController rearLeftMotor = new CANTalon(RobotMap.REAR_LEFT_DRIVE);
	public SpeedController frontLeftMotor = new CANTalon(RobotMap.FRONT_LEFT_DRIVE);
	
	RobotDrive drive = new RobotDrive(frontLeftMotor, rearLeftMotor, frontRightMotor, rearRightMotor);
	
	public CANTalon rearLeft = new CANTalon(RobotMap.LEFT_ENCODER);
    public CANTalon rearRight = new CANTalon(RobotMap.RIGHT_ENCODER);
    
    
	
//	Accelerometer accel = new BuiltInAccelerometer();
	
//	Gyro gyro = new AnalogGyro(channel); //0 or 1
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		setDefaultCommand(new DriveWithJoysticks());
	}
	
	public void tankDrive(double leftJoystick, double rightJoystick) {
		drive.tankDrive(leftJoystick, rightJoystick);
	}
	
	double oldInput = 0;
	
	//Constants
	final int NORMAL = 0, RAMPING_UP = 1, RAMPING_DOWN = 2;
	
	final double RAMPING_CONSTANT = 0.005;
	
	final double DELTA_LIMIT = 0.5;
	
	public double driveRamp(double input) {
		int mode = 0;
		
		double capture_value = 0, output = 0;
		
		double delta = input - this.oldInput;
		
		if(delta >= DELTA_LIMIT) { 
			mode=RAMPING_UP; 
			capture_value = input;
		}else if(delta <= -DELTA_LIMIT) { 
			mode=RAMPING_DOWN; 
			capture_value = input;
		} 
		
		switch(mode){
		//RAMPING UP
			case 1: 
				output+= RAMPING_CONSTANT;
				if(output >= capture_value) { mode = NORMAL; }
				break;
				
		//RAMPING DOWN		
			case 2:
				output-= RAMPING_CONSTANT;
				if(output <= capture_value) { mode = NORMAL; }
				break;
				
			case 0:
				output = input;
				break;
		}
		
		oldInput = input;
		
		return output;
	}
}
