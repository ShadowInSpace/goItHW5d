package sqlServices;

import java.time.LocalDate;
import java.util.Date;

public class DatabasePopulateService {
    private final String[][] workers = {
            {"Rostyslav","1996-02-03","Trainee"},
            {"Svyryd","1912-12-12","Middle"},
            {"John", "1916-03-08","Senior"},
            {"Morningstar","1917-11-17","Senior"},
            {"Sofiya","1930-09-18","Middle"},
            {"Taras","1935-08-18","Junior"},
            {"Greg", "1935-09-03","Junior"},
            {"Tomas","1987-02-28","Trainee"},
            {"Petro","2002-01-24","Junior"},
            {"Eve","1902-12-08","Middle"}};
    private final int[] workersBirthday = {100,1300,7500, 50000,3400,1100,900,400,950,2700};
    private final String[][] projects ={
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
    private final int[][] projectWorkerRelation=
            {
            {1, 1},{2, 2},{3, 3},{4, 1},{5, 5},{6, 6},{ 7, 7},{8, 8},{9, 9},{10, 10},{1, 3},{1, 2},{4, 5},{2, 6},{3, 8},{6, 10},{9, 4},{ 7, 4}
            };

    public static void main(String[] args) {

    }
}
