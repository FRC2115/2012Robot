package Jordan.bau5.FRC2115.commands;

import Jordan.bau5.FRC2115.commands.CommandBase;

public class AutoAlign extends CommandBase
{
    public AutoAlign()
    {
	requires(camera);
	requires(chassis);
    }

    public void initialize()
    {
    }

    public void execute()
    {
        int processResult = camera.processImage();
        
        if (processResult == 0)
            chassis.driveWithJoystick(oi.jLeftWheel, oi.leftAxis,
                    oi.jLeftWheel, oi.leftAxis);
        else if(processResult == -1)
	    chassis.drive.tankDrive(.5, -.5);
	else if(processResult == 1)
	    chassis.drive.tankDrive(-.5, .5);
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
