package accounter.backend.exceptions;

public class ServiceException extends Exception {

    public ServiceException(String message, DAOException e) {
        super(message, e);
    }
}
