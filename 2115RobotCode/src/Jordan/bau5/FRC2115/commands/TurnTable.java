/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jordan.bau5.FRC2115.commands;

/**
 *
 * @author Jordan
 */
public class TurnTable extends CommandBase {
    
    private double m_Timeout;
    public TurnTable(double timeout) 
    {
        requires(shooterTable);
        m_Timeout = timeout;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() 
    {
        setTimeout(m_Timeout);
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        shooterTable.turn();
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
