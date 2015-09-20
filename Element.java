/**
 * @(#)Element.java
 *
 *
 * @author Taylor Shin and Derick Han
 * @version 1.00 2013/5/9
 */
import java.awt.image.BufferedImage;
import java.awt.Rectangle;
import java.awt.Color;
import java.awt.Graphics2D;
// the same as Actor
public class Element extends Rectangle{
	Color col;
	int dy, dx;
	int imgArrayCount = 0;
	int frameDelay = 50,frameCount = 0;
    public Element(int x, int y, int w, int h, Color acol) {
    	super(x, y, w, h);
    	col = acol;
    }
    public void setDx(int deex) {
    	dx = deex;
    }
    public void setDy(int deey) {
    	dy = deey;
    }
    public int getDx() {
    	return dx;
    }
    public int getDy() {
    	return dy;
    }
    public void move() {
    	translate(dx, dy);
    }

    public void drawRec(Graphics2D win, BufferedImage img){
    	if(img==null){
   			win.setColor(col);
    		win.fill(this);
    	}else{
    		win.drawImage(img,(int)getX(),(int)getY(),null);
    	}
    
    }
	public void imageArrayMethod(Graphics2D win, BufferedImage[] array){

		win.drawImage(array[imgArrayCount] ,(int)getX(),(int)getY(),null);
		frameCount++;
		if(frameCount > frameDelay){
			frameCount = 0;
			if(imgArrayCount >= array.length - 1){
				imgArrayCount = 0;
			}else{
				imgArrayCount++;
			}
		}
	}


	


}