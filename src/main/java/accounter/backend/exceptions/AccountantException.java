package accounter.backend.exceptions;


public class AccountantException extends Exception {

    public AccountantException() {
        super("Transfer Exception  \n");
    }

    public AccountantException(String message, Exception e) {
        super(message, e);
    }

    public AccountantException(String message) {
        super("TransferException : transfer Exception : " + message);
    }

    public AccountantException(Exception e) {
        super(e);
    }

}
