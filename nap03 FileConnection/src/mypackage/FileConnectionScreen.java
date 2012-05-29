package mypackage;

import java.io.InputStream;
import java.util.Enumeration;
import java.util.Vector;

import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;

import net.rim.device.api.system.EncodedImage;
import net.rim.device.api.ui.MenuItem;
import net.rim.device.api.ui.UiApplication;
import net.rim.device.api.ui.component.Menu;
import net.rim.device.api.ui.component.ObjectListField;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.util.StringProvider;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public final class FileConnectionScreen extends MainScreen
{
    /**
     * Creates a new MyScreen object
     */
	
	private ObjectListField fileList;
	private String currentPath = "file:///";
	
    public FileConnectionScreen()
    {        
        // Set the displayed title of the screen       
        setTitle("File Connection");
        
        fileList = new ObjectListField();
        fileList.set(new String[] {"store/", "SDCard/"});
        add(fileList);
        
    }
    
    protected void makeMenu(Menu menu, int instance) {
    	super.makeMenu(menu, instance);
    	menu.add(new MenuItem(new StringProvider("Select"), 10, 10){
    		public void run(){
    			loadFile();
    		}
    	});	
	}
    
    private void loadFile(){
    	currentPath += fileList.get(fileList, fileList.getSelectedIndex());
    	try{
    		FileConnection fileConnection = (FileConnection)Connector.open(currentPath);
    		if (fileConnection.isDirectory()) {
				Enumeration directoryEnumarator = fileConnection.list();
				Vector contentVector = new Vector();
				while (directoryEnumarator.hasMoreElements()) {
					contentVector.addElement(directoryEnumarator.nextElement());
				}
				String[] directoryContents = new String[contentVector.size()];
				contentVector.copyInto(directoryContents);
				fileList.set(directoryContents);
			}
    		else if (currentPath.endsWith(".jpg") || currentPath.endsWith(".png")) {
				InputStream inputStream = fileConnection.openInputStream();
				byte[] imageBytes = new byte[(int)fileConnection.fileSize()];
				inputStream.read(imageBytes);
				inputStream.close();
				EncodedImage eImage = EncodedImage.createEncodedImage(imageBytes, 0, imageBytes.length);
				UiApplication.getUiApplication().pushScreen(new ImageDisplayScreen(eImage));
			}
    		
    		
    	}
    	catch (Exception e) {
			// TODO: handle exception
		}
    }
}
