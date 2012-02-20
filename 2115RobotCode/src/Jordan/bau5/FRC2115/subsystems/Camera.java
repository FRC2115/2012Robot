package Jordan.bau5.FRC2115.subsystems;

import edu.wpi.first.wpilibj.camera.AxisCamera;
import edu.wpi.first.wpilibj.camera.AxisCameraException;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.image.BinaryImage;
import edu.wpi.first.wpilibj.image.ColorImage;
import edu.wpi.first.wpilibj.image.CriteriaCollection;
import edu.wpi.first.wpilibj.image.NIVision.MeasurementType;
import edu.wpi.first.wpilibj.image.NIVisionException;
import edu.wpi.first.wpilibj.image.ParticleAnalysisReport;

public class Camera extends Subsystem
{
    //Intensity threshold values
    public static final int lowerI = 172;
    public static final int upperI = 255;
    public static final int rmSmallIters = 8;
    //Center of mass x threshold
    public static final double xThresh = .05;
    private AxisCamera camera;
    private ColorImage image;
    private CriteriaCollection cc;

    public Camera()
    {
         camera = AxisCamera.getInstance();
         cc = new CriteriaCollection();
         cc.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, 30, 400, false);
         cc.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, 40, 400, false);
    }

    public int processImage()
    {
        try
        {
            if(!camera.freshImage())
                image = camera.getImage();
            BinaryImage thresholdImage = image.thresholdHSI(0, 255, 0, 255, lowerI, upperI);
            BinaryImage convexHullImage = thresholdImage.convexHull(false);
            BinaryImage bigObjectsImage = convexHullImage.removeSmallObjects(false, 7);
            /*
             * BinaryImage bigObjectsImage = thresholdImage();
             * while(bigObjectsImage.getNumberParticles() > 4)
             *     bigObjectsImage = bigObjectsImage.removeSmallObjects(false, 1);
             *
             * I feel like this is a better way of doing the same thing as is
             * uncommented above, but I am worried that I don't see it in any
             * example code or even other teams' code.
             */

            ParticleAnalysisReport[] reports = bigObjectsImage.getOrderedParticleAnalysisReports(4);

            int maxIndex = 0;
            double maxVal = -99;
            for(int i = 0; i < reports.length; i++)
            {
                if(reports[i].center_mass_y_normalized > maxVal)
                {
                    maxIndex = i;
                    maxVal = reports[i].center_mass_y_normalized;
                }
            }

            bigObjectsImage.free();
            convexHullImage.free();
            thresholdImage.free();
            image.free();

            if(reports[maxIndex].center_mass_x_normalized < -1 * xThresh)
                return -1;
            else if(reports[maxIndex].center_mass_x_normalized > xThresh)
                return 1;
            else
                return 0;
        }
        catch(Exception e)
        {
            System.out.println("Exception caught and ignored:");
            System.out.println(e);
            
            return 0;
        }
    }

    protected void initDefaultCommand()
    {
    }
}
