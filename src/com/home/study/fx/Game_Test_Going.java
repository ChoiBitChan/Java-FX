package com.home.study.fx;

public class Game_Test_Going extends Thread {
	
	Game_Test game_test = new Game_Test();
	
	
	public void run() {
		
		try {
			Thread.sleep(500);
			game_test.move(0, 1);
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
