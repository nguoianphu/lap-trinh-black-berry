package mypackage;

import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.FieldChangeListener;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.CheckboxField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.ObjectChoiceField;
import net.rim.device.api.ui.component.PasswordEditField;
import net.rim.device.api.ui.component.SeparatorField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.MainScreen;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public final class UIadvancedScreen extends MainScreen implements FieldChangeListener
{
    /**
     * Creates a new MyScreen object
     */
	// horizontal
	HorizontalFieldManager buttonManager;
	// logo
	BitmapField bmpField;
	// login text
	EditField username;
	// password
	PasswordEditField password;
	// domain 
    ObjectChoiceField domain;
    // remember password
    CheckboxField chkRemember;
    // button clear
    ButtonField btnClear;
    // button login
    ButtonField btnLogin;
    
	
    public UIadvancedScreen()
    {     
    	// add a logo
        Bitmap logo = Bitmap.getBitmapResource("vn.png");
        bmpField = new BitmapField(logo, Field.FIELD_HCENTER);
        add(bmpField);
       
        // --------------
        add(new SeparatorField());
        
        // username & password
        username = new EditField("Username: ", "");
        password = new PasswordEditField("Password: ", "");
        add(username);
        add(password);
        
        // domain 
        domain = new ObjectChoiceField("Domain: ",new String[]{"Home","Work"} );
        add(domain);
        
        // Remember pass
        chkRemember = new CheckboxField("Remember password", false);
        add(chkRemember);
        
        // --------------
        add(new SeparatorField());
        
       
        // Button detail
        btnClear = new ButtonField("Clear", ButtonField.CONSUME_CLICK);
        btnLogin = new ButtonField("Login", ButtonField.CONSUME_CLICK );
       
        // button position
        buttonManager = new HorizontalFieldManager(Field.FIELD_RIGHT);
        add(buttonManager);
        buttonManager.add(btnClear);
        buttonManager.add(btnLogin);
        
        // event clear
        btnClear.setChangeListener(this);
        btnLogin.setChangeListener(this);
        
        
    }

    // clear text event
	public void fieldChanged(Field field, int context) {
		// TODO Auto-generated method stub
		if (field == btnClear){
		clearText();
		}
		else if (field == btnLogin) { 
            login(); 
			
		}
	}
	
	// clear text function
	public void clearText(){
		username.setText("");
		password.setText("");
	}
	
	// login success
	public void login() {
		if (username.getTextLength() == 0 || password.getTextLength() == 0) { 
            Dialog.alert("You must enter a username and password"); 
        } 
        else { 
            String user = username.getText();
            String selectedDomain =  
              (String)domain.getChoice(domain.getSelectedIndex()); 
        UIadvancedScreenSuccess loginSuccessScreen =  
                new UIadvancedScreenSuccess(user, selectedDomain); 
        UIadvancedApp.getUiApplication().pushScreen(loginSuccessScreen); 
        } 
		
	}
	
}// end class
