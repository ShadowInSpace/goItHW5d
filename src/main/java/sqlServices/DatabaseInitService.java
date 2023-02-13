package sqlServices;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInitService {
    public static void main(String[] args) throws IOException, SQLException {
        Connection connection = new Database().getConnection();
        BufferedReader in = new BufferedReader(new FileReader("sql/init_db.sql"));
        Statement stmt = connection.createStatement();
        String str;
        StringBuilder sb = new StringBuilder();
        while ((str = in.readLine()) != null) {
            sb.append(str).append("\n ");
        }
        in.close();
        stmt.execute(sb.toString());
        connection.close();
    }
}
