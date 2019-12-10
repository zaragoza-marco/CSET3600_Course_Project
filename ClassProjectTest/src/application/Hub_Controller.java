package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
public class Hub_Controller {
	
	//These are the alert boxes that show up when invalid data is entered
	Alert nameAlert = new Alert(AlertType.ERROR,"name can't be empty");
	Alert IPAlert = new Alert(AlertType.ERROR,"IP can't be empty/ NOT Valid");
	Alert SubnetAlert = new Alert(AlertType.ERROR,"Subnet can't be empty/invalid");
	Alert IntAlert = new Alert(AlertType.ERROR,"Interface can't be empty");
	
	
	//gui controls and inputs
    @FXML
    private TextField ThubName;
    
    @FXML
    private TextField ThubIP;

    @FXML
    private TextField ThubSubnet;

    @FXML
    private TextField ThubIntCount;
    
    @FXML
    private Button hubSubmit;
    
    @FXML
    private Button hubCancel;
    
    @FXML //closes the window
    private void  hubCancel(ActionEvent event) {
    	Stage stage = (Stage) hubCancel.getScene().getWindow();
    	stage.close();
    }
    
    ValidateIPAddress ipaddress = new ValidateIPAddress();
    
    @FXML //a simple input validation to assist with hub creation
     private void submit(ActionEvent event) {
    	if (ThubName.getText().isEmpty()){
    		//System.out.println("Can't be empty");
    		nameAlert.show();
    	}else if(!ipaddress.isValidIPv4(ThubIP.getText())){
    		//System.out.println("not valid IP");
    		//System.out.println(ThubName.getText());
    		//System.out.println(ipaddress.isValidIPv4(ThubIP.getText()));
    		IPAlert.show();
    		ThubIP.clear();
    	}else if(ThubIntCount.getText().isEmpty()){
    		//System.out.println("everything is fine");
    		//System.out.println(ThubName.getText());
    		//System.out.println(ipaddress.isValidIPv4(ThubIP.getText()));
    		IntAlert.show();
    	}else {
    		
    	}
    	//variables to create the hub
    	String hubName = ThubName.getText();
    	String hubIPaddress = ThubIP.getText();
    	String hubSubnet = ThubSubnet.getText();
    	int hubIntCount = Integer.parseInt(ThubIntCount.getText());
    	//subnet validation step
    	ValidateSubnet tempsub = new ValidateSubnet(hubSubnet);
    	if (!tempsub.getsubnetValid()) {
    		SubnetAlert.show();
    		ThubSubnet.clear();
    	}else {
    		//System.out.print("new hub");
    		//return 0;
    	}
    	//actual object construct
    	@SuppressWarnings("unused")
		Hub hubName1 = new Hub(hubName,hubIPaddress,hubIntCount,hubSubnet);
    	
    }
    
}
