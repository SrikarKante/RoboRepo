package org.usfirst.frc.team226.robot;

import org.usfirst.frc.team226.robot.commands.AutoPop;
import org.usfirst.frc.team226.robot.commands.CameraServoToggle;
import org.usfirst.frc.team226.robot.commands.DriveWithVision;
import org.usfirst.frc.team226.robot.commands.IntakeWheelsForward;
import org.usfirst.frc.team226.robot.commands.LightSpikeToggle;
import org.usfirst.frc.team226.robot.commands.MoveFourBarEncoderReset;
import org.usfirst.frc.team226.robot.commands.MoveFourBarToSetpointFull;
import org.usfirst.frc.team226.robot.commands.MoveFourBarToSetpointHalf;
import org.usfirst.frc.team226.robot.commands.MoveFourBarToSetpointZero;
import org.usfirst.frc.team226.robot.commands.MoveWinchFullSpeed;
import org.usfirst.frc.team226.robot.commands.ShooterWheelsBackward;
import org.usfirst.frc.team226.robot.commands.ShooterWheelsForward;
import org.usfirst.frc.team226.robot.commands.ShooterWheelsForwardRelease;
import org.usfirst.frc.team226.robot.commands.TestMotorRamping;
import org.usfirst.frc.team226.robot.commands.WinchServoToggle;

import sun.applet.resources.MsgAppletViewer_zh_CN;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

	public XboxController driveController = new XboxController(0);
	public XboxController manipController = new XboxController(1);

	public OI() {
//		driveController.X.whenPressed(new TestMotorRamping());
		driveController.A.whileHeld(new DriveWithVision());
		driveController.X.whenPressed(new LightSpikeToggle());
//	obsolete	D_RB.whileHeld(new MoveWinchFullSpeed());
//	obsolete	D_LS.whenPressed(new CameraServoToggle());
		manipController.A.whileHeld(new MoveFourBarToSetpointZero());
		manipController.B.whenPressed(new MoveFourBarEncoderReset());
		manipController.X.whileHeld(new MoveFourBarToSetpointHalf());
		manipController.Y.whileHeld(new MoveFourBarToSetpointFull());
		manipController.LB.whileHeld(new IntakeWheelsForward());
		M_RB.whenPressed(new ShooterWheelsForward());
		M_RB.whenReleased(new ShooterWheelsForwardRelease());
		manipController.BACK.whenPressed(new AutoPop());
		manipController.START.whileHeld(new ShooterWheelsBackward());
		manipController.LS.whenReleased(new WinchServoToggle());
	}

}
