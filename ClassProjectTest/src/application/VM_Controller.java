package application;

import java.util.ArrayList;
import java.util.Arrays;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class VM_Controller {

    @FXML//gui content
    private TextField TvmName;
    
    @FXML
    private TextField OStype;

    @FXML
    private TextField TvmVersion;

    @FXML
    private TextField TvmSource;

    @FXML
    private TextField TvmIP;

    @FXML
    private Button BvmSubmit;

    @FXML
    public Button BvmCancel;
    //alert boxes
    Alert nameAlert = new Alert(AlertType.ERROR,"name can't be empty");
	Alert IPAlert = new Alert(AlertType.ERROR,"IP can't be empty/ NOT Valid");
    Alert versionAlert = new Alert(AlertType.ERROR,"Version can't be empty");
    Alert sourceAlert = new Alert(AlertType.ERROR,"Source can't be empty");
    	
    @FXML//closes window
    private void closeBvmButton(ActionEvent event) {
    	Stage stage = (Stage) BvmCancel.getScene().getWindow();
    	stage.close();
    }
    
    @FXML//simple validation
    private void submit(ActionEvent event) {
    	if (TvmName.getText().isEmpty()) {
    		System.out.println("OS Name cant be empty");
    		nameAlert.show();
    	}else if(OStype.getText().isEmpty()) {
    		System.out.println("Name can't be empty");
    	}else if(TvmVersion.getText().isEmpty()) {
    		System.out.println("Version can't be empty");
    		versionAlert.show();
    	}else if(TvmSource.getText().isEmpty()) {
    		System.out.println("source can't be empty");
    		sourceAlert.show();
    	}else if(TvmIP.getText().isEmpty()){
    		System.out.println("IP Can't be empty");
    		IPAlert.show();
    	}else {
    		//System.out.println("Everything is fine.jpg");
    	}
    	
    	String IPText = TvmIP.getText();//makes the arraylist for the vm
    	ArrayList<String> Templist = new ArrayList<>(Arrays.asList(IPText.split(";")));
    	
    	
    	//variables for object creation
    	int ethernetcount = Templist.size();
    	String vmName = TvmName.getText();
    	String vmOStype = OStype.getText();
    	String vmVersion = TvmVersion.getText();
    	String vmSource = TvmSource.getText();
    	
    	@SuppressWarnings("unused")
		VM vmName1 = new VM(vmName,vmOStype,vmVersion,vmSource,ethernetcount,Templist); 	
    	System.out.println(vmName1.getVMNameList());
    }
 
}
