package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.DriveWithLeftJoystick;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class LeftDriveTrain extends PIDSubsystem {
	
	private static final double Kp = 2.0;
	private static final double Ki = 0.0;
	private static final double Kd = 0.0;
	
	private SpeedController rearLeftMotor = new CANTalon(RobotMap.REAR_LEFT_DRIVE);
	private SpeedController frontLeftMotor = new CANTalon(RobotMap.FRONT_LEFT_DRIVE);

	RobotDrive drive = new RobotDrive(frontLeftMotor, rearLeftMotor);
	
	public CANTalon rearLeft = new CANTalon(RobotMap.LEFT_ENCODER);

    // Initialize your subsystem here
    public LeftDriveTrain() {
    	super("LeftDriveTrain", Kp, Ki, Kd);
    	
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	drive.setSafetyEnabled(false);
    	LiveWindow.addActuator(getName(), "PID Controller", getPIDController());
    	LiveWindow.addSensor(getName(), "LEncoder", rearLeft);
    	enable();
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new DriveWithLeftJoystick());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return rearLeft.get();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	tankDrive(output);
    }
    
    public void tankDrive(double left) {
    	//Correct inversion
    	drive.tankDrive(left*-1, left);
    }
}
