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
        chassis.driveWithJoystick(oi.getJ1(), oi.getJ2());
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
