package FRC2115.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import FRC2115.RobotMap;
import FRC2115.commands.DriveWithJoystick;

public class Chassis extends Subsystem 
{
    private final double SPEED_MULTIPLIER = 0.9;
    
    public RobotDrive drive;
   
    public Chassis()
    {
        drive = new RobotDrive(RobotMap.leftDriveMotor, 
                RobotMap.rightDriveMotor);
        drive.setSafetyEnabled(false);
    }
    
    public void driveStraight(double speed)
    {
        drive.tankDrive(speed, speed);
    }
    
    //Rotates the robot in place.
    //speed >= 0; 
    public void driveRotate(double speed, boolean clockWise)
    {
        if(clockWise)
            speed *= -1;
        
        drive.tankDrive(speed, -speed);
    }
    
    public void driveWithJoystick(double leftAxis, double rightAxis)
    {
        drive.tankDrive(leftAxis * SPEED_MULTIPLIER, rightAxis * SPEED_MULTIPLIER);
    }
    
    public void initDefaultCommand() 
    {
        setDefaultCommand(new DriveWithJoystick());
    }
}
