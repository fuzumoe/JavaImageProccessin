#Java Digital Image Processing 
  Java BufferedImage class is a subclass of Image class. It is used to handle and manipulate 
  the image data. A BufferedImage is made of ColorModel of image data. All BufferedImage objects 
  have an upper left corner coordinate of (0, 0).
     Raster:: a rectangular pattern of parallel scanning lines followed by the electron beam on a television screen or computer monitor.
#Constructors
 This class supports three types of constructors.
 #1:: The first constructor constructs a new BufferedImage with a specified ColorModel and Raster.
       BufferedImage(ColorModel cm, WritableRaster raster, 
       boolean isRasterPremultiplied, Hashtable<?,?> properties)
 #2::The second constructor constructs a BufferedImage of one of the predefined image types.
      BufferedImage(int width, int height, int imageType)
 #3:: BufferedImage(int width, int height, int imageType)
      The third constructor constructs a BufferedImage of one of the predefined image types: TYPE_BYTE_BINARY or TYPE_BYTE_INDEXED.
      BufferedImage(int width, int height, int imageType, IndexColorModel cm)

 #Image Pixels
    An image contains a two dimensional array of pixels. It is actually the value of those pixels that make up an image. Usually an image could be color or grayscale.
	In Java, the BufferedImage class is used to handle images. You need to call getRGB() method of the BufferedImage class to get the value of the pixel.
	The pixel value can be received using the following syntax:

       Color c = new Color(image.getRGB(j, i));
 #GrayScale Conversion
    In order to convert a color image to Grayscale image, you need to read pixels or data of the image using File and ImageIO objects, and store the image in BufferedImage object. Its syntax is given below:
      File input = new File("digital_image_processing.jpg");
      BufferedImage image = ImageIO.read(input);	
      Color c = new Color(image.getRGB(j, i));
      int red = (c.getRed() * 0.299);
      int green =(c.getGreen() * 0.587);
      int blue = (c.getBlue() *0.114);