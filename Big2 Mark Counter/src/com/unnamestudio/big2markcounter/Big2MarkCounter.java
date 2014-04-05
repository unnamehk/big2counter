package com.unnamestudio.big2markcounter;

import com.unnamestudio.framework.Screen;
import com.unnamestudio.framework.impl.AndroidGame;

public class Big2MarkCounter extends AndroidGame { 
	@Override
	public Screen getStartScreen() { 
		return new LoadingScreen(this);
	}
}