package br.com.CoinTrack.cointrack.enums;

public enum TransactionMethod {
    Pix(1),
    Credito(2),
    Debito(3);

    private final int code;

    private TransactionMethod(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static TransactionMethod valueOf(int code) {
        for(TransactionMethod value : TransactionMethod.values()) {
            if(code == value.getCode()) {
                return value;
            }
        }

        return null;
    }
}
