package FRC2115.commands;

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
        else if(processResult == 0)
            finished = true; //met the threshold
        else
        {
            throw new IllegalStateException("The processImage method has returned: "+processResult);
        }
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
