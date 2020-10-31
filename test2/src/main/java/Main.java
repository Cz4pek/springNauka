import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        DB bazka = null;
        try {
            bazka = new DB();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        bazka.insert("Słowacki");
    }
}
