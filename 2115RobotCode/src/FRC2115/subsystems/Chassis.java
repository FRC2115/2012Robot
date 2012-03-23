package FRC2115.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import FRC2115.RobotMap;
import FRC2115.commands.CommandBase;
import FRC2115.commands.DriveWithJoystick;
import edu.wpi.first.wpilibj.Dashboard;

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
    
    public void driveWithJoystick(double leftAxis, double rightAxis)
    {
        CommandBase.d.addString("Left Axis: " + leftAxis * SPEED_MULTIPLIER +
                "\nRight Axis: "+ rightAxis * SPEED_MULTIPLIER);
        drive.tankDrive(leftAxis * SPEED_MULTIPLIER, rightAxis * SPEED_MULTIPLIER);
    }
    
    public void initDefaultCommand() 
    {
        setDefaultCommand(new DriveWithJoystick());
    }
}
