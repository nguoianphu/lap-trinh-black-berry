package mypackage;

import java.io.IOException;
import java.util.Hashtable;

import net.rim.device.api.ui.component.DateField;

import net.rim.device.api.system.PersistentObject;
import net.rim.device.api.system.PersistentStore;
import net.rim.device.api.ui.component.CheckboxField;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.NumericChoiceField;
import net.rim.device.api.ui.container.MainScreen;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public final class DataScreen extends MainScreen
{
    /**
     * Creates a new MyScreen object
     */
	EditField editField;
	CheckboxField checkboxField;
	NumericChoiceField numericChoiceField;
	DateField dateField;
	
	PersistentObject persistentObject;
	static final long KEY = 0x854e443fe027e690L;
	Hashtable persistentHashtable;
	
    public DataScreen()
    {        
        // Set the displayed title of the screen       
        setTitle("Data stored");
        
//        editField = new EditField("Data stored: ", "");
//        add(editField);
        
        checkboxField = new CheckboxField("Boolean data", false);
        numericChoiceField = new NumericChoiceField("Numeric: ",1,10,1 );
        dateField = new DateField("Date:", System.currentTimeMillis(), DateField.DATE);
        add(checkboxField);
        add(numericChoiceField);
        add(dateField);
        
        persistentObject = PersistentStore.getPersistentObject(KEY);
        
        if (persistentObject.getContents() == null) {
			persistentHashtable = new Hashtable();
			persistentObject.setContents(persistentHashtable);
		}
        else {
			persistentHashtable = (Hashtable)persistentObject.getContents();
		}
        
        if (persistentHashtable.containsKey("EditData")) { 
            editField.setText((String)persistentHashtable.get("EditData")); 
        } 
        if (persistentHashtable.containsKey("BoolData")) { 
            Boolean booleanObject = (Boolean)persistentHashtable.get("BoolData"); 
            checkboxField.setChecked(booleanObject.booleanValue()); 
        } 
        if (persistentHashtable.containsKey("IntData")) { 
            Integer intObject = (Integer)persistentHashtable.get("IntData"); 
            numericChoiceField.setSelectedValue(intObject.intValue()); 
        } 
        if (persistentHashtable.containsKey("Date")) { 
            Long longObject = (Long)persistentHashtable.get("Date"); 
            dateField.setDate(longObject.longValue()); 
        } 
        
    }// end constructor
    
    public void save() throws IOException { 
        persistentHashtable.put("EditData", editField.getText()); 
        persistentHashtable.put("BoolData", new Boolean(checkboxField.getChecked())); 
        persistentHashtable.put("IntData", new     
Integer(numericChoiceField.getSelectedValue())); 
        persistentHashtable.put("Date", new Long(dateField.getDate())); 
        persistentObject.commit(); 
    } 
    
}
