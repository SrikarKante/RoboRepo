
package org.usfirst.frc.team226.robot;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.VictorSP;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
	
	VictorSP drive;
	PIDController cLoop;
	Encoder driveEncoder;
	
    public void robotInit() {
    	drive = new VictorSP(0);
    	driveEncoder = new Encoder(0, 0);
    	
    	//driveEncoder is input, drive is output, first 3 ints are the 3 coefficients
    	cLoop = new PIDController(1, 0, 0, driveEncoder, drive);
    }
    
    public void autonomousInit(){
    	drive.setSafetyEnabled(false);
    	cLoop.enable();
    	cLoop.setSetpoint(1000);
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
    	// getError() < 10 will tell us if the error is more than 10 away from 1000
    	if (cLoop.getError() < 10) {
    		cLoop.setSetpoint(500);
    	}
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
