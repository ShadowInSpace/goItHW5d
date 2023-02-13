package sqlServices;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


import static java.sql.Date.valueOf;

public class DatabasePopulateService {
    private static final String[][] workers = {
            {"Rostyslav","1996-02-03","Trainee","100"},
            {"Svyryd","1912-12-12","Middle","1300"},
            {"John", "1916-03-08","Senior","7500"},
            {"Morningstar","1917-11-17","Senior","50000"},
            {"Sofiya","1930-09-18","Middle","3400"},
            {"Taras","1935-08-18","Junior","1100"},
            {"Greg", "1935-09-03","Junior","900"},
            {"Tomas","1987-02-28","Trainee","400"},
            {"Petro","2002-01-24","Junior","950"},
            {"Eve","1902-12-08","Middle","2700"}
    };
    private static final String[] clients = {"Den", "Stiven", "Mery", "Anatoliy", "Frodo"};
    private static final String[][] projects ={
            {"2", "2023-01-05", "2023-02-06"},
            {"3", "2023-04-14", "2024-11-07"},
            {"4", "2023-10-17", "2024-01-05"},
            {"3", "2023-04-14", "2024-11-07"},
            {"1", "2022-05-07", "2022-10-08"},
            {"1", "2023-01-29", "2023-02-14"},
            {"2", "2023-02-24", "2023-04-27"},
            {"3", "2022-11-02", "2025-07-05"},
            {"5", "2023-05-27", "2024-03-15"},
            {"2", "2022-12-21", "2023-10-25"}
    };
    private static final int[][] projectWorkerRelation=
            {
            {1, 1},{2, 2},{3, 3},{4, 1},{5, 5},{6, 6},{ 7, 7},{8, 8},{9, 9},{10, 10},{1, 3},{1, 2},{4, 5},{2, 6},{3, 8},{6, 10},{9, 4},{ 7, 4}
            };

    public static void main(String[] args) {
        try(Connection connection = new Database().getConnection()) {
            feedWorkers(connection);
            feedClients(connection);
            feedProjects(connection);
            feedProjectWorkerRelation(connection);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void feedWorkers(Connection connection){
        String query = "INSERT INTO hw5d.worker (NAME, BIRTHDAY, LEVEL, SALARY) VALUES (?,?,?,?);";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            for (int i = 0; i < 10; i++) {

                statement.setString(1, workers[i][0]);
                statement.setDate(2, valueOf(workers[i][1]));
                statement.setString(3, workers[i][2]);
                statement.setInt(4,(int)Integer.parseInt(workers[i][3]));

                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    private static void feedClients(Connection connection){
        String query = "INSERT INTO hw5d.client (NAME) VALUES (?);";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            for (int i = 0; i < 5; i++) {
                statement.setString(1, clients[i]);
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    private static void feedProjects(Connection connection){
        String query = "INSERT INTO hw5d.project (CLIENT_ID, START_DATA, FINISH_DATA) VALUES (?,?,?);";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            for (int i = 0; i < 10; i++) {

                statement.setInt(1,(int)Integer.parseInt(projects[i][0]));
                statement.setDate(2, valueOf(projects[i][1]));
                statement.setDate(3, valueOf(projects[i][2]));

                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private static void feedProjectWorkerRelation(Connection connection){
        String query = "INSERT INTO hw5d.project_worker (PROJECT_ID, WORKER_ID) VALUES (?,?);";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            for (int i = 0; i < 18; i++) {
                for (int j = 0; j < 2; j++) {
                    statement.setInt(j+1,projectWorkerRelation[i][j]);
                }
                statement.addBatch();
            }
            statement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
