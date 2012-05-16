package com.ui;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.BasicEditField;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.component.SeparatorField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.container.VerticalFieldManager;

public class UIscreen extends MainScreen{
	
	HorizontalFieldManager _fileManagerTop;
	VerticalFieldManager _fieldManagerMiddle;
	HorizontalFieldManager _fieldManagerBottom;
	
	BitmapField _bitMap;
	Bitmap _vnImg, _jpImg, _ukImg;
	LabelField _label;
	BasicEditField _input;
	String _thudo, _vnThudo, _jpThudo, _ukThudo;

	public UIscreen(){
		super();
		LabelField title = new LabelField("User Interface app", 
				LabelField.ELLIPSIS | LabelField.USE_ALL_WIDTH);
		setTitle(title);
		
		_fileManagerTop = new HorizontalFieldManager();
		_fieldManagerMiddle = new VerticalFieldManager();
		_fieldManagerBottom = new HorizontalFieldManager();
		
		add(_fileManagerTop);
		// them dong ke ngan cach ---------------------------
		add(new SeparatorField());
		add(_fieldManagerMiddle);
		// them dong ke ngan cach ---------------------------
		add(new SeparatorField());
		add(_fieldManagerBottom);
		
		// Top
		_vnImg = Bitmap.getBitmapResource("vn.png");
		_jpImg = Bitmap.getBitmapResource("jp.png");
		_ukImg = Bitmap.getBitmapResource("uk.png");
		
		_bitMap = new BitmapField();
		_bitMap.setBitmap(_vnImg);
		_fileManagerTop.add(_bitMap);
		
		// Middle
		_vnThudo = "Hanoi";
		_jpThudo = "Tokyo";
		_ukThudo = "London";
		_thudo = _vnThudo;
		
		_input = new BasicEditField("Thu do: ", _thudo);
		_label = new LabelField("Nhan button de chon ten quoc gia");
		_fieldManagerMiddle.add(_input);
		_fieldManagerMiddle.add(_label);
		
		
		// Bottom
		ButtonField vnBtn = new ButtonField("Vietnam");
		ButtonField jpBtn = new ButtonField("Japan");
		ButtonField ukBtn = new ButtonField(" UK ");
		
		_fieldManagerBottom.add(vnBtn);
		_fieldManagerBottom.add(jpBtn);
		_fieldManagerBottom.add(ukBtn);
		
FieldChangeListener listenerVietnam = new FieldChangeListener() {
			
			public void fieldChanged(Field field, int context) {
				// TODO Auto-generated method stub
				_bitMap.setBitmap(_vnImg);
				_input.setText(_vnThudo);
				
			}
		};
		
FieldChangeListener listenerJapan = new FieldChangeListener() {
			
			public void fieldChanged(Field field, int context) {
				// TODO Auto-generated method stub
				_bitMap.setBitmap(_jpImg);
				_input.setText(_jpThudo);
				
			}
		};
		
FieldChangeListener listenerUK = new FieldChangeListener() {
			
			public void fieldChanged(Field field, int context) {
				// TODO Auto-generated method stub
				_bitMap.setBitmap(_ukImg);
				_input.setText(_ukThudo);
				
			}
		};
		
		vnBtn.setChangeListener(listenerVietnam);
		jpBtn.setChangeListener(listenerJapan);
		ukBtn.setChangeListener(listenerUK);
		
	
		
	}// end public UIscreen()
	
	public boolean onClose() { 
		Dialog.alert("Tam biet!"); 
		System.exit(0); 
		return true; 
	} 
	
	
}
