package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.MoveFourbarWithJoysticks;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 *
 */
public class Fourbar extends PIDSubsystem {
	
	private static final double Kp = 0.0;
	private static final double Ki = 0.0;
	private static final double Kd = 0.0;
	
	public static final double ZERO = 0.0, HALF = 600, FULL = 1200;
	
	SpeedController leftArmMotor = new CANTalon(RobotMap.LEFT_ARM_MOTOR);
	SpeedController rightArmMotor = new CANTalon(RobotMap.RIGHT_ARM_MOTOR);
	
	Encoder encoder = new Encoder(RobotMap.LIFT_ENCODER_A, RobotMap.LIFT_ENCODER_B, false, Encoder.EncodingType.k4X);
		
    // Initialize your subsystem here
    public Fourbar() {
    	super("FourBar", Kp, Ki, Kd);
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    	encoder.setMaxPeriod(.1);
		encoder.setMinRate(10);
		encoder.setDistancePerPulse(5);
		encoder.setReverseDirection(true);
		encoder.setSamplesToAverage(5);
		
		setSetpoint(ZERO);
		enable();
		LiveWindow.addActuator("Four Bar", "PID Controller2", getPIDController());
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new MoveFourbarWithJoysticks());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return encoder.getDistance();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	moveFourBar(output);
    }
    
    public void moveFourBar(double rightJoystick) {
    	leftArmMotor.set(-rightJoystick);
    	rightArmMotor.set(rightJoystick);
    }
    
    public void resetFourbarEncoder() {
    	encoder.reset();
    }
}
