package forms;/* Created by Oussama on 01/05/2017. */

import java.util.ArrayList;
import java.util.List;

public class AuthentificationForm {

    String pseudo;
    String password;

    public AuthentificationForm(String pseudo, String password) {

        this.pseudo = pseudo;
        this.password = password;
    }
    public boolean isDoctor(){

        if(pseudo.toLowerCase().equals("oussama") && password.equals("oussama")){
            return true;
        }
        return false;
    }
}
