/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.wpi.first.wpilibj.templates.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.templates.commands.CommandBase;
import edu.wpi.first.wpilibj.templates.commands.DriveWithJoystick;

/**
 *
 * @author Jordan
 */
public class Chassis extends Subsystem 
{
    RobotDrive drive;
    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() 
    {
        setDefaultCommand(new DriveWithJoystick());
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public Chassis()
    {
        drive = new RobotDrive(2, 1);
        drive.setSafetyEnabled(false);
    }
    
    public void straight() 
    {
        // sets the motor speeds to drive straight (no turn)
        drive.arcadeDrive(1.0, 0.0);
    }
    public void turnLeft() 
    {
        // sets the motor speeds to start a left turn
        drive.arcadeDrive(0.0, 1.0);
    }
    public void driveWithJoystick(Joystick stick) 
    {
        drive.arcadeDrive(stick);
    }
}
