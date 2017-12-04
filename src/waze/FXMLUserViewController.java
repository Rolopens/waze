/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waze;

import java.io.IOException;
import java.net.URL;
import java.util.Calendar;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import java.util.Date;


/**
 * FXML Controller class
 *
 * @author Rolo
 */
public class FXMLUserViewController implements Initializable {
    
    private User currentUser;
    @FXML Label test;
    @FXML Button logoutButton;
    
    public void changeScreenButtonPushed(ActionEvent e) throws IOException{
    Parent adminViewParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
    Scene adminViewScene  = new Scene(adminViewParent);
        
    Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
       
    window.setScene(adminViewScene);
    window.show();
    //will add lastlogin code here
    java.sql.Date sqlDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
    currentUser.setLastLogin(sqlDate);
    System.out.println(currentUser.getLastLogin().toString());
    //still need to fix update function in service file
}
    /**
     * Initializes the controller class.
     */
    public void initUser(User user){
        this.currentUser = user;
        test.setText("Hello, " + currentUser.getFirstName() + "!");
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
