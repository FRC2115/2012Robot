package Jordan.bau5.FRC2115.subsystems;

import Jordan.bau5.FRC2115.commands.DriveWithJoystick;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import Jordan.bau5.FRC2115.RobotMap;

public class Chassis extends Subsystem 
{
    public RobotDrive drive;
   
    public Chassis()
    {
        drive = new RobotDrive(RobotMap.leftMotor, RobotMap.rightMotor);
        drive.setSafetyEnabled(false);
    }
    
    public void Straight()
    {
        drive.tankDrive(1, 1);
    }
    
    public void Right()
    {
        drive.tankDrive(1, -1);
    }
    
    public void Left()
    {
        drive.tankDrive(-1, 1);
    }
    
    public void driveWithJoystick(Joystick j1, Joystick j2)
    {
        drive.tankDrive(j1, j2);
    }
    
    public void initDefaultCommand() 
    {
        setDefaultCommand(new DriveWithJoystick());
    }
}
