package br.com.CoinTrack.cointrack.enums;

public enum TransactionType {
    Saida(1),
    Entrada(2);

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
