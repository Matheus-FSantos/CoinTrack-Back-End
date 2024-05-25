package br.com.CoinTrack.cointrack.utils;

import br.com.CoinTrack.cointrack.enums.TransactionMethod;

import java.util.List;

public class TransactionMethodValidation {

    public static void validation(List<String> messages, Integer type) {
        if(TransactionMethod.valueOf(type) == null)
            messages.add("Transaction method is invalid, valid values: (1) Pix, (2) Credito, (3) Debito");
    }

}
