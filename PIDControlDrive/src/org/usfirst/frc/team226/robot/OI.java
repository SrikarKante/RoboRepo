package org.usfirst.frc.team226.robot;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	
	public Controller driver = new Controller(0);
	
	public OI() {
//		driver.getLBButton().whenPressed(new cmdPIDTurnToAngle(10));
//		driver.getXButton().whenPressed(new cmdPIDTurnToAngle(45));
//		driver.getYButton().whenPressed(new cmdPIDTurnToAngle(90));
//		driver.getBButton().whenPressed(new cmdPIDTurnToAngle(180));
//		driver.getAButton().whenPressed(new cmdResetAllSensors());
	}
}

