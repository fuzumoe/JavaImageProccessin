package ex.jdip;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.Size;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * Image pyramid is nothing but a method to display a multi-resolution image.
 * The lowermost layer is a highest-resolution version of image and the topmost
 * layer is a lowest-resolution version of the image. Image pyramids are used to
 * handle image at different scales.
 * 
 * In this chapter we perform some down sampling and up sampling on images.
 * 
 * We use OpenCV functions pyrUp and pyrDo
 * 
 * @author Adam
 *
 */

public class ImagePyramids {
	public static void main( String[] args ) {
		   
	      try{
	      
	         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	         Mat source = Imgcodecs.imread("digital_image_processing.jpg",
	        		 Imgcodecs.CV_LOAD_IMAGE_COLOR);
	         
	         Mat destination1 = new Mat(source.rows()*2, source.cols()*2,source.type());
	         destination1 = source;
	         
	         Imgproc.pyrUp(source, destination1, new  Size(source.cols()*2 ,source.rows()*2));
	         Imgcodecs.imwrite("pyrUp.jpg", destination1);
	         
	         source = Imgcodecs.imread("digital_image_processing.jpg", 
	        		 Imgcodecs.CV_LOAD_IMAGE_COLOR);
	         
	         Mat destination = new Mat(source.rows()/2,source.cols()/2, source.type());
	         destination = source;
	         Imgproc.pyrDown(source, destination, new Size(source.cols()/2,  source.rows()/2));
	         Imgcodecs.imwrite("pyrDown.jpg", destination);
	         
	      }catch (Exception e){ 
	         System.out.println("error: " + e.getMessage());
	      }
	   }
}
