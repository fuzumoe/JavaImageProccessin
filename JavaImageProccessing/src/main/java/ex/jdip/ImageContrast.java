package ex.jdip;


import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;


public class ImageContrast {
	static int width;
	   static int height;
	   static double alpha = 2;
	   static double beta = 50;
	   
	   public static void main( String[] args ) {
	   
	      try {
	         System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
	         Mat source = Imgcodecs.imread("grayscale.jpg", 
	        		 Imgcodecs.CV_LOAD_IMAGE_GRAYSCALE);
	         Mat destination = new Mat(source.rows(),source.cols(),source.type());
	         Imgproc.equalizeHist(source, destination);
	         Imgcodecs.imwrite("contrast.jpg", destination);
	         
	      }catch (Exception e) {
	         System.out.println("error: " + e.getMessage());
	      }
	   }
}
