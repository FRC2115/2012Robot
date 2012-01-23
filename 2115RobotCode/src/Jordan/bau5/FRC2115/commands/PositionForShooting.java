/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jordan.bau5.FRC2115.commands;

/**
 *
 * @author Jordan
 */
public class PositionForShooting extends CommandBase {
    
    private double m_timeout;
    
    public PositionForShooting()
    {
        
    }
    public PositionForShooting(double timeout) 
    {
        m_timeout = timeout;
        requires(shooterTable);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        /*Vision target targeting. When targeted, use Leibo's formulas to
         calculate the distance and speed needed to get to the hoop*/
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
