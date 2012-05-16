package com.ui;

import net.rim.device.api.ui.UiApplication;

public class UImain extends UiApplication{
	public static void main(String[] args){
		UImain uiApp = new UImain();
		uiApp.enterEventDispatcher();
	}
	public UImain(){
		pushScreen(new UIscreen());
	}

}
