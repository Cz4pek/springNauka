import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {

    /**
     * Tutaj należy zdefiniować użytkownika, hasło, adres oraz
     * sterownik do bazy danych z którą zamierzamy się połączyć.
     */
    private final static String DBURL = "jdbc:mysql://127.0.0.1:3306/test";
    private final static String DBUSER = "root";
    private final static String DBPASS = "test";
    private final static String DBDRIVER = "com.mysql.jdbc.Driver";

    //zapytanie SQL
    //parser zapytań SQL dla obiektów klasy Article


    public void execute(String query) {

        try {
            Class.forName(DBDRIVER).newInstance();
            //obiekt tworzący połączenie z bazą danych.
            Connection connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
            //obiekt pozwalający tworzyć nowe wyrażenia SQL
            Statement statement = connection.createStatement();
            statement.executeUpdate(query);

            //zwolnienie zasobów i zamknięcie połączenia
            statement.close();
            connection.close();
        } catch (InstantiationException | IllegalAccessException
                | ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}