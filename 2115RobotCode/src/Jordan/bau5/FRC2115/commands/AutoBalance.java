package Jordan.bau5.FRC2115.commands;

import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDCommand;

//Automatically balances the robot on the bridge
public class AutoBalance extends PIDCommand
{
    private RobotDrive m_drive = CommandBase.chassis.drive;
    private Gyro m_gyro = CommandBase.tiltGyro;
    
    public AutoBalance()
    {
        //TODO: These pid parameters need tuning
        super("AutoBalance", 0.1, 0.1, 0.1);
        
        requires(CommandBase.chassis);
    }
    
    protected double returnPIDInput()
    {
        double gyroOutput = m_gyro.getAngle();
        //Finds distance from gyro input to the closest multiple of 360.
        //I figured it out somehow, but I have no idea why it works.
        double distanceFromZero =
                -((gyroOutput % 360) - 2 * (gyroOutput % 180));
        //range: -180.0 <= distanceFromZero <= 180
        
        //Scale gyro input to be the same range as motor output
        return distanceFromZero / 180;
    }
    
    protected void usePIDOutput(double output)
    {
        m_drive.setLeftRightMotorOutputs(output, output);
    }

    protected void initialize()
    {
        //PID Loop will try to make the gyro 0.0
        setSetpoint(0.0);
    }

    protected void execute()
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
