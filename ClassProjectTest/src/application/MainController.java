package application;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
public class MainController {
	@FXML //gui items
	private MenuItem save;
	
	@FXML
	private MenuItem addHub;
	
	@FXML
	private MenuItem vmbutton;
	
	 @FXML
	 private MenuItem aboutButton;
	//method to save the file
	public void SaveFileWithFileChooser(ActionEvent event){
		
		VM savevm = new VM();//creates vm object to access methods
		Hub savehub = new Hub();
		String saveVMText = savevm.saveVM();
		String saveHubText = savehub.saveHub();//hub object to create the string to be saved
		String sampleText = saveVMText + saveHubText;
		
		FileChooser fileChooser = new FileChooser();//opens the file save gui builtin method/ should be own class
		 
        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("Config (*.cfg)", "*.cfg");//makes it so the file is a .cfg file
        fileChooser.getExtensionFilters().add(extFilter);

        //Show save file dialog
        File file = fileChooser.showSaveDialog(new Stage());
        
        if (file != null) {
            saveTextToFile(sampleText, file);}
        }//actual file output
    public void saveTextToFile(String content, File file) {
        try {
            PrintWriter writer;
            writer = new PrintWriter(file);
            writer.println(content);
            writer.close();
        } catch (IOException ex) {
            Logger.getLogger(SaveFileWithFileChooser.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
	
    @FXML//makes the hub device creation window
    void addHubWindow (ActionEvent event){
    	//System.out.println("addHub functions");
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Hub.fxml"));
    		Parent root1 = (Parent) fxmlLoader.load();
    		
    		Stage hubStage = new Stage();
    		hubStage.setScene(new Scene(root1));
    		hubStage.show();
    	}catch (Exception e) {
    		System.out.println("cant add hub");
    	}
    }

    
    @FXML//makes the vm device creation window
    void addVMWindow (ActionEvent event){
    	//System.out.println("addHub functions");
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("VM.fxml"));
    		Parent root2 = (Parent) fxmlLoader.load();
    		
    		Stage VMStage = new Stage();

    		VMStage.setScene(new Scene(root2));
    		VMStage.show();
    	}catch (Exception e) {
    		System.out.println("cant add vm");
    	}
    }
    
    @FXML//makes the help window
    void addAboutWindow (ActionEvent event){
    	//System.out.println("addHub functions");
    	try {
    		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Help.fxml"));
    		Parent root3 = (Parent) fxmlLoader.load();
    		
    		Stage AboutStage = new Stage();

    		AboutStage.setScene(new Scene(root3));
    		AboutStage.show();
    	}catch (Exception e) {
    		System.out.println("cant add about");
    	}
    }
    
}
	

