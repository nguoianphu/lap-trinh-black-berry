package mypackage;

import net.rim.device.api.system.Display;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.TouchEvent;
import net.rim.device.api.ui.component.Status;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.extension.component.PictureScrollField;
import net.rim.device.api.ui.extension.component.PictureScrollField.ScrollEntry;

public class Album extends MainScreen {
	
	private int displayWidth = Display.getWidth();
	private int displayHeight = Display.getHeight();
	
	public Album(){
		
		Bitmap[] images = new Bitmap[3];
        String[] labels = new String[3];
        String[] tooltips = new String[3];

        ScrollEntry[] entries = new ScrollEntry[3];

        for (int i = 0; i < entries.length; i++) 
        { 	
        	int imgIndex = i+1;
        	images[i] = resizeImage(Bitmap.getBitmapResource("pic" + imgIndex + ".png"));
        	labels[i] = "Label for image " + imgIndex;
            tooltips[i] = "Tooltip for image " + imgIndex;
            entries[i] = new ScrollEntry(images[i], labels[i],tooltips[i]);
        }
		
		/*
		Bitmap[] images = new Bitmap[3];
        String[] labels = new String[3];
        String[] tooltips = new String[3];
        
        images[0] = resizeImage(Bitmap.getBitmapResource("pic1.png"));
        labels[0] = "Label for image 1";
        tooltips[0] = "Tooltip for image 1";

        images[1] = resizeImage(Bitmap.getBitmapResource("pic2.png"));
        labels[1] = "Label for image 2";
        tooltips[1] = "Tooltip for image 2";

        images[2] = resizeImage(Bitmap.getBitmapResource("pic3.png"));
        labels[2] = "Label for image 3";
        tooltips[2] = "Tooltip for image 3";

        ScrollEntry[] entries = new ScrollEntry[3];
        
        for (int i = 0; i < entries.length; i++) 
        { 
             entries[i] = new ScrollEntry(images[i], labels[i],tooltips[i]);
        }
        */
		
        // final step - add entries to picturecroll
        add(new PictureScroll(entries));
        

	}
	private class PictureScroll extends PictureScrollField {
		private final ScrollEntry[] _entries;
		PictureScroll(ScrollEntry[] entries) {
			super(displayWidth/2,displayHeight/2);
			_entries = entries;
			this.setData(entries, 0);
			this.setHighlightStyle(HighlightStyle.ILLUMINATE_WITH_SHRINK_LENS);
			this.setHighlightBorderColor(Color.BLUE);
			this.setLabelsVisible(true);
		}
		protected boolean touchEvent(TouchEvent message) {
		    if(message.getEvent() == TouchEvent.CLICK)
		    {
		        if(this.isFocus())
		        {
		            Status.show("You selected item " + _entries[this.getCurrentImageIndex()].getLabel());
		            return true;            
		        }                  
		    }
		    return super.touchEvent(message); 	
		}
	}

	private Bitmap resizeImage(Bitmap bm) {
    	Bitmap resizeBm = new Bitmap(displayWidth/2,displayHeight/2);
        bm.scaleInto(resizeBm,Bitmap.FILTER_BILINEAR);
    	return resizeBm;
    }
	
}// end class
