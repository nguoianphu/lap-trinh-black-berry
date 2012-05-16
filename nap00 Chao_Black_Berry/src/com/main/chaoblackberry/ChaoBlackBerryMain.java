package com.main.chaoblackberry;

import net.rim.device.api.ui.UiApplication;

public class ChaoBlackBerryMain extends UiApplication {
	
	public static void main(String[] args){
		
		ChaoBlackBerryMain chaoBB = new ChaoBlackBerryMain();
		chaoBB.enterEventDispatcher();
	}
	public ChaoBlackBerryMain(){
		pushScreen(new ChaoBlackBerryScreen());
	}
	
}
