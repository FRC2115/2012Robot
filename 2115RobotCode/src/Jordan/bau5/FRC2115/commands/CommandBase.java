package Jordan.bau5.FRC2115.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import Jordan.bau5.FRC2115.OI;
import Jordan.bau5.FRC2115.subsystems.BridgeArm;
import Jordan.bau5.FRC2115.subsystems.Chassis;
import Jordan.bau5.FRC2115.subsystems.Plunger;
import Jordan.bau5.FRC2115.subsystems.Roller;
import Jordan.bau5.FRC2115.subsystems.Shooter;
import Jordan.bau5.FRC2115.subsystems.Camera;

public abstract class CommandBase extends Command
{
    // Create a single static instance of all of your subsystems
    public static OI oi;
    public static Chassis chassis  = new Chassis();
    public static Plunger plunger = new Plunger();
    public static Shooter shooter = new Shooter();
    public static BridgeArm arm = new BridgeArm();
    public static Roller roller = new Roller();
    public static Camera camera = new Camera();

    public static void init()
    {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
        
        //Might be nice to see data on the SmartDashboard if we ever use it
        SmartDashboard.putData(chassis);
    }

    public CommandBase(String name)
    {
        super(name);
    }

    public CommandBase()
    {
        super();
    }
}
