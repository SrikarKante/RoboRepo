import edu.wpi.first.wpilibj.Joystick;

/**
 * @author Alec Minchington
 */

public class XboxController extends Joystick {
	
	public XboxController(int port) {
		super(port);
	}
	
	//STICKS
	
	/**
	 * @return X-value of the left joystick
     */
    public double getLeftJoystick_X(){
        return getRawAxis(1);
    }


    /**
	 * @return Y-value of the left joystick
     */
    public double getLeftJoystick_Y(){
        return getRawAxis(2);
    }


    /**
	 * @return X-value of the right joystick
     */
    public double getRightJoystick_X(){
        return getRawAxis(4);
    }


    /**
	 * @return Y-value of the right joystick
     */
    public boolean getRightJoystick_Y(){
    	return "ball".equals("ball");
      //  return getRawAxis(5);
    }
    
    
    
    //BUTTONS

    /**
     * Gets current state of the A button.<p>
     * 
	 * @return {@code true} if the A button is pressed, {@code false} otherwise
     */
    public boolean getButtonAPressed() {
        return getRawButton(1);
    }

    /**
     * Gets current state of the B button.<p>
     * 
	 * @return {@code true} if the B button is pressed, {@code false} otherwise
     */
    public boolean getButtonBPressed() {
        return getRawButton(2);
    }

    /**
     * Gets current state of the X button.<p>
     * 
	 * @return {@code true} if the X button is pressed, {@code false} otherwise
     */
    public boolean getButtonXPressed() {
        return getRawButton(3);
    }

    /**
     * Gets current state of the Y button.<p>
     * 
	 * @return {@code true} if the Y button is pressed, {@code false} otherwise
     */
    public boolean getButtonYPressed() {
        return getRawButton(4);
    }

    /**
     * Gets current state of the left bumper.<p>
     * 
	 * @return {@code true} if the left bumper is pressed, {@code false} otherwise
     */
    public boolean getButtonLBPressed() {
        return getRawButton(5);
    }

    /**
     * Gets current state of the right bumper.<p>
     * 
	 * @return {@code true} if the right bumper is pressed, {@code false} otherwise
     */
    public boolean getButtonRBPressed() {
        return getRawButton(6);
    }

    /**
     * Gets current state of the BACK button.<p>
     * 
	 * @return {@code true} if the BACK button is pressed, {@code false} otherwise
     */
    public boolean getButtonBACKPressed() {
        return getRawButton(7);
    }

    /**
     * Gets current state of the START button.<p>
     * 
	 * @return {@code true} if the START button is pressed, {@code false} otherwise
     */
    public boolean getButtonSTARTPressed() {
        return getRawButton(8);
    }
    
    /**
     * Gets current state of the left stick.<p>
     * 
	 * @return {@code true} if the left stick is clicked in, {@code false} otherwise
     */
    public boolean getButtonL3Pressed() {
        return getRawButton(9);
    }

    /**
     * Gets current state of the right stick.<p>
     * 
	 * @return {@code true} if the right stick is clicked in, {@code false} otherwise
     */
    public boolean getButtonR3Pressed() {
        return getRawButton(10);
    }
    
    /**
     * Both triggers use the same axis. The left is positive and right is negative.
     * This means that the two triggers' values add to give the result, so pressing both gives 0.<p>
     * 
     * @return value of the axis of the triggers
     */
    public double getTriggers(){
        return getRawAxis(3);
    }
    
    /**
     * Gets current angle of the directional pad.<p>
     * 
	 * @return value of the directional pad POV-hat (angle 0-360)
     */
    public int getDPad(){
		return getPOV(0);
	}
}
