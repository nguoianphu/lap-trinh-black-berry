package mypackage;

import net.rim.device.api.ui.component.LabelField;
import net.rim.device.api.ui.container.MainScreen;

public class UIadvancedScreenSuccess extends MainScreen{
	public UIadvancedScreenSuccess(String username, String domain) {
		add(new LabelField("Loggin successful!"));
		add(new LabelField("Username: " + username));
		add(new LabelField("Domain: " + domain));
	}

}
