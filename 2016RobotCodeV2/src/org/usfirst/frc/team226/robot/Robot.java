
package org.usfirst.frc.team226.robot;

import org.usfirst.frc.team226.robot.subsystems.CheesyDriveTrain;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
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

	// public static final PIDDriveTrain driveTrain = new PIDDriveTrain();
	// public static final DriveTrain driveTrain = new DriveTrain();
	public static final CheesyDriveTrain cheesyDriveTrain = new CheesyDriveTrain();	
	public static OI oi;

	Command autonomousCommand;
	SendableChooser chooser;

	NetworkTable table;
	CameraServer server;

	public static double centerValue;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
		// chooser = new SendableChooser();

		server = CameraServer.getInstance();
		server.setQuality(50);
		// the camera name (ex "cam0") can be found through the roborio web interface
		server.startAutomaticCapture("cam0");

		// chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		table = NetworkTable.getTable("SharkCV/contours/0");
		// SmartDashboard.putData("Auto mode", chooser);
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 */
	public void disabledInit() {

	}

	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	public void autonomousInit() {
		autonomousCommand = (Command) chooser.getSelected();

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null)
			autonomousCommand.start();
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
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		centerValue = table.getNumber("centerX", -1);
		SmartDashboard.putNumber("Center Value", centerValue);
		
		/* NORMAL DRIVETRAIN
		SmartDashboard.putNumber("LEFT VEL", Robot.driveTrain.rearLeft.getEncVelocity());
		SmartDashboard.putNumber("RIGHT VEL", Robot.driveTrain.rearRight.getEncVelocity());
		SmartDashboard.putNumber("LEFT COUNT", Robot.driveTrain.rearLeft.getEncVelocity());
		*/
		
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
