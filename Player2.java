/**
 * @(#)Player2.java
 *
 *
 * @author Taylor Shin and Derick Han
 * @version 1.00 2013/5/17
 */
import java.awt.Color;
public class Player2 extends Element {
	int speed;
	int direction;
	boolean canMove = true;
    public Player2(int x,int y) {
    	super(x,y,20,20,Color.RED);
    	speed = 2;
    }
    public void move(boolean[] dir,int width,int height) {
    	if (canMove){
   
		if(dir[17]&&getY()>0) {
			setDy(-speed);
		} else if (dir[18]&&getY()<(height-75)) {
			setDy(speed);
		} else {
			setDy(0);
		}
		if(dir[19]&&getX()>0) {
			setDx(-speed);
		} else if (dir[20]&&getX()<(width-(getWidth()+23))) {
			setDx(speed);
		} else {
			setDx(0);
		}
		move();
		
		if(dir[17]){
    		direction=0; //north
    	}else if(dir[18]){
    		direction=1; //south
    	}else if(dir[19]){
    		direction=2; //east
    	}else if(dir[20]){
    		direction=3; //west
    	}
		
    	}

    }
    public int getDirection2(){
    	
    	return direction;
    }
    public void setCanMove(boolean value) {
    	canMove = value;
    }
    public boolean getCanMove(){
    	return canMove;
    }
    
    
}