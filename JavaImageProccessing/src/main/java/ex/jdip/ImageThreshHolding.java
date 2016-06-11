package ex.jdip;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;

/**
 * Thresholding enables to achieve image segmentation in the easiest way. Image
 * segmentation means dividing the complete image into a set of pixels in such a
 * way that the pixels in each set have some common characteristics. Image
 * segmentation is highly useful in defining objects and their boundaries.
 * 
 * @author Adam
 *
 */
public class ImageThreshHolding {
	public static void main(String[] args) {

		try {

			System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
			Mat source = Imgcodecs.imread("digital_image_processing.jpg", Imgcodecs.CV_LOAD_IMAGE_COLOR);
			Mat destination = new Mat(source.rows(), source.cols(), source.type());

			destination = source;
			Imgproc.threshold(source, destination, 127, 255, Imgproc.THRESH_TOZERO);
			Imgcodecs.imwrite("ThreshZero.jpg", destination);

		} catch (Exception e) {
			System.out.println("error: " + e.getMessage());
		}
	}
}
