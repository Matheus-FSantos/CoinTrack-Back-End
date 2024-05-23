package br.com.CoinTrack.cointrack.utils;

import br.com.CoinTrack.cointrack.enums.TransactionType;
import br.com.CoinTrack.cointrack.exceptions.specializations.InvalidFields;

import java.util.List;

public class TransactionTypeValidation {

    public static void validation(List<String> messages, Integer type) {
        if(TransactionType.valueOf(type) == null)
            messages.add("Transaction type is invalid, valid values: (1) Pix, (2) Credito, (3) Debito");
    }

}
