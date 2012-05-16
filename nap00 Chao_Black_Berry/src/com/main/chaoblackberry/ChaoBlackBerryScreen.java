package com.main.chaoblackberry;

import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.RichTextField;
import net.rim.device.api.ui.container.MainScreen;

public class ChaoBlackBerryScreen extends MainScreen{
	
	public ChaoBlackBerryScreen(){
		super();
		String str_title = "Chao BB title";
		String str_text = "Noi dung chinh, hien thi tren man hinh";
		LabelField title = new LabelField( str_title ,
			LabelField.ELLIPSIS | LabelField.USE_ALL_WIDTH);
		setTitle(title);
		add(new RichTextField(str_text));
		
	}
	public boolean onClose(){
		Dialog.alert("Tam biet");
		System.exit(0);
		return true;
	}
	

}
