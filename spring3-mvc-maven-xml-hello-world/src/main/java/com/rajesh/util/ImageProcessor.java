package com.rajesh.util;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class ImageProcessor {

	public static BufferedImage toBufferedImage(String fileName) throws Exception {
		
		Image img = ImageIO.read(new File(fileName));
	    if (img instanceof BufferedImage){
	        return (BufferedImage) img;
	    }
	    // Create a buffered image with transparency
	    BufferedImage bimage = new BufferedImage(img.getWidth(null), img.getHeight(null), BufferedImage.TYPE_INT_ARGB);
	    // Draw the image on to the buffered image
	    Graphics2D bGr = bimage.createGraphics();
	    bGr.drawImage(img, 0, 0, null);
	    bGr.dispose();
	    // Return the buffered image
	    return bimage;
	}
	
	public static File createImageFromBufferedImage(BufferedImage bufferedImage, String imageFilePath) throws Exception {
		
		File outputfile = new File(imageFilePath);
		ImageIO.write(bufferedImage, "jpg", outputfile);
		return outputfile;
	}
	
	public static boolean scaleImage(String inputPath, String outputPath, int percentage){
		
		boolean flag = false;
		try {
			ImageIcon ii = new ImageIcon(inputPath);
			
			int height = ii.getIconHeight();
			int width = ii.getIconWidth();
			
			int newHeight = (int) Math.getPercentagedValue(height, percentage);
			int newWidth = (int) Math.getPercentagedValue(width, percentage);
			
	        BufferedImage bi = new BufferedImage(newWidth, newHeight, BufferedImage.TYPE_INT_RGB);
	        Graphics2D g2d = (Graphics2D)bi.createGraphics();
	        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING,
	                RenderingHints.VALUE_RENDER_QUALITY));
	        flag = g2d.drawImage(ii.getImage(), 0, 0, newWidth, newHeight, null);
	        ImageIO.write(bi, "jpg", new File(outputPath));
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	/*
	public static void main(String[] args) throws Exception {
		
		String inputPath = "C:/code/ab.jpg";
		String outputPath = "C:/code/ab1.jpg";
		BufferedImage bImage = toBufferedImage(inputPath);
		createImageFromBufferedImage(bImage, outputPath);
		scaleImage(inputPath, outputPath, 50);
	}
	*/
}
