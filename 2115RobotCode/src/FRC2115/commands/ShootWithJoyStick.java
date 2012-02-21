package FRC2115.commands;

public class ShootWithJoyStick extends CommandBase {
    
    public ShootWithJoyStick() 
    {
        requires(shooter);
    }

    protected void initialize()
    {
    }

    protected void execute() 
    {
        shooter.spinWithJoystick(oi.jShootSetter, oi.shootSetAxis);
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
