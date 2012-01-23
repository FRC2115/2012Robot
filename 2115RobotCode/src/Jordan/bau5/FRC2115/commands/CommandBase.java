package Jordan.bau5.FRC2115.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import Jordan.bau5.FRC2115.OI;
import Jordan.bau5.FRC2115.subsystems.Chassis;
import Jordan.bau5.FRC2115.subsystems.ExampleSubsystem;
import Jordan.bau5.FRC2115.subsystems.Shooter;
import Jordan.bau5.FRC2115.subsystems.ShooterTable;

/**
 * The base for all commands. All atomic commands should subclass CommandBase.
 * CommandBase stores creates and stores each control system. To access a
 * subsystem elsewhere in your code in your code use CommandBase.exampleSubsystem
 * @author Author
 */
public abstract class CommandBase extends Command {

    public static OI oi;
    public Chassis chassis  = new Chassis();
    public Shooter shooter = new Shooter(1,2);
    public ShooterTable shooterTable = new ShooterTable();
    public PositionForShooting positionForShooting = new PositionForShooting();
    // Create a single static instance of all of your subsystems
    public static ExampleSubsystem exampleSubsystem = new ExampleSubsystem();

    public static void init() {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
        

        // Show what command your subsystem is running on the SmartDashboard
        SmartDashboard.putData(exampleSubsystem);
    }

    public CommandBase(String name) {
        super(name);
    }

    public CommandBase() {
        super();
    }
}
