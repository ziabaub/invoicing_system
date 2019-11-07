package accounter.backend.exceptions;

import java.sql.SQLException;

public class DAOException extends Exception {

    public DAOException(String message, SQLException e) {
        super(message ,e );
    }

    public DAOException(String message, InterruptedException e) {
        super(message,e);
    }
}
