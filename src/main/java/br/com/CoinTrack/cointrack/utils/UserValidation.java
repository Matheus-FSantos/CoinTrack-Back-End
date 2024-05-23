package br.com.CoinTrack.cointrack.utils;

import br.com.CoinTrack.cointrack.dtos.UserPutRequestDTO;
import br.com.CoinTrack.cointrack.dtos.UserRequestDTO;
import br.com.CoinTrack.cointrack.exceptions.specializations.InvalidFields;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.List;

public class UserValidation {

    public static void validation(UserRequestDTO body) throws InvalidFields {
        List<String> messages = new ArrayList<String>();

        UserValidation.nameValidation(messages, body.name());
        UserValidation.emailValidation(messages, body.email());
        UserValidation.passwordValidation(messages, body.password());

        if(!messages.isEmpty())
            throw new InvalidFields(messages, "Invalid Fields.");
    }

    public static void validationWithoutEmail(UserPutRequestDTO body) throws InvalidFields {
        List<String> messages = new ArrayList<String>();

        UserValidation.nameValidation(messages, body.name());
        UserValidation.passwordValidation(messages, body.password());

        if(!messages.isEmpty())
            throw new InvalidFields(messages, "Invalid Fields.");
    }

    public static void nameValidation(List<String> messages, String name) throws InvalidFields {
        if(name == null)
            messages.add("The Name field cannot be null.");
        else
            if(name.length() > 60 || name.length() < 4)
                messages.add("The Name field must have between 4 and 60 characters.");
    }

    public static void passwordValidation(List<String> messages, String password) {
        if(password == null)
            messages.add("The Password field cannot be null.");
        else
            if(password.length() < 4 || password.length() > 120)
                messages.add("The Password field must have between 4 and 60 characters.");
    }

    public static void emailValidation(List<String> messages, String email) {
        if(email == null)
            messages.add("The E-Mail field cannot be null.");
        else {
            if(email.length() < 5 || email.length() > 120)
                messages.add("The E-Mail field must have between 5 and 60 characters.");
            else {
                try {
                    InternetAddress emailAddr = new InternetAddress(email);
                    emailAddr.validate();
                } catch (AddressException exception) {
                    messages.add("The E-Mail field is invalid.");
                }
            }
        }
    }

}
