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
	if(camera.processImage() == 0)
	    chassis.drive.tankDrive(oi.j1, oi.j1);
	else if(camera.processImage() == -1)
	    chassis.drive.tankDrive(.5, -.5);
	else if(camera.processImage() == 1)
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
