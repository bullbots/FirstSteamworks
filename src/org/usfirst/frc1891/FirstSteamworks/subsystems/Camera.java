// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc1891.FirstSteamworks.subsystems;

import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;
import org.usfirst.frc1891.FirstSteamworks.GripPipeline;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.VisionThread;


/**
 *
 */
public class Camera extends Subsystem {

	
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS
	private static final int IMG_WIDTH = 320;
	private static final int IMG_HEIGHT = 240;
	
	private VisionThread visionThread;
	private double centerX = 0.0;
	
	private final Object imgLock = new Object();
	private double area;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS


    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }
    
    /**
     * 
     */
    public Camera()
    {
    	UsbCamera camera = CameraServer.getInstance().startAutomaticCapture(0);
    	camera.setResolution(IMG_WIDTH, IMG_HEIGHT);
    	@SuppressWarnings("unused")
		UsbCamera backwardCamera = CameraServer.getInstance().startAutomaticCapture(1);
    	GripPipeline pipe = new GripPipeline();
    	
    	visionThread = new VisionThread(camera, pipe, pipeline -> {
//    		System.out.println("Looking ...."+pipeline.filterContoursOutput().size());
            if (pipeline.filterContoursOutput().size() == 2) {
                SmartDashboard.putBoolean("Target Sighted", true);
                Rect target1 = Imgproc.boundingRect(pipeline.filterContoursOutput().get(0));
                Rect target2 = Imgproc.boundingRect(pipeline.filterContoursOutput().get(1));
                synchronized (imgLock) {
                	centerX = ((target1.x + (target1.width / 2)) + (target2.x + (target2.width / 2)))/2 - 160;
                	area = 2400 - ((target1.area() + target2.area())/2);
                }
//                System.out.println(area);
//                System.out.println("error: " + centerX);
            }
            else {
                SmartDashboard.putBoolean("Target Sighted", false);
            }
        });
        visionThread.start();
//    	new Thread(() -> {
//            UsbCamera camera = CameraServer.getInstance().startAutomaticCapture();
//            camera.setResolution(640, 480);
//            
//            CvSink cvSink = CameraServer.getInstance().getVideo();
//            CvSource outputStream = CameraServer.getInstance().putVideo("Blur", 640, 480);
//            
//            Mat source = new Mat();
//            Mat output = new Mat();
//            
//            while(true) {
//                cvSink.grabFrame(source);
//                Imgproc.cvtColor(source, output, Imgproc.COLOR_BGR2GRAY);
//                outputStream.putFrame(output);
//            }
//        }).start();
    }
    
    /**
     * @return
     * @throws NoTargetFoundException
     */
    private double getPegTargetPositionError()
    {
//    	NetworkTable target = NetworkTable.getTable("GRIP/myContoursReport");
//    	@SuppressWarnings("deprecation")
//		double[] targets = target.getNumberArray("centerX");
////    	SmartDashboard.putNumber("targets", targets.length);
////    	if(targets.length == 2)
////    	{
//    		double error = ((targets[0] + targets[1])/2)-320;
    		double centerX;
    		synchronized (imgLock) {
            	centerX = this.centerX;
            }
    		return centerX;//centerX;
//    	}
//    	else
//    	{
//    		throw new NoTargetFoundException();
//    	}
    }
    
    private double getPegTargetDistanceAreaError()
    {
    	double area;
		synchronized (imgLock) {
        	area = this.area;
        }
		return area;
    }

	/**
	 * @return
	 */
	public double getErrorX()
	{
		return getPegTargetPositionError();
	}
	
	/**
	 * @return
	 */
	public double getErrorY()
	{
		return getPegTargetDistanceAreaError();
	}
}

