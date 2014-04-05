package com.unnamestudio.big2markcounter;

import java.util.List;

import com.unnamestudio.big2markcounter.Settings;
import com.unnamestudio.framework.Game;
import com.unnamestudio.framework.Graphics;
import com.unnamestudio.framework.Screen;
import com.unnamestudio.framework.Input.TouchEvent;

public class GameRulesScreen extends Screen {
	public GameRulesScreen(Game game) {
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
				if(inBounds(event, 253, 1037, 215, 200)){
					/*Assets.pop.play(1); //on click sound not existing */
					game.setScreen(new MainMenuScreen(game));
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
		g.drawPixmap(Assets.game_rules_screen_bg, 0, 0);
		g.drawPixmap(Assets.game_rules_screen_temp, 0, 0);//temp file to be del
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
