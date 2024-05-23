package br.com.CoinTrack.cointrack.enums;

import br.com.CoinTrack.cointrack.exceptions.specializations.InvalidTransactionType;

public enum TransactionType {
    Pix(1),
    Credito(2),
    Debito(3);

    private final int code;

    private TransactionType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TransactionType valueOf(int code) {
        for(TransactionType value : TransactionType.values()) {
            if(code == value.getCode()) {
                return value;
            }
        }

        return null;
    }
}
