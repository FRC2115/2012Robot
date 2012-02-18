public class Camera
{
    private AxisCamera camera;
    private ColorImage image;
    private CriteriaCollection cc;

    public Camera()
    {
         camera = new Axis Camera();
         cc = new CriteriaCollection();
         cc.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, 30, 400, false);
         cc.addCriteria(MeasurementType.IMAQ_MT_BOUNDING_RECT_WIDTH, 40, 400, false);
    }

    public void processImage()
    {
        if(!camera.freshImage())
            image = camera.getImage();
        BinaryImage thresholdImage = image.thresholdHSL(0, 255, 0, 255, 165, 255);
        BinaryImage bigObjectsImage = thresholdImage.removeSmallObjects(false, 2);
        BinaryImage convexHullImage = bigObjectsImage.convexHull(false);
        BinaryImage filteredImage = convexHullImage.particleFilter(cc);

        ParticleAnalysisReport[] reports = filteredImage.getOrderedParticleAnalysisReports(4);

	int maxIndex = 0;
	double maxVal = -99;
	for(int i = 0; i < reports.length; i++)
	{
	    if(reports[i].center_mass_y_normalized() > maxVal)
	    {
		maxIndex = i;
		maxVal = reports[i].center_mass_y_normalized();
	    }
	}

	if(reports[maxIndex].center_mass_x_normalized() > .05)
	    //Tell drive to turn left at 1/2 speed
	else if(reports[maxIndex].center_mass_x_normalized() < .05)
	    //Tell drive to turn right at 1/2 speed
	else
	    //Allow driving forwards & backwards w/ 1 joystick

        filteredImage.free();
	convexHullImage.free();
	bigObjectsImage.free();
	thresholdImage.free();
	image.free();
    }
}
