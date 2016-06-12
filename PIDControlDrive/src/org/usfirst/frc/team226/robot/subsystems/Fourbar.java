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
	
	private static final double Kp = 0.020;
	private static final double Ki = 0.0;
	private static final double Kd = 0.0;
	
	public static final double ZERO = 226.0, HALF = 600.0, FULL = 1100.0;
	
	SpeedController leftArmMotor = new CANTalon(RobotMap.LEFT_ARM_MOTOR);
	SpeedController rightArmMotor = new CANTalon(RobotMap.RIGHT_ARM_MOTOR);
	
	public Encoder encoder = new Encoder(RobotMap.LIFT_ENCODER_A, RobotMap.LIFT_ENCODER_B, false, Encoder.EncodingType.k4X);
		
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
		setAbsoluteTolerance(RobotMap.FOURBAR_ERROR);
		
		//Use continuous for sensors that continuously rotate
		//E.x. Controller is at 359 and want to get to zero. Normally it would rotate all the way back around
		//but with continuous it knows that 0 and 360 are the same and will take the shorter way
		getPIDController().setContinuous(false);
		
		setSetpoint(HALF);
		LiveWindow.addSensor(getName(), "4BarEncoder", encoder);
		LiveWindow.addActuator(getName(), "PID Controller2", getPIDController());
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
