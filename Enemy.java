/**
 * @(#)Enemy.java
 *
 *
 * @author Taylor Shin and Derick Han
 * @version 1.00 2013/5/31
 */

import java.awt.Color;
import java.util.ArrayList;

public class Enemy extends Element{
	TimerDriverV2 time;
	Food tempfood,tempfood2;
	boolean canMove = true;
	public int direction,speed;

	

    public Enemy(int x, int y, int s) {
    	super(x,y,20,20,Color.RED);
		speed = s;
    
    }
    public void moveEnemy1(ArrayList<Food> foods){
    	if(canMove){
    		if(foods.size() != 0){
    			tempfood2 = foods.get(0);
    			for(int i = foods.size()-1; i > 0; i--){
    				if(getMagnitude(foods.get(i).getX(),foods.get(i).getY(),getX(),getY()) >= getMagnitude(foods.get(i-1).getX(),foods.get(i-1).getY(),getX(),getY()) ){
						tempfood2 = foods.get(i-1);
    				}
    			}
    
    			if(tempfood2.getX() > getX()){
    				setDx(speed);
    
    			}else if(tempfood2.getX() < getX()){
    				setDx(-speed);
    	
    			}else{
    				setDx(0);
    			}
    			if(tempfood2.getY() > getY()){
    				setDy(speed);

    			}else if(tempfood2.getY() < getY()){
    				setDy(-speed);	
    
  	  			}else{
    				setDy(0);
    			}
				move();	
    		}
   		}
    }
    
    public void moveEnemy2(ArrayList<Food> foods){
    	if(canMove){
    
    		if(foods.size() != 0){
    			tempfood = foods.get(0);
    			for(int i = 0; i < foods.size()-1; i++){
    				if(getMagnitude(foods.get(i).getX(),foods.get(i).getY(),getX(),getY()) >= getMagnitude(foods.get(i+1).getX(),foods.get(i+1).getY(),getX(),getY()) ){
						tempfood = foods.get(i+1);
    				}
    			}
    
    			if(tempfood.getX() > getX()){
    				setDx(speed);
    
    			}else if(tempfood.getX() < getX()){
    				setDx(-speed);
    	
    			}else{
    				setDx(0);
    			}
    			if(tempfood.getY() > getY()){
    				setDy(speed);

    			}else if(tempfood.getY() < getY()){
    				setDy(-speed);	
    
  	  			}else{
    				setDy(0);
    			}
				move();
    		
    	
    		}
    	}
    }

    
    public void moveCage(Player p){
    	if(canMove){
    		if(p.getX() > getX()){
    			setDx(speed);
    
    		}else if(p.getX() < getX()){
    			setDx(-speed);
    	
    		}else{
    			setDx(0);
    		}
    		if(p.getY() > getY()){
    			setDy(speed);

    		}else if(p.getY() < getY()){
    			setDy(-speed);	
    
  	  		}else{
    			setDy(0);
    		}
			move();
    	}
    }
    
    public int getDirection(){
    	if(getDy() == -speed && getDx() == 0){
    		direction = 0; //north
    	}else if(getDy() == -speed && getDx() == speed){
    		direction = 1; //northeast
    	}else if(getDx() == speed && getDy() == 0){
    		direction = 2; //east
    	}else if(getDx() == speed && getDy() == speed){
    		direction = 3; //southeast
    	}else if(getDx() == 0 && getDy() == speed){
    		direction = 4; //south
    	}else if(getDx() == -speed && getDy() == speed){
    		direction = 5; //southwest
    	}else if(getDx() == -speed && getDy() == 0){
    		direction = 6; //west
    	}else if(getDx() == -speed && getDy() == -speed){
    		direction = 7; //northwest
    	}else{
    		direction = 4;
    	}
    	return direction;
    }
    public void setCanMove(boolean value) {
    	canMove = value;
    }
    public boolean getCanMove(){
    	return canMove;
    }
    public double getMagnitude(double x1,double y1,double x2,double y2){
    	return Math.sqrt(Math.pow((x1+x2),2) + Math.pow((y1+y2),2));
    }
    public void setSpeed(int x){
    	speed = x;
    }

    
    
}