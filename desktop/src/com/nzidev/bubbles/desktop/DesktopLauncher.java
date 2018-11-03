package com.nzidev.bubbles.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.nzidev.bubbles.Bubbles;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new LwjglApplication(new Bubbles(), config);

		config.width = 480;
		config.height = 800;
		config.title = "Bubbles";
	}
}
