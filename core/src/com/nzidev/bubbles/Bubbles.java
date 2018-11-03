package com.nzidev.bubbles;


import com.badlogic.gdx.Game;

import com.nzidev.bubbles.loader.ResourseLoader;
import com.nzidev.bubbles.screens.SplashScreen;

public class Bubbles extends Game {


	
	@Override
	public void create () {
		ResourseLoader.load();
		setScreen(new SplashScreen(this));
	}

	@Override
	public void dispose () {
		super.dispose();

		ResourseLoader.dispose();

	}
}
