import java.sql.*;

public class DB {

    /**
     * Tutaj należy zdefiniować użytkownika, hasło, adres oraz
     * sterownik do bazy danych z którą zamierzamy się połączyć.
     */
    private final static String DBURL = "jdbc:mysql://127.0.0.1:3306/bazka";
    private final static String DBUSER = "root";
    private final static String DBPASS = "test";
    private final static String DBDRIVER = "com.mysql.cj.jdbc.Driver";
    Connection connection = DriverManager.getConnection(DBURL, DBUSER, DBPASS);
    PreparedStatement ps = connection.prepareStatement("INSERT INTO student (imie) VALUES (?)");

    public DB() throws SQLException {
    }



    public void insert(String imie) {

        try {
            Class.forName(DBDRIVER).newInstance();
            //obiekt tworzący połączenie z bazą danych.
            //obiekt pozwalający tworzyć nowe wyrażenia SQL
//            Statement statement = connection.createStatement();
//            statement.executeUpdate(query);
            ps.setString(1, imie);
            ps.execute();
            ps.close();
            //zwolnienie zasobów i zamknięcie połączenia
            //statement.close();
            connection.close();
        } catch (InstantiationException | IllegalAccessException
                | ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}