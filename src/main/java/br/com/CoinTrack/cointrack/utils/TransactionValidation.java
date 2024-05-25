package br.com.CoinTrack.cointrack.utils;

import br.com.CoinTrack.cointrack.dtos.TransactionPutRequestDTO;
import br.com.CoinTrack.cointrack.dtos.TransactionRequestDTO;
import br.com.CoinTrack.cointrack.exceptions.specializations.InvalidFields;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class TransactionValidation {

    public static void validation(TransactionRequestDTO transaction) throws InvalidFields {
        List<String> messages = new ArrayList<String>();

        TransactionValidation.uuidValidation(messages, transaction.userId());
        TransactionValidation.nameValidation(messages, transaction.name());
        TransactionValidation.totalValidation(messages, transaction.total());
        TransactionValidation.dateValidation(messages, transaction.date());
        TransactionMethodValidation.validation(messages, transaction.method());
        TransactionTypeValidation.validation(messages, transaction.type());

        if(!messages.isEmpty())
            throw new InvalidFields(messages, "Invalid Fields.");
    }

    public static void validation(TransactionPutRequestDTO transaction) throws InvalidFields {
        List<String> messages = new ArrayList<String>();

        TransactionValidation.nameValidation(messages, transaction.name());
        TransactionValidation.totalValidation(messages, transaction.total());
        TransactionValidation.dateValidation(messages, transaction.date());
        TransactionMethodValidation.validation(messages, transaction.method());
        TransactionTypeValidation.validation(messages, transaction.type());

        if(!messages.isEmpty())
            throw new InvalidFields(messages, "Invalid Fields.");
    }

    public static void uuidValidation(List<String> messages, UUID id) {
        if(id == null)
            messages.add("The User Id field cannot be null.");
    }

    public static void nameValidation(List<String> messages, String name) {
        if(name == null)
            messages.add("The Name field cannot be null.");
        else
            if(name.length() > 60 || name.length() < 4)
                messages.add("The name field must have between 4 and 60 characters.");
    }

    public static void totalValidation(List<String> messages, BigDecimal total) {
        if(total == null)
            messages.add("The Total field cannot be null.");
        else
            if(total.signum() < 0)
                messages.add("The Total field must be greater than R$0.");
    }

    public static void dateValidation(List<String> messages, String date) {
        if(date == null)
            messages.add("The Date field cannot be null.");
        else
            DateEntityMapper.validate(messages, date);
    }

}
