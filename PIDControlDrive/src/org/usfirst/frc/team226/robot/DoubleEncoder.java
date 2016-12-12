package org.usfirst.frc.team226.robot;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDSourceType;

public class DoubleEncoder implements PIDSource{
	
	private CANTalon leftEncoder;
	private CANTalon rightEncoder;
	
	private boolean leftEncoderInverted = false;
	private boolean rightEncoderInverted = false;
	
	private PIDSourceType pidSource;
	
	public DoubleEncoder(CANTalon leftEncoder, CANTalon rightEncoder, PIDSourceType pidSource) {
		this.leftEncoder = leftEncoder;
		this.rightEncoder = rightEncoder;
		this.pidSource = pidSource;
	}
	
	@Override
	public void setPIDSourceType(PIDSourceType pidSource) {
		this.pidSource = pidSource;
	}

	@Override
	public PIDSourceType getPIDSourceType() {
		// TODO Auto-generated method stub
		return pidSource;
	}

	@Override
	public double pidGet() {
		double leftEncoderValue;
		double rightEncoderValue;
		
		if (leftEncoderInverted) {
			leftEncoderValue = -leftEncoder.getPosition();
		}
		else {
			leftEncoderValue = leftEncoder.getPosition();
		}
		if (rightEncoderInverted) {
			rightEncoderValue = -rightEncoder.getPosition();
		}
		else {
			rightEncoderValue = rightEncoder.getPosition();
		}
		
		return (leftEncoderValue + rightEncoderValue) / 2.0;
	}

	public void reset() {
		leftEncoder.setPosition(0);
		rightEncoder.setPosition(0);
	}
	
	public void setLeftEncoderInverted(boolean isInverted) {
		leftEncoderInverted = isInverted;
	}
	
	public void setRightEncoderInverted(boolean isInverted) {
		rightEncoderInverted = isInverted;
	}

}
