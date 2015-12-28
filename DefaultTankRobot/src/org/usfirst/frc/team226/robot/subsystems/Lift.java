package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.RobotMap;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Lift extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	SpeedController leftMotor = new Jaguar(RobotMap.LEFT_LIFT_MOTOR);
	SpeedController rightMotor = new Jaguar(RobotMap.RIGHT_LIFT_MOTOR);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefualtCommand(new LiftDoNothing);
    }
    
    public void moveUp() {
    	leftMotor.set(1);
    	rightMotor.set(-1);
    }
    
    public void moveDown() {
    	leftMotor.set(-1);
    	rightMotor.set(1);
    }
    
    public void doNothing() {
    	leftMotor.set(0);
    	rightMotor.set(0);
    }
}

