/**
 * @(#)Food.java
 *
 *
 * @author Taylor Shin and Derick Han
 * @version 1.00 2013/5/15
 */
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Food extends Element{
	
	BufferedImage image;
	
    public Food(int x,int y, BufferedImage img) {
		super(x,y,20,20,Color.WHITE);
		image = img;
    }
    
    public BufferedImage getImage(){
    	return image;
    }
    
    
    
}