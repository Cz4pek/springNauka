public class main {
    public static void main(String[] args) {
        DB bazka = new DB();
        bazka.execute("INSERT INTO student (imie)\n" +
                "VALUES ('Mickiewicz')");
    }
}
