package library.assistant.database;

import java.sql.*;

public class DatabaseHandler {

    private static final String DB_URL = "jdbc:derby:database;create=true";
    private static DatabaseHandler handler;
    private static Connection conn = null;
    private static Statement stm = null;

    public DatabaseHandler() {
        createConnection();
        setupBookTable();
    }

    void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
            conn = DriverManager.getConnection(DB_URL);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void setupBookTable() {
        String TABLE_NAME = "BOOK";
        try {
            stm = conn.createStatement();
            DatabaseMetaData dbm = conn.getMetaData();
            ResultSet tables = dbm.getTables(null, null, TABLE_NAME.toUpperCase(), null);
            if (tables.next()) {
                System.out.println("Table " + TABLE_NAME + " already exists. Ready for go!");
            } else {
                stm.execute("CREATE TABLE " + TABLE_NAME + "("
                        + "  id varchar(200) primary key ,\n"
                        + "  title varchar(200) ,\n"
                        + "  author varchar(200) ,\n"
                        + "  publisher varchar(100) ,\n"
                        + "  isAval boolean default true"
                        + "  )");
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage() + "... setupDatabase");
        }
    }


}
