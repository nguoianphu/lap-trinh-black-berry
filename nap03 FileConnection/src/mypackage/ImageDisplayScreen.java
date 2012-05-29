package mypackage;

import net.rim.device.api.system.Display;

import net.rim.device.api.math.Fixed32;
import net.rim.device.api.system.EncodedImage;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.container.MainScreen;

public class ImageDisplayScreen extends MainScreen{
	public ImageDisplayScreen(EncodedImage image){
		int displayWidth = Fixed32.toFP(Display.getWidth());
		int imageWidth = Fixed32.toFP(image.getWidth());
		int scalingFactor = Fixed32.div(imageWidth, displayWidth);
		EncodedImage scaledImage = image.scaleImage32(scalingFactor, scalingFactor);
		BitmapField bitmapFiled = new BitmapField();
		bitmapFiled.setImage(scaledImage);
		add(bitmapFiled);
	}
}
