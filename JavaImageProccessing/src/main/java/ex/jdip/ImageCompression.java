package ex.jdip;

import java.io.*;
import java.util.*;
import java.awt.image.*;

import javax.imageio.*;
import javax.imageio.stream.ImageOutputStream;

/**
 * An image can easily be compressed and stored through Java. Compression of
 * image involves converting an image into jpg and storing it.
 * 
 * In order to compress an image, we read the image and convert into
 * BufferedImage object.
 * 
 * Further, we get an ImageWriter from getImageWritersByFormatName() method
 * found in the ImageIO class. From this ImageWriter, create an ImageWriteParam
 * object. Its syntax is given below:
 * 
 * @author Adam
 *
 */
public class ImageCompression {

	public static void main(String[] args) throws IOException {

		File input = new File("digital_image_processing.jpg");
		BufferedImage image = ImageIO.read(input);

		File compressedImageFile = new File("compress.jpg");
		OutputStream os = new FileOutputStream(compressedImageFile);

		Iterator<ImageWriter> writers = ImageIO.getImageWritersByFormatName("jpg");
		ImageWriter writer = (ImageWriter) writers.next();

		ImageOutputStream ios = ImageIO.createImageOutputStream(os);
		writer.setOutput(ios);

		ImageWriteParam param = writer.getDefaultWriteParam();

		param.setCompressionMode(ImageWriteParam.MODE_EXPLICIT);
		param.setCompressionQuality(0.05f);
		writer.write(null, new IIOImage(image, null, null), param);

		os.close();
		ios.close();
		writer.dispose();
	}

}
