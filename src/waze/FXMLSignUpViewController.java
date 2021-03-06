/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package waze;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Rolo
 */
public class FXMLSignUpViewController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @FXML Button returnButton;
    @FXML Button addButton;
    @FXML TextField Username;
    @FXML TextField Password;
    @FXML TextField LastName;
    @FXML TextField FirstName;
    @FXML TextField Email;
    @FXML TextField PhoneNo;
    
    public void addUserButtonPushed (ActionEvent e){
    UsersService service1 = new UsersService(new UsersDB());
    if (!Username.getText().equals("") &&  !Password.getText().equals("") && !LastName.getText().equals("") && !FirstName.getText().equals("") && !Email.getText().equals("") && !PhoneNo.getText().equals("")){
        if (isUniqueUsername(Username.getText())){
        service1.addUser(toUser());
        clear();}
        else System.out.println("[ADDING ERROR] Not unique username ");
    }
    else {
        System.out.println("[ADDING ERROR] Missing Credentials ");
        /*
        System.out.println(!Username.getText().equals(""));
        System.out.println(Password.getText());
        System.out.println(FirstName.getText());
        System.out.println(LastName.getText());
        System.out.println(PhoneNo.getText());
        System.out.println(Email.getText());
        */
    }
    
    
}
     public ObservableList<User> getPeople(){
       ObservableList<User> people = FXCollections.observableArrayList();
       
       UsersService service = new UsersService(new UsersDB());
       List <User> Users = service.getAll();
		
       for (User User: Users) {
            people.add(User);
       }
       
       return people;
    }

    private User toUser() {
        User User = new User();
		
	User.setUsername(Username.getText());
	User.setPassword(Password.getText());
	User.setLastName(LastName.getText());
	User.setFirstName(FirstName.getText());
	User.setAvatar(null);
	User.setPhoneNo(PhoneNo.getText());
	User.setEmail(Email.getText());
	User.setLastLogin(null);
	//User.setEmail(email.getText());
	//User.setMobile(mobileno.getText());
		
	return User;
    }
    public void clear(){
        Username.setText("");
        Password.setText("");
        LastName.setText("");
        FirstName.setText("");
        PhoneNo.setText("");
        Email.setText("");
    }
    
    public boolean isUniqueUsername(String userName){
        UsersService service = new UsersService(new UsersDB());
        List <User> Users = service.getAll();
        boolean unique = true;
        
        for (User x: Users) {
            if (x.getUsername().equals(userName))
                unique = false;
       }
        
        return unique;
    }
    
    public void changeScreenButtonPushed(ActionEvent e) throws IOException{
    Parent adminViewParent = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
    Scene adminViewScene  = new Scene(adminViewParent);
        
    Stage window = (Stage)((Node)e.getSource()).getScene().getWindow();
       
    window.setScene(adminViewScene);
    window.show();
}
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
