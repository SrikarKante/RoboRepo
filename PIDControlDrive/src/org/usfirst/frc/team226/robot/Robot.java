
package org.usfirst.frc.team226.robot;

import org.usfirst.frc.team226.robot.subsystems.DriveTrain;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.CANTalon.TalonControlMode;
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

	public static final DriveTrain driveTrain = new DriveTrain();
	public static OI oi;

	Command autonomousCommand;
	SendableChooser chooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit() {
		oi = new OI();
		chooser = new SendableChooser();
		// chooser.addDefault("Default Auto", new ExampleCommand());
		// chooser.addObject("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", chooser);
		Robot.driveTrain.resetAllSensors();
		SmartDashboard.putData("dirPID", Robot.driveTrain.dirController);
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
		
//		SmartDashboard.putNumber("Right Enc: ", Robot.driveTrain.rearRightMotor.getPosition());
//		SmartDashboard.putNumber("Left Enc: ", Robot.driveTrain.rearLeftMotor.getPosition());
//		
//		SmartDashboard.putNumber("DubEncoder ", Robot.driveTrain.doubleEncoder.pidGet());
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
		Robot.driveTrain.resetAllSensors();
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
		
//		Robot.driveTrain.rearRightMotor.changeControlMode(TalonControlMode.Position);
//		Robot.driveTrain.rearLeftMotor.changeControlMode(TalonControlMode.Position);
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
//		SmartDashboard.putNumber("Right Enc: ", Robot.driveTrain.rearRightMotor.getPosition());
//		SmartDashboard.putNumber("Left Enc: ", Robot.driveTrain.rearLeftMotor.getPosition());
//		
//		SmartDashboard.putNumber("DubEncoder ", Robot.driveTrain.doubleEncoder.pidGet());
//
//		
//		SmartDashboard.putNumber("Gyro", Robot.driveTrain.gyro.getAngle());
//		SmartDashboard.putNumber("Gyro pidget", Robot.driveTrain.gyro.pidGet());

		// =========================================================================================
		// Direction PID logs
		// Value starts big and goes to zero as your PID reaches the setpoint.
		SmartDashboard.putNumber("DirPID error", Robot.driveTrain.dirController.getError());

		// Input (distance) being returned by the encoder (PID input)
		// Value should go to the set point you specified
		SmartDashboard.putNumber("DirPID direction", Robot.driveTrain.gyro.pidGet());

		// Output (power) being applied to motors
		SmartDashboard.putNumber("DirPID output", Robot.driveTrain.dirController.get());
		
		// Output (power) being applied to motors
		SmartDashboard.putNumber("DirPID mimic .get()", Robot.driveTrain.dirMimic.getPIDOutput());

//		// =========================================================================================
//		// Distance PID logs
//		// Value starts big and goes to zero as your PID reaches the setpoint.
//		SmartDashboard.putNumber("DistPID error", Robot.driveTrain.distController.getError());
//
//		// Input (distance) being returned by the encoder (PID input)
//		// Value should go to the set point you specified
//		SmartDashboard.putNumber("DistPID distance", Robot.driveTrain.doubleEncoder.pidGet());
//
//		// Output (power) being applied to motors
//		SmartDashboard.putNumber("DistPID output", Robot.driveTrain.distController.get());
//		
//		// Output (power) being applied to motors
//		SmartDashboard.putNumber("DistPID mimic .get()", Robot.driveTrain.distMimic.getPIDOutput());
		
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic() {
		LiveWindow.run();
	}
}
