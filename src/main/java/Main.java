import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

//Тестовое задание выполнено

public class Main {
    public static void main(String[] args)
    {
        // ввести следующие данные
        String url = "";
        String user = "";
        String password = "";

        try {
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT DISTINCT DEPARTMENT, SUM(SALARY) AS SALARY FROM EMPLOYEES GROUP BY DEPARTMENT");

            while(resultSet.next()){
                String department = resultSet.getString("DEPARTMENT");
                String sumSalary = resultSet.getString("SALARY");

                System.out.println(department + ": " + sumSalary);
            }
            resultSet.close();
            statement.close();
            connection.close();

        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}
