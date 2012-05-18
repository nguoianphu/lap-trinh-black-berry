package mypackage;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Color;
import net.rim.device.api.ui.TouchEvent;
import net.rim.device.api.ui.component.Status;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.ui.extension.component.PictureScrollField;
import net.rim.device.api.ui.extension.component.PictureScrollField.ScrollEntry;

public class Album extends MainScreen{
	
	public Album(){
		
		Bitmap[] images = new Bitmap[3];
        String[] labels = new String[3];
        String[] tooltips = new String[3];

        ScrollEntry[] entries = new ScrollEntry[3];

        for (int i = 0; i < entries.length; i++) 
        { 	
        	int imgIndex = i+1;
        	images[i] = resizeImage(Bitmap.getBitmapResource("pic" + imgIndex + ".png"));
//        	images[i] = Bitmap.getBitmapResource("pic" + imgIndex + ".png");
        	labels[i] = "Label for image " + imgIndex;
            tooltips[i] = "Tooltip for image " + imgIndex;
            entries[i] = new ScrollEntry(images[i], labels[i],tooltips[i]);
        }

        add(new PictureScroll(entries));        
    
        

	}
	private class PictureScroll extends PictureScrollField {
		private final ScrollEntry[] _entries;
		PictureScroll(ScrollEntry[] entries) {
			super(196,327);
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
    	Bitmap resizeBm = new Bitmap(150,175);
        bm.scaleInto(resizeBm,Bitmap.FILTER_BILINEAR);
    	return resizeBm;
    }

	
}
