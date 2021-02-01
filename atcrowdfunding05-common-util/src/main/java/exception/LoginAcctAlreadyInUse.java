package exception;

public class LoginAcctAlreadyInUse extends RuntimeException{

    private static final long serialVersionUID = -2703719325476853739L;

    public LoginAcctAlreadyInUse() {
    }

    public LoginAcctAlreadyInUse(String message) {
        super(message);
    }

    public LoginAcctAlreadyInUse(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginAcctAlreadyInUse(Throwable cause) {
        super(cause);
    }

    public LoginAcctAlreadyInUse(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
