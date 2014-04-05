package com.unnamestudio.big2markcounter;

import java.util.List;

import com.unnamestudio.big2markcounter.Settings;
import com.unnamestudio.framework.Game;
import com.unnamestudio.framework.Graphics;
import com.unnamestudio.framework.Screen;
import com.unnamestudio.framework.Input.TouchEvent;

public class SettingScreen extends Screen {
	public SettingScreen(Game game) {
		super(game);
	}
	public void setLang(int k){
		Settings.lang=k;
	}
	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents(); 
		game.getInput().getKeyEvents();
		int len = touchEvents.size();
		for(int i = 0; i < len; i++) { 
			TouchEvent event = touchEvents.get(i);
			if(event.type == TouchEvent.TOUCH_UP) {
				if(inBounds(event, 253, 1037, 215, 200)){
					/*Assets.pop.play(1); //on click sound not existing */
					game.setScreen(new MainMenuScreen(game));
				}
				if(inBounds(event, 94, 116, 116, 157)){
					/*Assets.pop.play(1); //on click sound not existing */
					setLang(1);
				}
				if(inBounds(event, 476, 120, 145, 168)){
					/*Assets.pop.play(1); //on click sound not existing */
					setLang(2);
				}
				if(inBounds(event, 297, 119, 81, 136)){
					/*Assets.pop.play(1); //on click sound not existing */
					setLang(3);
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
		g.drawPixmap(Assets.setting_screen_temp, 0, 0);
		if(Settings.lang == 1){ //for zh, temp
			g.drawPixmap(Assets.setting_screen_temp_button, 94, 116);
		}
		if(Settings.lang == 3){ //for en, temp
			g.drawPixmap(Assets.setting_screen_temp_button, 297, 119);
		}
		if(Settings.lang == 2){ //for cn, temp
			g.drawPixmap(Assets.setting_screen_temp_button, 476, 120);
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
