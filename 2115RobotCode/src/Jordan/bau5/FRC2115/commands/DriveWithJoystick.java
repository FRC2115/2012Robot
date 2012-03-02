package Jordan.bau5.FRC2115.commands;

public class DriveWithJoystick extends CommandBase
{
    public DriveWithJoystick() 
    {
        requires(chassis);
    }

    protected void initialize() 
    {
        //Stopping Motor output to ensure correct input on Joysticks
        chassis.drive.setLeftRightMotorOutputs(0, 0);
    }

    protected void execute() 
    {
        double leftAxis = oi.jLeftWheel.getRawAxis(oi.leftAxis);
        double rightAxis = oi.jRightWheel.getRawAxis(oi.rightAxis);
        
        chassis.driveWithJoystick(jMod(leftAxis), jMod(rightAxis));
    }

    protected boolean isFinished()
    {
        return false;
    }

    protected void end()
    {
    }

    protected void interrupted()
    {
    }
    
    public static double jMod(double jVal)
    {
        boolean isNeg = false;
	if(jVal < 0)
	{
	    isNeg = true;
	    jVal *= -1;
	}

	double modVal = (Math.atan(Math.PI*(jVal - .5))/2.009 + .5);
	if(isNeg) { return modVal*-1; }
	else      { return modVal;    }
    }
}
