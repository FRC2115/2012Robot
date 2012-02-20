package Jordan.bau5.FRC2115.commands;

import Jordan.bau5.FRC2115.commands.CommandBase;
import edu.wpi.first.wpilibj.command.PIDCommand;

public class AutoAlign extends PIDCommand
{   
    public AutoAlign()
    {
        super("AutoAlign", 0.1, 0.1, 0.1);
        
	requires(CommandBase.camera);
	requires(CommandBase.chassis);
        
        setSetpoint(0.0);
    }
    
    protected double returnPIDInput()
    {
        return CommandBase.camera.findOffsetFromX();
    }

    protected void usePIDOutput(double output)
    {
        CommandBase.chassis.drive.tankDrive(output, -output);
    }

    public void initialize()
    {
    }

    public void execute()
    {
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
