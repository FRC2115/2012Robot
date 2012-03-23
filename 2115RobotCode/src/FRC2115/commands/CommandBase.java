package FRC2115.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import FRC2115.OI;
import FRC2115.subsystems.BridgeArm;
import FRC2115.subsystems.Chassis;
import FRC2115.subsystems.Plunger;
import FRC2115.subsystems.Roller;
import FRC2115.subsystems.Shooter;
import FRC2115.subsystems.Camera;
import FRC2115.RobotMap;

public abstract class CommandBase extends Command
{
    //Create a single static instance of all of your subsystems
    public static OI oi;
    public static Chassis chassis  = new Chassis();
    public static Plunger plunger = new Plunger();
    public static Shooter shooter = new Shooter();
    public static BridgeArm arm = new BridgeArm();
    public static Roller roller = new Roller();
    public static Camera camera = new Camera();
    
    //Simpler to instantiate here rather than making a subsystem
    public static Compressor compressor = new Compressor(
            RobotMap.pressureSwitchChannel,
            RobotMap.compressorRelayChannel);

    public static void init()
    {
        // This MUST be here. If the OI creates Commands (which it very likely
        // will), constructing it during the construction of CommandBase (from
        // which commands extend), subsystems are not guaranteed to be
        // yet. Thus, their requires() statements may grab null pointers. Bad
        // news. Don't move it.
        oi = new OI();
        
        //Start our compressor (permanently)
        compressor.start();
        
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
