package exception;

public class LoginAcctAlreadyInUseForUpdate extends RuntimeException {

    private static final long serialVersionUID = -297201800087848098L;

    public LoginAcctAlreadyInUseForUpdate() {
    }

    public LoginAcctAlreadyInUseForUpdate(String message) {
        super(message);
    }

    public LoginAcctAlreadyInUseForUpdate(String message, Throwable cause) {
        super(message, cause);
    }

    public LoginAcctAlreadyInUseForUpdate(Throwable cause) {
        super(cause);
    }

    public LoginAcctAlreadyInUseForUpdate(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
