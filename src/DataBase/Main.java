package DataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <div style="font-size:40px;"> JDBC</div>
 * <div style="font-size:12px; color: green">(англ. Java DataBase Connectivity — соединение с базами данных на Java)</div>
 * <p>
 * <div style="font-size:12px; color: red">Для использования JDBC необходимо вручную загрузить библиотеку.<br>
 * И подключить в Project Structure -> Libraries
 * </div>
 * Для соединения с БД необходимо использовать класс Connection пакета java.sql.<br>
 * После установления соединения можно выполнять различные SQL-запросы и получать результаты их обработки сервером.<br>
 * Приложение может открыть одно или несколько соединений с одной или несколькими различными СУБД.<br>
 *<br>
 * Statement используется для выполнения SQL-запросов. Существует три типа класса Statement,<br>
 * которые являются как бы контейнерами для выполнения SQL-выражений через установленное соединение:<br>
 * - Statement, базовый;<br>
 * - PreparedStatement, наследующий от Statement;<br>
 * - CallableStatement, наследующий от PreparedStatement.<br>
 * <br>
 * <div style="font-size:12px">Все классы специализируются для выполнения различных типов запросов:</div>
 * <div style="font-size:12px; color: green"> Statement </div>
 * Предназначен для выполнения простых SQL-запросов без параметров; содержит базовые методы для выполнения запросов и извлечения результатов.<br>
 * <div style="font-size:12px; color: green"> PreparedStatement </div>
 * используется для выполнения SQL-запросов с или без входных параметров; добавляет методы управления входными параметрами.<br>
 * <div style="font-size:12px; color: green"> CallableStatement </div>
 * Используется для вызовов хранимых процедур; добавляет методы для манипуляции выходными параметрами.<br>
 * */
public class Main {
    public static void main(String[] args) {
        String server = "localhost";
        String port = "5432";
        String DBName = "mylessonsjava";
        String URL = "jdbc:postgresql://"+server+":"+port+"/"+DBName;
        String user_name = "postgres";
        String password = "852456";

        try(Connection connection = DriverManager.getConnection(URL,user_name,password);
            Statement statement = connection.createStatement()){

            if(!connection.isClosed()) System.out.println("[INFO] Подключение прошло успешно!");
            //statement.execute("INSERT INTO bicycle (make, type, price) VALUES ('Stels', 'H-200', 13500.00)");
            int count_update_row = statement.executeUpdate("update bicycle set price = 13650.00 where id = 4;");
            System.out.println("Кол-во обновлённых строк = " + count_update_row);
            ResultSet resultSet =  statement.executeQuery("SELECT * FROM bicycle;");

            List<Bicycle> listBicycle = new ArrayList<>();
            while (resultSet.next()){
                Bicycle bicycle = new Bicycle();
                bicycle.setId(resultSet.getInt("id"));
                bicycle.setMake(resultSet.getString("make"));
                bicycle.setType(resultSet.getString("type"));
                bicycle.setPrice(resultSet.getFloat("price"));
                listBicycle.add(bicycle);
            }

            listBicycle.forEach(System.out::println);

            /*statement.addBatch("INSERT INTO bicycle (make, type, price) VALUES ('Stels', 'H-300', 19500.00)");
            statement.addBatch("INSERT INTO bicycle (make, type, price) VALUES ('Stels', 'H-400', 24500.00)");
            statement.addBatch("INSERT INTO bicycle (make, type, price) VALUES ('Stels', 'H-500', 30000.00)");

            int i[] = statement.executeBatch();
            System.out.println(Arrays.toString(i));*/


            String GET_EMPLOYEE = "select * from bicycle where id = ?;";
            PreparedStatement preparedStatement = connection.prepareStatement(GET_EMPLOYEE);
            preparedStatement.setInt(1, 1);

            resultSet = preparedStatement.executeQuery();

            System.out.println("\n\n");
            while (resultSet.next()){
                Bicycle bicycle = new Bicycle();
                bicycle.setId(resultSet.getInt("id"));
                bicycle.setMake(resultSet.getString("make"));
                bicycle.setType(resultSet.getString("type"));
                bicycle.setPrice(resultSet.getFloat("price"));
                System.out.println(bicycle);
            }



        }
        catch (Exception ex){
            System.out.println("[ERROR] Ошибка при работе с БД!");
            ex.printStackTrace();
        }
    }
}
