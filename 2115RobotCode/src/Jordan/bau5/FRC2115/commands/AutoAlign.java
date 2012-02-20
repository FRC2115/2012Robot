package Jordan.bau5.FRC2115.commands;

import Jordan.bau5.FRC2115.commands.CommandBase;

public class AutoAlign extends CommandBase
{
    private boolean finished = false;
    
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
        
        if(processResult == -1)
	    chassis.drive.tankDrive(-.5, .5);
	else if(processResult == 1)
	    chassis.drive.tankDrive(.5, -.5);
        else
            finished = true; //met the threshold
    }

    protected boolean isFinished()
    {
        return finished;
    }

    protected void end()
    {
    }

    protected void interrupted()
    {
    }
}
