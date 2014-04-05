package com.unnamestudio.big2markcounter;

import java.util.List;

import com.unnamestudio.framework.Game;
import com.unnamestudio.framework.Graphics;
import com.unnamestudio.framework.Screen;
import com.unnamestudio.framework.Input.TouchEvent;
import com.unnamestudio.big2markcounter.Settings;

public class MainMenuScreen extends Screen { 
	public MainMenuScreen(Game game) {
		super(game);
	}
	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents(); 
		game.getInput().getKeyEvents();
		int len = touchEvents.size();
		for(int i = 0; i < len; i++) { 
			TouchEvent event = touchEvents.get(i); 
			if(event.type == TouchEvent.TOUCH_UP) {
				if(inBounds(event, 0, 1074, 272, 206)){
					/*Assets.pop.play(1); //on click sound not existing */
	        		System.exit(0);
				}
				if(inBounds(event, 345, 810, 293, 136)) {
					game.setScreen(new CounterScreen(game)); 
					/*Assets.pop.play(1); //on click sound not existing */
					return;
				}
				if(inBounds(event, 402, 971, 293, 136)) {
					game.setScreen(new GameRulesScreen(game)); 
					/*Assets.pop.play(1); //on click sound not existing */
					return;
				}
				if(inBounds(event, 345, 1124, 293, 136)) {
					game.setScreen(new SettingScreen(game)); 
					/*Assets.pop.play(1); //on click sound not existing */
					return;
				}
			}
		}
	}
	
	private boolean 
	inBounds(TouchEvent event, int x, int y, int width, int height) { 
		if(event.x > x && event.x < x + width - 1 && event.y > y && event.y < y + height - 1) 
			return true;
		else
			return false;
	}
	
	
	@Override 
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();
		g.drawPixmap(Assets.main_screen_bg, 0, 0);
		g.drawPixmap(Assets.main_screen_exit_button, 0, 1074);
		if(Settings.lang == 1){ //for zh
			g.drawPixmap(Assets.main_screen_title, 0, 0, 0, 0, 720, 367);
			g.drawPixmap(Assets.main_screen_buttons_zh, 345, 810);
		}
		if(Settings.lang == 2){ //for en
			g.drawPixmap(Assets.main_screen_title, 0, 0, 0, 367, 720, 367);
			g.drawPixmap(Assets.main_screen_buttons_en, 345, 810);
		}
		if(Settings.lang == 3){ //for cn
			g.drawPixmap(Assets.main_screen_title, 0, 0, 0, 734, 720, 367);
			g.drawPixmap(Assets.main_screen_buttons_cn, 345, 810);
		}
	}


	@Override
	public void pause() {
		Settings.save(game.getFileIO());
	}

	@Override
	public void resume() {
	}

	@Override
	public void dispose() {
	}
}
