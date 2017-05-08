package forms;/* Created by Oussama on 01/05/2017. */

import model.Doctor;

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
        if(this.pseudo.equals("ouss") && this.password.equals("ouss")){
            return new Doctor("1");
        }
        return null;
    }
}
