package br.com.CoinTrack.cointrack.utils;

import br.com.CoinTrack.cointrack.enums.TransactionType;

import java.util.List;

public class TransactionTypeValidation {

    public static void validation(List<String> messages, Integer type) {
        if(TransactionType.valueOf(type) == null)
            messages.add("Transaction type is invalid, valid values: (1) Saida, (2) Entrada");
    }

}
