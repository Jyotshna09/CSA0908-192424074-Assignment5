import java.io.Serializable;
import java.sql.Connection;

public class Resident implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;
    private String registerNumber;
    private transient String password;
    private transient Connection connection;

    public Resident(String name, String registerNumber, String password) {
        this.name = name;
        this.registerNumber = registerNumber;
        this.password = password;
    }

    @Override
    public String toString() {
        return name + " | " + registerNumber;
    }
}