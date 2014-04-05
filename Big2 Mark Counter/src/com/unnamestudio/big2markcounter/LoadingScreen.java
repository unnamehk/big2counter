package com.unnamestudio.big2markcounter;

import com.unnamestudio.big2markcounter.Settings;
import com.unnamestudio.framework.Game;
import com.unnamestudio.framework.Graphics;
import com.unnamestudio.framework.Screen;
import com.unnamestudio.framework.Graphics.PixmapFormat;

public class LoadingScreen extends Screen { 
	public boolean isLoadingScreenReady = false;
	public void setLoadingScreenReady(boolean k){
		isLoadingScreenReady = k;
	}
	public boolean getLoadingScreenReady(){
		return isLoadingScreenReady;
	}
	public LoadingScreen(Game game) {
		super(game);
	}
	
	@Override 
	public void update(float deltaTime) {
		Graphics g = game.getGraphics();
		Assets.loading_screen = g.newPixmap("loading_screen.png", PixmapFormat.ARGB8888);
		if (getLoadingScreenReady() == true){//skip for the loading screen
			Assets.main_screen_bg = g.newPixmap("main_screen_bg.png", PixmapFormat.ARGB8888);
			Assets.main_screen_title = g.newPixmap("main_screen_title.png", PixmapFormat.ARGB8888);
			Assets.main_screen_exit_button = g.newPixmap("main_screen_exit_button.png", PixmapFormat.ARGB8888);
			Assets.main_screen_buttons_zh = g.newPixmap("main_screen_buttons_zh.png", PixmapFormat.ARGB8888);
			Assets.main_screen_buttons_en = g.newPixmap("main_screen_buttons_en.png", PixmapFormat.ARGB8888);
			Assets.main_screen_buttons_cn = g.newPixmap("main_screen_buttons_cn.png", PixmapFormat.ARGB8888);
			Assets.game_rules_screen_bg = g.newPixmap("game_rules_screen_bg.png", PixmapFormat.ARGB8888);
			Assets.counter_screen_bg = g.newPixmap("counter_screen_bg.png", PixmapFormat.ARGB8888);
			Assets.counter_screen_home_button = g.newPixmap("counter_screen_home_button.png", PixmapFormat.ARGB8888);
			Assets.counter_screen_requested_home_zh = g.newPixmap("counter_screen_requested_home_zh.png", PixmapFormat.ARGB8888);
			Assets.counter_screen_requested_home_en = g.newPixmap("counter_screen_requested_home_en.png", PixmapFormat.ARGB8888);
			Assets.counter_screen_requested_home_cn = g.newPixmap("counter_screen_requested_home_cn.png", PixmapFormat.ARGB8888);
			Assets.game_rules_screen_temp = g.newPixmap("game_rules_screen_temp.png", PixmapFormat.ARGB8888);//temp file to be del
			Assets.setting_screen_temp = g.newPixmap("setting_screen_temp.png", PixmapFormat.ARGB8888);//temp file to be del
			Assets.setting_screen_temp_button = g.newPixmap("setting_screen_temp_button.png", PixmapFormat.ARGB8888);//temp file to be del
			Settings.load(game.getFileIO()); 
			game.setScreen(new MainMenuScreen(game));
		}
		setLoadingScreenReady(true);
	}
	@Override 
	public void present(float deltaTime) {
		Graphics g = game.getGraphics();
		if (isLoadingScreenReady == true)
			g.drawPixmap(Assets.loading_screen, 0, 0);
	}
	@Override
	public void pause() {
	}
	
	@Override 
	public void resume() {
	} 
	
	@Override
	public void dispose() { 
	}
}
	