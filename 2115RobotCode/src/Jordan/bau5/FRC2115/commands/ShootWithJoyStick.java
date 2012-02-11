/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Jordan.bau5.FRC2115.commands;

import Jordan.bau5.FRC2115.OI;

/**
 *
 * @author Jordan
 */
public class ShootWithJoyStick extends CommandBase {
    
    public ShootWithJoyStick() 
    {
        requires(shooter);
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
        shooter.spinWithJoystick(OI.j1);
       
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
