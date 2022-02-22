package TesT.test;


import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class SqlConnection {
    Properties properties=new Properties();

    InputStream inputStream=null;

    public SqlConnection(){
        inputStream=SqlConnection.class.getClassLoader().getResourceAsStream("mysql.properties");

        try {
            properties.load(inputStream);

            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String driver=properties.getProperty("driver");
        String url=properties.getProperty("url");
        String username=properties.getProperty("username");
        String password=properties.getProperty("password");

        try {
            Class.forName(driver);
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();
            String s1="select * from department";
            ResultSet resultSet = statement.executeQuery(s1);
            while(resultSet.next()) {
                System.out.println(resultSet.getString("id"));
                System.out.println("---------");
                //System.out.println(resultSet.getBigDecimal("id"));//java.math.BigDecimal (具有完整有效位數)
            }

            System.out.println(resultSet);

            resultSet.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) throws SQLException, ClassNotFoundException, IOException {
        new SqlConnection();

    }

}
