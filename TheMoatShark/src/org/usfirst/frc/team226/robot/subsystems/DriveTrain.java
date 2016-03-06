package org.usfirst.frc.team226.robot.subsystems;

import org.usfirst.frc.team226.robot.RobotMap;
import org.usfirst.frc.team226.robot.commands.DriveWithJoysticks;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class DriveTrain extends Subsystem {
    
    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	SpeedController leftMotor = new Jaguar(RobotMap.LEFT_DRIVE_MOTOR);
	SpeedController rightMotor = new Jaguar(RobotMap.RIGHT_DRIVE_MOTOR);
	
	RobotDrive drive = new RobotDrive(leftMotor, rightMotor);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new DriveWithJoysticks());
    }
    
    public void tankDrive(double leftJoystick, double rightJoystick) {
    	drive.tankDrive(leftJoystick, rightJoystick);
    }
}

