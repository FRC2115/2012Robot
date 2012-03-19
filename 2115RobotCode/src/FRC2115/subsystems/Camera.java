package FRC2115.subsystems;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVision.MeasurementType;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;

public class Camera extends Subsystem
{
    //Red threshold values
    public static final int lowerR = 232, upperR = 255, iters1 = 2, iters2 = 6;
    //Min and max ratio of width to height of equivalent rectangle
    public static final float minRatio = (float) 1.0, maxRatio = (float) 1.35;
    //Center of mass x threshold
    public static final double xThresh = .1;
    private int processed = 0;
    private AxisCamera camera;
    private ColorImage image;
    private CriteriaCollection ratioc;

    public Camera()
    {
         camera = AxisCamera.getInstance();
         ratioc = new CriteriaCollection();
         ratioc.addCriteria(MeasurementType.IMAQ_MT_RATIO_OF_EQUIVALENT_RECT_SIDES, minRatio, maxRatio, false);
    }

    public int processImage()
    {
        if(camera.freshImage())
        {
            try
            {
                image = camera.getImage();
                BinaryImage im1 = image.thresholdRGB(lowerR, upperR, 0, 255, 0, 255);
                BinaryImage im2 = im1.removeSmallObjects(true, iters1);
                BinaryImage im3 = im2.convexHull(true);
                BinaryImage im4 = im3.particleFilter(ratioc);
                BinaryImage im5 = im4.removeSmallObjects(true, iters2);
                /*
                 * BinaryImage bigObjectsImage = thresholdImage();
                 * while(bigObjectsImage.getNumberParticles() > 4)
                 *     bigObjectsImage = bigObjectsImage.removeSmallObjects(false, 1);
                 *
                 * I feel like this is a better way of doing the same thing as is
                 * uncommented above, but I am worried that I don't see it in any
                 * example code or even other teams' code.
                 */

                ParticleAnalysisReport[] reports = im5.getOrderedParticleAnalysisReports(4);

                int maxIndex = 0;
                double maxVal = 1.0;
                for(int i = 0; i < reports.length; i++)
                {
                    if(reports[i].center_mass_y_normalized < maxVal)
                    {
                        maxIndex = i;
                        maxVal = reports[i].center_mass_y_normalized;
                    }
                }
                
                if(reports.length > 0)
                {
                    System.out.println("X: " + reports[maxIndex].center_mass_x_normalized +
                            "Y: " + reports[maxIndex].center_mass_y_normalized);
                    if(reports[maxIndex].center_mass_x_normalized < -1 * xThresh)
                        processed = -1;
                    else if(reports[maxIndex].center_mass_x_normalized > xThresh)
                        processed = 1;
                    else
                        processed = 0;
                }
                else
                {
                    System.out.println("No target found.");
                    processed = 0;

                }
                
                im5.free();
                im4.free();
                im3.free();
                im2.free();
                im1.free();
                image.free();

                return processed;
            }
            catch(Exception e)
            {
                System.out.println("Exception caught and ignored:");
                System.out.println(e);

                return 0;
            }
        }
        return processed;
    }

    protected void initDefaultCommand()
    {
    }
}
