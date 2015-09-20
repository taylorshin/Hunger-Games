/**
 * @(#)HungerGames.java
 *
 *
 * @author Taylor Shin and Derrick Han
 * @version 1.00 2013/5/15
 */

import javax.swing.JFrame;
public class HungerGames {
	public static void main(String[] args) {
        JFrame j1 = new JFrame();
        j1.setTitle("THE HUNGER GAMES (May the odds be ever in your favor)");
        j1.setSize(1365,730); //which is fullscreen of my lenovo and the schools lenovo
        //j1.setExtendedState(j1.MAXIMIZED_BOTH);
        //j1.setUndecorated(true);
        j1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j1.add(new GameComp(1260,730));//j1.getWidth(), j1.getHeight()
        j1.setVisible(true);
    }
 }