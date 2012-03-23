package FRC2115.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import FRC2115.RobotMap;
import FRC2115.commands.DriveWithJoystick;

public class Chassis extends Subsystem 
{
    public RobotDrive drive;
   
    public Chassis()
    {
        drive = new RobotDrive(RobotMap.leftDriveMotor, 
                RobotMap.rightDriveMotor);
        drive.setSafetyEnabled(false);
    }
    
    public void Straight()
    {
        drive.tankDrive(.5, .5);
    }
    
    public void Right()
    {
        drive.tankDrive(.5, -.5);
    }
    
    public void Left()
    {
        drive.tankDrive(-.5, .5);
    }
    
    public void driveWithJoystick(double leftAxis, double rightAxis)
    {
        drive.tankDrive(leftAxis, rightAxis);
    }
    
    public void initDefaultCommand() 
    {
        setDefaultCommand(new DriveWithJoystick());
    }
}
