package org.usfirst.frc.team226.robot;

import org.usfirst.frc.team226.robot.commands.AlternateAuton;
import org.usfirst.frc.team226.robot.commands.Auton;
import org.usfirst.frc.team226.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot {

	public static DriveTrain driveTrain;
	public static OI oi;

    Command autonomousCommand;
    SendableChooser chooser;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
		oi = new OI();
		driveTrain = new DriveTrain();
		
        chooser = new SendableChooser();
        chooser.addDefault("Default Auto", new Auton());
        chooser.addObject("Alt Auton", new AlternateAuton());
//        chooser.addObject("My Auto", new MyAutoCommand());
        SmartDashboard.putData("Auto mode", chooser);
        
        LiveWindow.addActuator("DriveTrain","frontLeft",(Jaguar)Robot.driveTrain.frontLeft);
    	LiveWindow.addActuator("DriveTrain","rearLeft",(Jaguar)Robot.driveTrain.rearLeft);
    	LiveWindow.addActuator("DriveTrain","frontRight",(Jaguar)Robot.driveTrain.frontRight);
    	LiveWindow.addActuator("DriveTrain","rearRight",(Jaguar)Robot.driveTrain.rearRight);
    }
	
	/**
     * This function is called once each time the robot enters Disabled mode.
     * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
     */
    public void disabledInit(){

    }
	
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select between different autonomous modes
	 * using the dashboard. The sendable chooser code works with the Java SmartDashboard. If you prefer the LabVIEW
	 * Dashboard, remove all of the chooser code and uncomment the getString code to get the auto name from the text box
	 * below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the chooser code above (like the commented example)
	 * or additional comparisons to the switch structure below with additional strings & commands.
	 */
    public void autonomousInit() {
        autonomousCommand = (Command) chooser.getSelected();
        
		/* String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		switch(autoSelected) {
		case "My Auto":
			autonomousCommand = new MyAutoCommand();
			break;
		case "Default Auto":
		default:
			autonomousCommand = new ExampleCommand();
			break;
		} */
    	
    	// schedule the autonomous command (example)
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
		// This makes sure that the autonomous stops running when
        // teleop starts running. If you want the autonomous to 
        // continue until interrupted by another command, remove
        // this line or comment it out.
        if (autonomousCommand != null) autonomousCommand.cancel();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        
        SmartDashboard.putNumber("Left X", oi.driveController.getLeftJoystick_X());
		SmartDashboard.putNumber("Left Y", oi.driveController.getLeftJoystick_Y());
		SmartDashboard.putNumber("Right X", oi.driveController.getRightJoystick_X());
		SmartDashboard.putNumber("Right Y", oi.driveController.getRightJoystick_Y());
		SmartDashboard.putNumber("Triggers", oi.driveController.getTriggers());
		SmartDashboard.putBoolean("A", oi.driveController.getAButtonPressed());
		SmartDashboard.putBoolean("B", oi.driveController.getBButtonPressed());
		SmartDashboard.putBoolean("X", oi.driveController.getXButtonPressed());
		SmartDashboard.putBoolean("Y", oi.driveController.getYButtonPressed());
		SmartDashboard.putBoolean("LB", oi.driveController.getLBButtonPressed());
		SmartDashboard.putBoolean("RB", oi.driveController.getRBButtonPressed());
		SmartDashboard.putBoolean("L3", oi.driveController.getL3ButtonPressed());
		SmartDashboard.putBoolean("R3", oi.driveController.getR3ButtonPressed());
		SmartDashboard.putBoolean("BACK", oi.driveController.getBACKButtonPressed());
		SmartDashboard.putBoolean("START", oi.driveController.getSTARTButtonPressed());
		SmartDashboard.putNumber("D-pad", oi.driveController.getDPad());
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
