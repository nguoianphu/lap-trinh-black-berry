package mypackage;

import net.rim.device.api.command.Command;
import net.rim.device.api.command.CommandHandler;
import net.rim.device.api.command.ReadOnlyCommandMetadata;
import net.rim.device.api.system.Bitmap;
import net.rim.device.api.ui.Field;
import net.rim.device.api.ui.MenuItem;
import net.rim.device.api.ui.component.BitmapField;
import net.rim.device.api.ui.component.ButtonField;
import net.rim.device.api.ui.component.CheckboxField;
import net.rim.device.api.ui.component.Dialog;
import net.rim.device.api.ui.component.EditField;
import net.rim.device.api.ui.component.Menu;
import net.rim.device.api.ui.component.ObjectChoiceField;
import net.rim.device.api.ui.component.PasswordEditField;
import net.rim.device.api.ui.component.SeparatorField;
import net.rim.device.api.ui.container.HorizontalFieldManager;
import net.rim.device.api.ui.container.MainScreen;
import net.rim.device.api.util.StringProvider;

/**
 * A class extending the MainScreen class, which provides default standard
 * behavior for BlackBerry GUI applications.
 */
public final class UiScreen extends MainScreen {
    /**
     * Creates a new MyScreen object
     */
	// login text
	EditField username;
	// password
	PasswordEditField password;
	// domain 
    ObjectChoiceField domain;
    // button clear
    ButtonField btnClear;
    // button login
    ButtonField btnLogin;
    // loginHandler
    LoginCommandHandler loginHandler = new LoginCommandHandler();
    ClearCommandHandler clearHandler = new ClearCommandHandler();
	
    public UiScreen()
    {     
    	// add a logo
        Bitmap logo = Bitmap.getBitmapResource("iconvn.png");
        BitmapField bmpField = new BitmapField(logo, Field.FIELD_HCENTER);
        add(bmpField);
       
        // --------------
        add(new SeparatorField());
        
        // user name & password
        username = new EditField("Username: ", "");
        password = new PasswordEditField("Password: ", "");
        add(username);
        add(password);
        
        // domain 
        domain = new ObjectChoiceField("Domain: ",new String[]{"Home","Work"} );
        add(domain);
        
        // Remember pass
        CheckboxField chkRemember = new CheckboxField("Remember password", true);
        add(chkRemember);
        
        // --------------
        add(new SeparatorField());
        
       
        // Button detail
        btnClear = new ButtonField("Clear", ButtonField.CONSUME_CLICK);
        btnLogin = new ButtonField("Login", ButtonField.CONSUME_CLICK );
       
        // button position
        HorizontalFieldManager buttonManager = new HorizontalFieldManager(Field.FIELD_RIGHT);
        add(buttonManager);
        buttonManager.add(btnClear);
        buttonManager.add(btnLogin);
        
        // event clear
        btnClear.setCommand(new Command(clearHandler));
        btnLogin.setCommand(new Command(loginHandler));
        
        
    }// end contractor

	// clear text function
	public void clearText(){
		username.setText("");
		password.setText("");
	}
	
	// login event
	public void login() {
		if (username.getTextLength() == 0 || password.getTextLength() == 0) { 
            Dialog.alert("You must enter a username and password"); 
        } 
        else { 
            UiApp.getUiApplication().pushScreen(new Album()); 
        } 
		
	}
	
	// Menus
	protected void makeMenu(Menu menu, int instance) { 
        super.makeMenu(menu, instance); 
        
        MenuItem loginMenu = new MenuItem(new StringProvider("Login"), 20, 10); 
        loginMenu.setCommand(new Command(loginHandler)); 
        menu.add(loginMenu); 
        
        MenuItem clearMenu = new MenuItem(new StringProvider("Clear"), 20, 10);
        clearMenu.setCommand(new Command(clearHandler)); 
        menu.add(clearMenu); 
    } 
	
	// class CommandHandlers
	class LoginCommandHandler extends CommandHandler{
		public void execute(ReadOnlyCommandMetadata metedata, Object context){
			login();
		}
	}
	class ClearCommandHandler extends CommandHandler{
		public void execute(ReadOnlyCommandMetadata metedata, Object context){
			clearText();
		}
	}
	
}// end class UiScreen
