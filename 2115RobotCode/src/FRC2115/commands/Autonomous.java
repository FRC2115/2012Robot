package FRC2115.commands;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitCommand;

public class Autonomous extends CommandGroup
{
    private final double TIME_TO_REV = 3.0;
    private final double TIME_WHILE_SHOOTING = 4.0;
    
    public Autonomous()
    {
        //Align and rev up shooter
        addSequential(new AutoAlign());
        addSequential(new AutoShooterSpeed(), TIME_TO_REV);
        
        //Run shooter while deploying plunger
        addParallel(new AutoShooterSpeed(), TIME_WHILE_SHOOTING);
        addSequential(new DeployPlunger(0.5));
        addSequential(new WaitCommand(0.5)); //Wait for plunger to come back down
        addSequential(new DeployPlunger(0.5));
        
        //That's all folks!
    }
}
