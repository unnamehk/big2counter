package com.unnamestudio.big2markcounter;

import java.util.List;

import com.unnamestudio.big2markcounter.Settings;
import com.unnamestudio.framework.Game;
import com.unnamestudio.framework.Graphics;
import com.unnamestudio.framework.Screen;
import com.unnamestudio.framework.Input.TouchEvent;


//cosmo starts to work with counter screen
public class CounterScreen extends Screen {
	public CounterScreen(Game game) {
		super(game);
	}
	public boolean isCounterStarted = false;
	public boolean isRequestedHome = false;
	
	@Override
	public void update(float deltaTime) {
		List<TouchEvent> touchEvents = game.getInput().getTouchEvents(); 
		game.getInput().getKeyEvents();
		int len = touchEvents.size();
		for(int i = 0; i < len; i++) { 
			TouchEvent event = touchEvents.get(i);
			if(event.type == TouchEvent.TOUCH_UP) {
				
				//when home button clicked
				if(inBounds(event, 253, 1037, 215, 200)){
					if (isRequestedHome == false){
						isRequestedHome = true;
						return;
					}
				}
				if(isRequestedHome == true){
					if(inBounds(event, 72, 461, 243, 238)){
						/*Assets.pop.play(1); //on click sound not existing */
						game.setScreen(new MainMenuScreen(game));
						return;
					}
					if(inBounds(event, 366, 443, 264, 262)){
						isRequestedHome = false;
						return;
					}
				}
				//end of when home button clicked
				
			}//end of touch event
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
		g.drawPixmap(Assets.counter_screen_bg, 0, 0);
		g.drawPixmap(Assets.counter_screen_home_button, 0, 0);
		
		//drawings when home button clicked
		if (isRequestedHome == true){
			if (Settings.lang == 1){
				g.drawPixmap(Assets.counter_screen_requested_home_zh, 0, 0);
			}
			if (Settings.lang == 2){
				g.drawPixmap(Assets.counter_screen_requested_home_en, 0, 0);
			}
			if (Settings.lang == 3){
				g.drawPixmap(Assets.counter_screen_requested_home_cn, 0, 0);
			}
		}
		
		
		//drawings before counter start
		if (isCounterStarted == false){
			return;
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
