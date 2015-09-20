/**
 * @(#)GameComp.java
 *
 *
 * @author Taylor Shin and Derrick Han
 * @version 1.00 2013/5/15
 */

import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;
import java.awt.Font;

public class GameComp extends GameDriverV3 {
	Random rnd = new Random();
	Player xy;
	Player2 xyz;
	Enemy AI,AI2;
	ArrayList<Enemy> cages;
	int points1,points2,points3,points4,gameState;
	Rectangle blank;
	Rectangle HUD;
	int winWidth, winHeight;
	TimerDriverV2 MainTime,time2,time3,time4,time5,time6,time7;
	int prevTime,prevTime2;
	ArrayList<Bullet> pewpew;
	ArrayList<Bullet> pewpew2;
	ArrayList<Bullet> pewpew3;
	ArrayList<Bullet> pewpew4;
	ArrayList<Food> yummy; 
	int bullTime,bullDelay,bullTime2,bullDelay2,bullTime3,bullDelay3,bullTime4,bullDelay4;
	BufferedImage bg,bg2,bg3,bg4;
	BufferedImage bp1,bp2,bp3,bp4,blood,picP1,picP2,picC1,picC2,picCage;
	BufferedImage[] imgArray1,imgArray2,imgArray3,imgArray4,imgArray5,imgArray6,imgArray7,imgArray8,imgArrayFood;
	BufferedImage[] imgArrayAI1,imgArrayAI2,imgArrayAI3,imgArrayAI4,imgArrayAI5,imgArrayAI6,imgArrayAI7,imgArrayAI8;
	SoundDriver sd;

    public GameComp(int aw,int ah) {
    	//soundeffects
    	String[] stuff = {"ThemeSong.wav","EatingFood.wav","ThemeSong2.wav","CageSong.wav"};
    	sd = new SoundDriver(stuff);
    	
    	bg2 = addImage("hungergamesbg.png");
    	bg3 = addImage("hungergamesbg2.png");
    	bg4 = addImage("spacebg.png");
    	bg = addImage("SK_ScorchingDesert.png");
    	bp1 = addImage("bulletp1.png");
    	bp2 = addImage("bulletp2.png");
    	bp3 = addImage("bulletp3.png");
    	bp4 = addImage("bulletp5.png");
    	blood = addImage("Blood.png");
    	picP1 = addImage("PicP1.png");
    	picP2 = addImage("PicP2.png");
    	picC1 = addImage("PicC1.png");
    	picC2 = addImage("PicC2.png");
    	picCage = addImage("cage.png");
    	MainTime = new TimerDriverV2(1000,true);
    	//MainTime.start();
    	time2 = new TimerDriverV2(1000,false);
    	time3 = new TimerDriverV2(1000,false);
    	time4 = new TimerDriverV2(1000,false);
    	time5 = new TimerDriverV2(1000,false);
    	time6 = new TimerDriverV2(1000,false);
    	time7 = new TimerDriverV2(1000,false);
    	bullDelay = 100;//140
    	bullTime = bullDelay;
    	bullDelay2 = 100;
    	bullTime2 = bullDelay2;
    	bullDelay3 = 150;
    	bullTime3 = bullDelay3;
    	bullDelay4 = 200;
    	bullTime4 = bullDelay4;
    	xy = new Player(400,350,2);
    	xyz = new Player2(800,350);
    	AI = new Enemy(600,150,1);
    	AI2 = new Enemy(600,550,1);
    	points1 = 0;
    	points2 = 0;
    	points3 = 0;
   		points4 = 0;
    	gameState = 0;
    	
    	winWidth = aw;
    	winHeight = ah;
    	blank = new Rectangle(0, 0, winWidth, winHeight);
    	HUD = new Rectangle(1245,0,105,730);
    	
    	yummy = new ArrayList<Food>();
    	pewpew = new ArrayList<Bullet>();
    	pewpew2 = new ArrayList<Bullet>();
    	pewpew3 = new ArrayList<Bullet>();
    	pewpew4 = new ArrayList<Bullet>();
    	cages = new ArrayList<Enemy>();
    	//arraylist of images for Player 1
    	
		imgArray1 = new BufferedImage[4];
    	for(int i = 1;i <= 4;i++){
    		imgArray1[i-1] = addImage("Player1sprites/Player1down_" + i + ".png");
    	}
 		imgArray2 = new BufferedImage[4];
    	for(int i = 1;i <= 4;i++){
    		imgArray2[i-1] = addImage("Player1sprites/Player1up_" + i + ".png");
    	}    	
    			
		imgArray3 = new BufferedImage[4];
    	for(int i = 1;i <= 4;i++){
    		imgArray3[i-1] = addImage("Player1sprites/Player1left_" + i + ".png");
    	}    		
		imgArray4 = new BufferedImage[4];
    	for(int i = 1;i <= 4;i++){
    		imgArray4[i-1] = addImage("Player1sprites/Player1right_" + i + ".png");
    	}
    	
    	//arraylist of images for Player 2
    	
    	imgArray5 = new BufferedImage[4];
    	for(int i = 1;i <= 4;i++){
    		imgArray5[i-1] = addImage("Player2sprites/Player2down_" + i + ".png");
    	}
 		imgArray6 = new BufferedImage[4];
    	for(int i = 1;i <= 4;i++){
    		imgArray6[i-1] = addImage("Player2sprites/Player2up_" + i + ".png");
    	}    	
    			
		imgArray7 = new BufferedImage[4];
    	for(int i = 1;i <= 4;i++){
    		imgArray7[i-1] = addImage("Player2sprites/Player2left_" + i + ".png");
    	}    		
		imgArray8 = new BufferedImage[4];
    	for(int i = 1;i <= 4;i++){
    		imgArray8[i-1] = addImage("Player2sprites/Player2right_" + i + ".png");
    	}
    	
    	//arraylist of images for AI 1
    	
    	imgArrayAI1 = new BufferedImage[4];
    	for(int i = 1;i <= 4;i++){
    		imgArrayAI1[i-1] = addImage("AI1sprites/AI1down_" + i + ".png");
    	}
    	imgArrayAI2 = new BufferedImage[4];
    	for(int i = 1;i <= 4;i++){
    		imgArrayAI2[i-1] = addImage("AI1sprites/AI1up_" + i + ".png");
    	}
    	imgArrayAI3 = new BufferedImage[4];
    	for(int i = 1;i <= 4;i++){
    		imgArrayAI3[i-1] = addImage("AI1sprites/AI1left_" + i + ".png");
    	}
    	imgArrayAI4 = new BufferedImage[4];
    	for(int i = 1;i <= 4;i++){
    		imgArrayAI4[i-1] = addImage("AI1sprites/AI1right_" + i + ".png");
    	}
    	
    	//arraylist of images for AI 2
    	
    	imgArrayAI5 = new BufferedImage[4];
    	for(int i = 1;i <= 4;i++){
    		imgArrayAI5[i-1] = addImage("AI2sprites/AI2down_" + i + ".png");
    	}
    	imgArrayAI6 = new BufferedImage[4];
    	for(int i = 1;i <= 4;i++){
    		imgArrayAI6[i-1] = addImage("AI2sprites/AI2up_" + i + ".png");
    	}
    	imgArrayAI7 = new BufferedImage[4];
    	for(int i = 1;i <= 4;i++){
    		imgArrayAI7[i-1] = addImage("AI2sprites/AI2left_" + i + ".png");
    	}
    	imgArrayAI8 = new BufferedImage[4];
    	for(int i = 1;i <= 4;i++){
    		imgArrayAI8[i-1] = addImage("AI2sprites/AI2right_" + i + ".png");
    	}
    	
    	//arraylist of images for the FOOD
    	
    	imgArrayFood = new BufferedImage[20];
    	for(int i = 1;i <= 20;i++){
    		imgArrayFood[i-1] = addImage("Foodsprites/Food_" + i + ".png");
    	}		
    }
    
    //restarts the game
    
    public void restart(){		
    	xy = new Player(400,350,2);
    	xyz = new Player2(800,350);
    	AI = new Enemy(600,150,1);
    	AI2 = new Enemy(600,550,1);
    	points1 = 0;
    	points2 = 0;
    	points3 = 0;
   		points4 = 0;

    	MainTime.setTimeReached(true);
    	MainTime.resetCount();
    	
    	yummy = new ArrayList<Food>();
    	pewpew = new ArrayList<Bullet>();
    	pewpew2 = new ArrayList<Bullet>();
    	pewpew3 = new ArrayList<Bullet>();
    	pewpew4 = new ArrayList<Bullet>();
    }
    public void restartCageMode(){
    	xy = new Player(400,350,3);
    	MainTime.setTimeReached(true);
    	MainTime.resetCount();	
    	points1 = 0;
    	points2 = 0;
    	points3 = 0;
   		points4 = 0;
    	yummy = new ArrayList<Food>();
    	cages = new ArrayList<Enemy>();
    }
    
    //DRAW DRAW DRAWADRAWADRAWDRAWDRAWDRWAWDRAW
    
    public void draw(Graphics2D win) { 
    	//opening page
    	if(gameState == 0){
    		win.drawImage(bg2,0,0,null);
    		if(keys[4]){
    			gameState = 2;
    			sd.play(2);
    			sd.loop(2);
    			restart();
    		}else if(keys[5]){
    			gameState = 3;
    			sd.play(0);
    			sd.loop(0);
    			restart();
    		}else if(keys[6]){ 
    			gameState = 4;
    			sd.play(2);
    			sd.loop(2);
    			restart();
    		}else if(keys[7]){
    			gameState = 5;
    			sd.play(0);
    			sd.loop(0);
    			restart();
    		}else if(keys[8]){
    			gameState = 1;
    		}else if(keys[10]){
    			gameState = 7;
    			sd.play(3);
    			sd.loop(3);
    			restartCageMode();
    		}
    	}else if(gameState == 1){              //how-to-play page
    		win.drawImage(bg3,0,0,null); 
    		if(keys[9]){
    			gameState = 0;
    		}
    	}else if(gameState == 2){                //one player and noob
			win.drawImage(bg,0,0,null);
			MainTime.start();
			spawnFood(win,3);
			win.setColor(Color.gray);
			win.fill(HUD);
			drawHUD(win);
			drawTimer(win);
			
			xy.move(keys,winWidth,winHeight);
			if(xy.getDirection1()==1){
				xy.imageArrayMethod(win,imgArray1);
			}else if(xy.getDirection1()==0){
				xy.imageArrayMethod(win,imgArray2);
			}else if(xy.getDirection1()==2){
				xy.imageArrayMethod(win,imgArray3);
			}else if(xy.getDirection1()==3){
				xy.imageArrayMethod(win,imgArray4);
			}
			
			xyz.setLocation(-10,-10); //cheap and inefficient way of erasing player 2
			
			AI.moveEnemy1(yummy);
			if(AI.getDirection() == 0 || AI.getDirection() == 1 || AI.getDirection() == 7){
				AI.imageArrayMethod(win,imgArrayAI2);
			}else if(AI.getDirection() == 2){
				AI.imageArrayMethod(win,imgArrayAI4);
			}else if(AI.getDirection() == 3 || AI.getDirection() == 4 || AI.getDirection() == 5){
				AI.imageArrayMethod(win,imgArrayAI1);
			}else if(AI.getDirection() == 6){
				AI.imageArrayMethod(win,imgArrayAI3);
			}
			
			AI2.moveEnemy2(yummy);
			if(AI2.getDirection() == 0 || AI2.getDirection() == 1 || AI2.getDirection() == 7){
				AI2.imageArrayMethod(win,imgArrayAI6);
			}else if(AI2.getDirection() == 2){
				AI2.imageArrayMethod(win,imgArrayAI8);
			}else if(AI2.getDirection() == 3 || AI2.getDirection() == 4 || AI2.getDirection() == 5){
				AI2.imageArrayMethod(win,imgArrayAI5);
			}else if(AI2.getDirection() == 6){
				AI2.imageArrayMethod(win,imgArrayAI7);
			}
			projectileMotion1(win);
			projectileMotion3(win);
			projectileMotion4(win);
    	
    	}else if(gameState == 3){                   //one player and pro
			win.drawImage(bg,0,0,null);
			MainTime.start();
			spawnFood(win,2);
			win.setColor(Color.gray);
			win.fill(HUD);
			drawHUD(win);
			drawTimer(win);
			
			xy.move(keys,winWidth,winHeight);
			if(xy.getDirection1()==1){
				xy.imageArrayMethod(win,imgArray1);
			}else if(xy.getDirection1()==0){
				xy.imageArrayMethod(win,imgArray2);
			}else if(xy.getDirection1()==2){
				xy.imageArrayMethod(win,imgArray3);
			}else if(xy.getDirection1()==3){
				xy.imageArrayMethod(win,imgArray4);
			}
			
			xyz.setLocation(-10,-10);   //cheap and inefficient way of erasing player 2
			
			AI.setSpeed(2);
			AI.moveEnemy1(yummy);
			if(AI.getDirection() == 0 || AI.getDirection() == 1 || AI.getDirection() == 7){
				AI.imageArrayMethod(win,imgArrayAI2);
			}else if(AI.getDirection() == 2){
				AI.imageArrayMethod(win,imgArrayAI4);
			}else if(AI.getDirection() == 3 || AI.getDirection() == 4 || AI.getDirection() == 5){
				AI.imageArrayMethod(win,imgArrayAI1);
			}else if(AI.getDirection() == 6){
				AI.imageArrayMethod(win,imgArrayAI3);
			}
			
			AI2.setSpeed(2);
			AI2.moveEnemy2(yummy);
			if(AI2.getDirection() == 0 || AI2.getDirection() == 1 || AI2.getDirection() == 7){
				AI2.imageArrayMethod(win,imgArrayAI6);
			}else if(AI2.getDirection() == 2){
				AI2.imageArrayMethod(win,imgArrayAI8);
			}else if(AI2.getDirection() == 3 || AI2.getDirection() == 4 || AI2.getDirection() == 5){
				AI2.imageArrayMethod(win,imgArrayAI5);
			}else if(AI2.getDirection() == 6){
				AI2.imageArrayMethod(win,imgArrayAI7);
			}
			projectileMotion1(win);
			projectileMotion3(win);
			projectileMotion4(win);
    	
    	}else if(gameState == 4){             //two players and noob
			win.drawImage(bg,0,0,null);
			MainTime.start();
			spawnFood(win,2);
			win.setColor(Color.gray);
			win.fill(HUD);
			drawHUD(win);
			drawTimer(win);
			
			xy.move(keys,winWidth,winHeight);
			if(xy.getDirection1()==1){
				xy.imageArrayMethod(win,imgArray1);
			}else if(xy.getDirection1()==0){
				xy.imageArrayMethod(win,imgArray2);
			}else if(xy.getDirection1()==2){
				xy.imageArrayMethod(win,imgArray3);
			}else if(xy.getDirection1()==3){
				xy.imageArrayMethod(win,imgArray4);
			}
		
			xyz.move(keys,winWidth,winHeight);
			if(xyz.getDirection2()==1){
				xyz.imageArrayMethod(win,imgArray5);
			}else if(xyz.getDirection2()==0){
				xyz.imageArrayMethod(win,imgArray6);
			}else if(xyz.getDirection2()==2){
				xyz.imageArrayMethod(win,imgArray7);
			}else if(xyz.getDirection2()==3){
				xyz.imageArrayMethod(win,imgArray8);
			}
			
			AI.moveEnemy1(yummy);
			if(AI.getDirection() == 0 || AI.getDirection() == 1 || AI.getDirection() == 7){
				AI.imageArrayMethod(win,imgArrayAI2);
			}else if(AI.getDirection() == 2){
				AI.imageArrayMethod(win,imgArrayAI4);
			}else if(AI.getDirection() == 3 || AI.getDirection() == 4 || AI.getDirection() == 5){
				AI.imageArrayMethod(win,imgArrayAI1);
			}else if(AI.getDirection() == 6){
				AI.imageArrayMethod(win,imgArrayAI3);
			}
			
			AI2.moveEnemy2(yummy);
			if(AI2.getDirection() == 0 || AI2.getDirection() == 1 || AI2.getDirection() == 7){
				AI2.imageArrayMethod(win,imgArrayAI6);
			}else if(AI2.getDirection() == 2){
				AI2.imageArrayMethod(win,imgArrayAI8);
			}else if(AI2.getDirection() == 3 || AI2.getDirection() == 4 || AI2.getDirection() == 5){
				AI2.imageArrayMethod(win,imgArrayAI5);
			}else if(AI2.getDirection() == 6){
				AI2.imageArrayMethod(win,imgArrayAI7);
			}
			projectileMotion1(win);
			projectileMotion2(win);
			projectileMotion3(win);
			projectileMotion4(win);
    		
    	}else if(gameState == 5){       //two player and pro
			win.drawImage(bg,0,0,null);
			MainTime.start();
			spawnFood(win,1);
			win.setColor(Color.gray);
			win.fill(HUD);
			drawHUD(win);
			drawTimer(win);
			
			xy.move(keys,winWidth,winHeight);
			if(xy.getDirection1()==1){
				xy.imageArrayMethod(win,imgArray1);
			}else if(xy.getDirection1()==0){
				xy.imageArrayMethod(win,imgArray2);
			}else if(xy.getDirection1()==2){
				xy.imageArrayMethod(win,imgArray3);
			}else if(xy.getDirection1()==3){
				xy.imageArrayMethod(win,imgArray4);
			}
		
			xyz.move(keys,winWidth,winHeight);
			if(xyz.getDirection2()==1){
				xyz.imageArrayMethod(win,imgArray5);
			}else if(xyz.getDirection2()==0){
				xyz.imageArrayMethod(win,imgArray6);
			}else if(xyz.getDirection2()==2){
				xyz.imageArrayMethod(win,imgArray7);
			}else if(xyz.getDirection2()==3){
				xyz.imageArrayMethod(win,imgArray8);
			}
			
			AI.setSpeed(2);
			AI.moveEnemy1(yummy);
			if(AI.getDirection() == 0 || AI.getDirection() == 1 || AI.getDirection() == 7){
				AI.imageArrayMethod(win,imgArrayAI2);
			}else if(AI.getDirection() == 2){
				AI.imageArrayMethod(win,imgArrayAI4);
			}else if(AI.getDirection() == 3 || AI.getDirection() == 4 || AI.getDirection() == 5){
				AI.imageArrayMethod(win,imgArrayAI1);
			}else if(AI.getDirection() == 6){
				AI.imageArrayMethod(win,imgArrayAI3);
			}
			
			AI2.setSpeed(2);
			AI2.moveEnemy2(yummy);
			if(AI2.getDirection() == 0 || AI2.getDirection() == 1 || AI2.getDirection() == 7){
				AI2.imageArrayMethod(win,imgArrayAI6);
			}else if(AI2.getDirection() == 2){
				AI2.imageArrayMethod(win,imgArrayAI8);
			}else if(AI2.getDirection() == 3 || AI2.getDirection() == 4 || AI2.getDirection() == 5){
				AI2.imageArrayMethod(win,imgArrayAI5);
			}else if(AI2.getDirection() == 6){
				AI2.imageArrayMethod(win,imgArrayAI7);
			}
			projectileMotion1(win);
			projectileMotion2(win);
			projectileMotion3(win);
			projectileMotion4(win);
		
		
    	}else if(gameState == 6){
 			drawHUD(win);						
    		declareWinner(win);
    
    		if(keys[11]){
    			gameState = 0;
    			sd.stop(0);
    			sd.stop(1);
    			sd.stop(2);
    			sd.stop(3);
    		
    		}
    		
    	}else if(gameState == 7){
    		xy.setSpeed(3);
			win.drawImage(bg4,0,0,null);
			MainTime.start();
			win.setColor(Color.gray);
			win.fill(HUD);
			drawTimer(win);
			
			xy.move(keys,winWidth,winHeight);
			if(xy.getDirection1()==1){
				xy.imageArrayMethod(win,imgArray1);
			}else if(xy.getDirection1()==0){
				xy.imageArrayMethod(win,imgArray2);
			}else if(xy.getDirection1()==2){
				xy.imageArrayMethod(win,imgArray3);
			}else if(xy.getDirection1()==3){
				xy.imageArrayMethod(win,imgArray4);
			}
			spawnCage(win,2);
    	}
		
    }
    
    //draws the overall timer
    
    public void drawTimer(Graphics2D win) {

    	win.setFont(new Font("Comic Sans MS",Font.BOLD,30));
    	win.setColor(Color.cyan);
       	win.drawString("" + (60 - MainTime.getCount()), 610, 50); 
    	if(MainTime.getCount() >= 60){
    		gameState = 6;
    	}
    }
    
    //draws heads up display
    
    public void drawHUD(Graphics2D win){
    	if(gameState == 2 || gameState == 3){
    		win.setFont(new Font("Comic Sans MS",Font.BOLD,14));
    		win.setColor(Color.RED);
    		win.drawString("Player: " + "\n" + points1,1250,50);
    		win.drawImage(picP1,1260,75,null);
    		win.setColor(Color.white);
    		win.drawString("Comp 1: " + "\n" + points3,1250,150); 
    		win.drawImage(picC1,1260,175,null);
    		win.setColor(Color.BLACK);
    		win.drawString("Comp 2: " + "\n" + points4,1250,250);
    		win.drawImage(picC2,1260,275,null);
    	}else if(gameState == 4 || gameState == 5){
    		win.setFont(new Font("Comic Sans MS",Font.BOLD,14));
    		win.setColor(Color.RED);
    		win.drawString("Player1: " + "\n" + points1,1250,50);
    		win.drawImage(picP1,1260,75,null);
    		win.setColor(Color.BLUE);
    		win.drawString("Player2: " + "\n" + points2,1250,150);
    		win.drawImage(picP2,1260,175,null);
    		win.setColor(Color.white);
    		win.drawString("Comp 1: " + "\n" + points3,1250,250);  
    		win.drawImage(picC1,1260,275,null);
    		win.setColor(Color.BLACK);
    		win.drawString("Comp 2: " + "\n" + points4,1250,350);
    		win.drawImage(picC2,1260,375,null);
    	}
    }
    
    //shows the winner with most points when the game ends
    
    public void declareWinner(Graphics2D win){
    	win.setFont(new Font("Comic Sans MS",Font.BOLD,30)); 
    	win.setColor(Color.cyan);
    	String display = "";
    	if(points1 > points2 && points1 > points3 && points1 > points4){
    		display = "PLAYER 1 WINS!!!";
    	}else if(points2 > points1 && points2 > points3 && points2 > points4){
    		display = "PLAYER 2 WINS!!!";
    	}else if(points3 > points1 && points3 > points2 && points3 > points4){
    		display = "Computer 1 WINS!!!";
    	}else if(points4 > points1 && points4 > points2 && points4 > points3){
    		display = "Computer 2 WINS!!!";
    	}else{
    		win.setColor(Color.RED);
    		display = "YOU JUST GOT CAGED!!!";
    	}
    	win.drawString(display,440,350);
    	win.drawString("Press [SPACE] To Play Again!!!",440,450);
    }
    
    //shooting method for Player 1
    
    public void projectileMotion1(Graphics2D win){
    	bullTime++;
    	if(keys[16]&&bullTime>bullDelay&&(xy.getDirection1()==0)){
    		bullTime = 0;
    		Bullet b1 = new Bullet((int)xy.getX() ,(int)xy.getY() );
    		b1.setDy(-4);
    		pewpew.add(b1);
    	}else if(keys[16]&&bullTime>bullDelay&&(xy.getDirection1()==1)){
    		bullTime = 0;
    		Bullet b1 = new Bullet((int)xy.getX() ,(int)xy.getY() );
    		b1.setDy(4);
    		pewpew.add(b1);
    	}else if(keys[16]&&bullTime>bullDelay&&(xy.getDirection1()==2)){
    		bullTime = 0;
    		Bullet b1 = new Bullet((int)xy.getX() ,(int)xy.getY()+10 );
    		b1.setDx(-4);
    		pewpew.add(b1);
    	}else if(keys[16]&&bullTime>bullDelay&&(xy.getDirection1()==3)){
    		bullTime = 0;
    		Bullet b1 = new Bullet((int)xy.getX() ,(int)xy.getY()+10 );
    		b1.setDx(4);
    		pewpew.add(b1);
    	}
    	for(int i=0;i<pewpew.size();i++){
    		Bullet pro = pewpew.get(i);
    		pro.move();
    		pro.drawRec(win, bp1);
    		if(pro.getX()>winWidth-25){
    			pewpew.remove(i);
    			i--;
    		}
    		if(pro.getX()<0){
    			pewpew.remove(i);
    			i--;
    		}
    		if(pro.getY()<0){
    			pewpew.remove(i);
    			i--;
    		}
    		if(pro.getY()>winHeight){
    			pewpew.remove(i);
    			i--;
    		}
    	}
    	for(int j=0;j<pewpew.size();j++){
    		if(pewpew.get(j).intersects(xyz)){
    			xyz.setCanMove(false);
    			pewpew.remove(j);
    			j--;
    			points2 -= 20;
    			points1 += 20;
    			break;
    		}
    		if(pewpew.get(j).intersects(AI)){
    			AI.setCanMove(false);
    			pewpew.remove(j);
    			j--;
    			points3 -= 20;
    			points1 += 20;
    			break;
    		}
    		if(pewpew.get(j).intersects(AI2)){
    			AI2.setCanMove(false);
    			pewpew.remove(j);
    			j--;
    			points4 -= 20;
    			points1 += 20;
    			break;
    		}	
    	}
    	if (!xyz.getCanMove()) {
    		time2.start();
    		xyz.drawRec(win,blood);
    		if (time2.getCount()==3) {
    			time2.resetCount();
    			time2.setTimeReached(true);
    			xyz.setCanMove(true);
    			
    		}
    	}
    	if (!AI.getCanMove()) {
    		time4.start();
    		AI.drawRec(win,blood);
    		if (time4.getCount()==3) {
    			time4.resetCount();
    			time4.setTimeReached(true);
    			AI.setCanMove(true);
    			
    		}
    	}
    	if (!AI2.getCanMove()) {
    		time6.start();
    		AI2.drawRec(win,blood);
    		if (time6.getCount()==3) {
    			time6.resetCount();
    			time6.setTimeReached(true);
    			AI2.setCanMove(true);
    			
    		}
    	}
    }
    
    //shooting method for Player 2
    
    public void projectileMotion2(Graphics2D win){
    	bullTime2++;
    	if(keys[10]&&bullTime2>bullDelay2&&(xyz.getDirection2()==0)){
    		bullTime2 = 0;
    		Bullet b2 = new Bullet((int)xyz.getX() ,(int)xyz.getY() );
    		b2.setDy(-4);
    		pewpew2.add(b2);
    	}else if(keys[10]&&bullTime2>bullDelay2&&(xyz.getDirection2()==1)){
    		bullTime2 = 0;
    		Bullet b2 = new Bullet((int)xyz.getX() ,(int)xyz.getY() );
    		b2.setDy(4);
    		pewpew2.add(b2);
    	}else if(keys[10]&&bullTime2>bullDelay2&&(xyz.getDirection2()==2)){
    		bullTime2 = 0;
    		Bullet b2 = new Bullet((int)xyz.getX() ,(int)xyz.getY()+10);
    		b2.setDx(-4);
    		pewpew2.add(b2);
    	}else if(keys[10]&&bullTime2>bullDelay2&&(xyz.getDirection2()==3)){
    		bullTime2 = 0;
    		Bullet b2 = new Bullet((int)xyz.getX() ,(int)xyz.getY()+10 );
    		b2.setDx(4);
    		pewpew2.add(b2);
    	}
    	for(int i=0;i<pewpew2.size();i++){
    		Bullet pro2 = pewpew2.get(i);
    		pro2.move();
    		pro2.drawRec(win,bp2);
    		if(pro2.getX()>winWidth-25){
    			pewpew2.remove(i);
    			i--;
    		}
    		if(pro2.getX()<0){
    			pewpew2.remove(i);
    			i--;
    		}
    		if(pro2.getY()<0){
    			pewpew2.remove(i);
    			i--;
    		}
    		if(pro2.getY()>winHeight){
    			pewpew2.remove(i);
    			i--;
    		}
    	}
    	for(int j=0;j<pewpew2.size();j++){
    		if(pewpew2.get(j).intersects(xy)){
    			xy.setCanMove(false);
    			pewpew2.remove(j);
    			j--;
    			points1 -= 20;
    			points2 += 20;
    			break;
    		}
    		if(pewpew2.get(j).intersects(AI)){
    			AI.setCanMove(false);
    			pewpew2.remove(j);
    			j--;
    			points3 -= 20;
    			points2 += 20;
    			break;
    		}
    		if(pewpew2.get(j).intersects(AI2)){
    			AI2.setCanMove(false);
    			pewpew2.remove(j);
    			j--;
    			points4 -= 20;
    			points2 += 20;
    			break;
    		}
    	}
    	if (!xy.getCanMove()) {
    		time3.start();
    		xy.drawRec(win,blood);
    		if (time3.getCount()==3) {
    			time3.resetCount();
    			time3.setTimeReached(true);
    			xy.setCanMove(true);
    			
    		}
    	}
    	if (!AI.getCanMove()) {
    		time4.start();
    		AI.drawRec(win,blood);
    		if (time4.getCount()==3) {
    			time4.resetCount();
    			time4.setTimeReached(true);
    			AI.setCanMove(true);
    			
    		}
    	}
    	if (!AI2.getCanMove()) {
    		time6.start();
    		AI2.drawRec(win,blood);
    		if (time6.getCount()==3) {
    			time6.resetCount();
    			time6.setTimeReached(true);
    			AI2.setCanMove(true);
    			
    		}
    	}
    	
    }
    
    //shooting method for AI1
    
    public void projectileMotion3(Graphics2D win){
    	bullTime3++;
    	int num1 = rnd.nextInt(20)+1;
    	if((time5.getCount() % num1 == 0)){
			if(bullTime3>bullDelay3 && AI.getDirection() == 2){
				bullTime3 = 0;
    			Bullet b3 = new Bullet((int)AI.getX() ,(int)AI.getY() );
    			b3.setDx(4);
    			pewpew3.add(b3);	
			}else if(bullTime3>bullDelay3 && AI.getDirection() == 6){
				bullTime3 = 0;
	    		Bullet b3 = new Bullet((int)AI.getX() ,(int)AI.getY() );
    			b3.setDx(-4);
    			pewpew3.add(b3);	
			}else if(bullTime3>bullDelay3 && (AI.getDirection() == 0 || AI.getDirection() == 1 || AI.getDirection() == 7)){
				bullTime3 = 0;
		    	Bullet b3 = new Bullet((int)AI.getX() ,(int)AI.getY() );
    			b3.setDy(-4);
    			pewpew3.add(b3);
			}else if(bullTime3>bullDelay3 && (AI.getDirection() == 3 || AI.getDirection() == 4 || AI.getDirection() == 5)){
				bullTime3 = 0;
		    	Bullet b3 = new Bullet((int)AI.getX() ,(int)AI.getY() );
    			b3.setDy(4);
    			pewpew3.add(b3);
			}
    	}
    	for(int i=0;i<pewpew3.size();i++){
    		Bullet pro3 = pewpew3.get(i);
    		pro3.move();
    		pro3.drawRec(win,bp4);
    		if(pro3.getX()>winWidth-25){
    			pewpew3.remove(i);
    			i--;
    		}
    		if(pro3.getX()<0){
    			pewpew3.remove(i);
    			i--;
    		}
    		if(pro3.getY()<0){
    			pewpew3.remove(i);
    			i--;
    		}
    		if(pro3.getY()>winHeight){
    			pewpew3.remove(i);
    			i--;
    		}
    	}
    	for(int j=0;j<pewpew3.size();j++){
    		if(pewpew3.get(j).intersects(xy)){
    			xy.setCanMove(false);
    			pewpew3.remove(j);
    			j--;
    			points1 -= 20;
    			points3 += 20;
    			break;
    		}
    		if(pewpew3.get(j).intersects(xyz)){
    			xyz.setCanMove(false);
    			pewpew3.remove(j);
    			j--;
    			points2 -= 20;
    			points3 += 20;
    			break;
    		}
    		if(pewpew3.get(j).intersects(AI2)){
    			AI2.setCanMove(false);
    			pewpew3.remove(j);
    			j--;
    			points4 -= 20;
    			points3 += 20;
    			break;
    		}
    	}
    	if (!xy.getCanMove()) {
    		time3.start();
    		xy.drawRec(win,blood);
    		if (time3.getCount()==3) {
    			time3.resetCount();
    			time3.setTimeReached(true);
    			xy.setCanMove(true);
    			
    		}
    	}
    	if (!xyz.getCanMove()) {
    		time2.start();
    		xyz.drawRec(win,blood);
    		if (time2.getCount()==3) {
    			time2.resetCount();
    			time2.setTimeReached(true);
    			xyz.setCanMove(true);
    			
    		}
    	}
    	if (!AI2.getCanMove()) {
    		time6.start();
    		AI2.drawRec(win,blood);
    		if (time6.getCount()==3) {
    			time6.resetCount();
    			time6.setTimeReached(true);
    			AI2.setCanMove(true);
    			
    		}
    	}
    	
    	
    	
    	
    }
    
    //shooting method for AI2
    
    public void projectileMotion4(Graphics2D win){
    	bullTime4++;
    	int num1 = rnd.nextInt(30)+1;
    	if((time7.getCount() % num1 == 0)){
			if(bullTime4>bullDelay4 && AI2.getDirection() == 2){
				bullTime4 = 0;
    			Bullet b4 = new Bullet((int)AI2.getX() ,(int)AI2.getY() );
    			b4.setDx(4);
    			pewpew4.add(b4);	
			}else if(bullTime4>bullDelay4 && AI2.getDirection() == 6){
				bullTime4 = 0;
	    		Bullet b4 = new Bullet((int)AI2.getX() ,(int)AI2.getY() );
    			b4.setDx(-4);
    			pewpew4.add(b4);	
			}else if(bullTime4>bullDelay4 && (AI2.getDirection() == 0 || AI2.getDirection() == 1 || AI2.getDirection() == 7)){
				bullTime4 = 0;
		    	Bullet b4 = new Bullet((int)AI2.getX() ,(int)AI2.getY() );
    			b4.setDy(-4);
    			pewpew4.add(b4);
			}else if(bullTime4>bullDelay4 && (AI2.getDirection() == 3 || AI2.getDirection() == 4 || AI2.getDirection() == 5)){
				bullTime4 = 0;
		    	Bullet b4 = new Bullet((int)AI2.getX() ,(int)AI2.getY() );
    			b4.setDy(4);
    			pewpew4.add(b4);
			}
    	}
    	for(int i=0;i<pewpew4.size();i++){
    		Bullet pro4 = pewpew4.get(i);
    		pro4.move();
    		pro4.drawRec(win,bp3);
    		if(pro4.getX()>winWidth-25){
    			pewpew4.remove(i);
    			i--;
    		}
    		if(pro4.getX()<0){
    			pewpew4.remove(i);
    			i--;
    		}
    		if(pro4.getY()<0){
    			pewpew4.remove(i);
    			i--;
    		}
    		if(pro4.getY()>winHeight){
    			pewpew4.remove(i);
    			i--;
    		}
    	}
    	for(int j=0;j<pewpew4.size();j++){
    		if(pewpew4.get(j).intersects(xy)){
    			xy.setCanMove(false);
    			pewpew4.remove(j);
    			j--;
    			points1 -= 20;
    			points4 += 20;
    			break;
    		}
    		if(pewpew4.get(j).intersects(xyz)){
    			xyz.setCanMove(false);
    			pewpew4.remove(j);
    			j--;
    			points2 -= 20;
    			points4 += 20;
    			break;
    		}
    		if(pewpew4.get(j).intersects(AI)){
    			AI.setCanMove(false);
    			pewpew4.remove(j);
    			j--;
    			points3 -= 20;
    			points4 += 20;
    			break;
    		}
    	}
    	if (!xy.getCanMove()) {
    		time3.start();
    		xy.drawRec(win,blood);
    		if (time3.getCount()==3) {
    			time3.resetCount();
    			time3.setTimeReached(true);
    			xy.setCanMove(true);
    			
    		}
    	}
    	if (!xyz.getCanMove()) {
    		time2.start();
    		xyz.drawRec(win,blood);
    		if (time2.getCount()==3) {
    			time2.resetCount();
    			time2.setTimeReached(true);
    			xyz.setCanMove(true);
    			
    		}
    	}
    	if (!AI.getCanMove()) {
    		time4.start();
    		AI.drawRec(win,blood);
    		if (time4.getCount()==3) {
    			time4.resetCount();
    			time4.setTimeReached(true);
    			AI.setCanMove(true);
    			
    		}
    	}
    	
    	
    	
    	
    }
    
    //spawns the food every t second at random
    
    public void spawnFood(Graphics2D win,int t){
    	int num1 = rnd.nextInt(1220)+10;
    	int num2 = rnd.nextInt(660)+10;  
    	if ((MainTime.getCount() % t == 0 || prevTime == 0 ) && (prevTime != MainTime.getCount())) {
    		prevTime = MainTime.getCount();
    		yummy.add(new Food(num1,num2,imgArrayFood[rnd.nextInt(20)]));
    	}
    	
    	for(int i = 0; i < yummy.size(); i++){
    		yummy.get(i).drawRec(win,yummy.get(i).getImage());
    	}
    	for(int i = 0; i < yummy.size(); i++){
    		if(yummy.get(i).intersects(xy)){
    			yummy.remove(i);
    			i--;
    			points1 += 100;
    			sd.play(1);
    		} else if(yummy.get(i).intersects(xyz)){
    			yummy.remove(i);
    			i--;
    			points2 += 100;
    			sd.play(1);
    		}else if(yummy.get(i).intersects(AI)){
    			yummy.remove(i);
    			i--;
    			points3 += 100;
    			sd.play(1);
    		}else if(yummy.get(i).intersects(AI2)){
    			yummy.remove(i);
    			i--;
    			points4 += 100;
    			sd.play(1);
    		}
    	}
    }
    public void spawnCage(Graphics2D win,int t){
    	int num1 = rnd.nextInt(1220)+10;
    	int num2 = rnd.nextInt(660)+10;  
    	if ((MainTime.getCount() % t == 0 || prevTime2 == 0 ) && (prevTime2 != MainTime.getCount())) {
    		prevTime2 = MainTime.getCount();
    		cages.add(new Enemy(num1,num2,rnd.nextInt(2)+1));
    	}
    	for(int i = 0; i < cages.size(); i++){
    		cages.get(i).drawRec(win,picCage);
    		cages.get(i).moveCage(xy);
    		if(cages.get(i).intersects(xy)){
    			gameState = 6;
    		}
    	}
    	
    }
    
}