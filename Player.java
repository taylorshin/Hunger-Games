/**
 * @(#)Player.java
 *
 *
 * @author Taylor Shin and Derick Han
 * @version 1.00 2013/5/15
 */

import java.awt.Color;
public class Player extends Element {
	int speed;
	int direction;
	boolean canMove=true;
    public Player(int x,int y,int s) {
    	super(x,y,20,20,Color.RED);
    	speed = s;
    }
    public void move(boolean[] dir,int width,int height) {
    	if(canMove){
    	
		if(dir[0]&&getY()>0) {
			setDy(-speed);
		} else if (dir[1]&&getY()<(height-75)) {
			setDy(speed);
		} else {
			setDy(0);
		}
		if(dir[2]&&getX()>0) {
			setDx(-speed);
		} else if (dir[3]&&getX()<(width-(getWidth()+23))) {
			setDx(speed);
		} else {
			setDx(0);
		}
		move();
		
		if(dir[0]){
    		direction=0; //north
    	}else if(dir[1]){
    		direction=1; //south
    	}else if(dir[2]){
    		direction=2; //east
    	}else if(dir[3]){
    		direction=3; //west
    	}
    	
    	}

    }
    public int getDirection1(){
    	
    	return direction;
    }
    
    public void setCanMove(boolean value) {
    	canMove = value;
    }
    public boolean getCanMove(){
    	return canMove;
    }
    public void setSpeed(int s){
    	speed = s;
    }
}