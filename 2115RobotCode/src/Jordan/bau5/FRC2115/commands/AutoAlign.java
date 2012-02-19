public class AutoAlgin
{
    public AutoAlign()
    {
	requires(Camera);
	requires(Chassis);
    }

    public void initialize()
    {
    }

    public void execute()
    {
	if(Camera.processImage() == 0)
	    drive.tankDrive(j1, j1);
	else if(Camera.processImage() == -1)
	    drive.tankDrive(.5, -.5);
	else if(Camera.processImage() == 1)
	    drive.tankDrive(-.5, .5);
    }
}
