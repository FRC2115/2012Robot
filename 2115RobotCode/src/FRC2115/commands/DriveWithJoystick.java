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
        
        chassis.driveWithJoystick(leftAxis, rightAxis);
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
}
