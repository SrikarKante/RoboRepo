package org.usfirst.frc.team226.robot.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class cmdgrpAutonOne extends CommandGroup {
	
	private boolean left = true;
	private boolean right = false;
    
    public  cmdgrpAutonOne() {
    	//addSequential(new autonDrive(0.6), 0.7);
    	addSequential(new autonRotate(0.9, left), 2);
    }
}
