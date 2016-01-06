package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.ClawDoNothing;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Claw extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	Solenoid piston = new Solenoid(RobotMap.CLAW_PISTON);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new ClawDoNothing());
    }
    
    public void open() {
    	piston.set(true);
    }
    
    public void close() {
    	piston.set(false);
    }
    
    public void dontMove() {
    	piston.set(piston.get());
    }
}

