package forms;/* Created by Oussama on 01/05/2017. */

import model.Doctor;
import mongo.Connection;

import java.util.ArrayList;
import java.util.List;

public class AuthentificationForm {

    String pseudo;
    String password;

    public AuthentificationForm(String pseudo, String password) {
        this.pseudo = pseudo;
        this.password = password;
    }
    public Doctor getDoctor(){
        return Connection.getDoctor(this.pseudo, this.password);
    }
}
