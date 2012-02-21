package FRC2115.commands;

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
	double modVal = (-.5*Math.cos(Math.PI*jVal) + .5);
        
	if(jVal < 0)
            //modVal is always positive; make it negative if axis was negative
            modVal *= -1;
        
        return modVal;
    }
}
