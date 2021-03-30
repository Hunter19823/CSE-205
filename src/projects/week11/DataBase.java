package projects.week11;

import java.sql.*;

public class DataBase {
    public static void main( String[] args )
    {
        Connection connection = null;
        try{
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/testdb",
                    "postgres",
                    "Password"
            );
            System.out.println("Opened Database Successfully!");
        }catch(ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Catch all Exception occurred: "+e.getClass().getName()+": "+e.getMessage());
        }

        // Create Table
        //createTable(connection);

        // INSERT
        //insert(connection,1,"Paul",23,"Alaska",5645.65);
        //insert(connection,2,"Bob",65,"Michigan",12935.65);
        //insert(connection,3,"Jacob",25,"Arizona",6236.65);
        //insert(connection,4,"George",21,"Arizona",736.65);



        // SELECT
        //select(connection);

        // UPDATE
        //update(connection);

        // DELETE
        delete(connection);


        // Close the connection once we are finished
        try {
            if(connection != null)
                connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createTable(Connection connection)
    {
        Statement statement = null;
        try{
            statement = connection.createStatement();
            String sqlCommand =
                    "CREATE TABLE company("+
                        "ID INT PRIMARY KEY NOT NULL, "+
                        "NAME TEXT NOT NULL, "+
                        "AGE INT NOT NULL, "+
                        "ADDRESS CHAR(50), "+
                        "SALARY REAL"+
                    ")";
            statement.executeUpdate(sqlCommand);
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Catch all Exception occurred: "+e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
        System.out.println("Table Created...");
    }

    public static void insert(Connection connection, int id, String name, int age, String address, double salary)
    {
        Statement statement = null;
        try{
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            String sqlCommand =
                    "INSERT INTO company("+
                        "ID, "+
                        "NAME, "+
                        "AGE, "+
                        "ADDRESS, "+
                        "SALARY"+
                    ") ";
            sqlCommand += String.format("VALUES( %d, '%s', %d, '%s', %.2f);",id,name,age,address,salary);
            statement.executeUpdate(sqlCommand);
            statement.close();
            connection.commit();
            System.out.println("Data Inserted...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Catch all Exception occurred: "+e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }

    public static void select(Connection connection)
    {

        Statement statement = null;
        try{
            statement = connection.createStatement();
            String sqlCommand =
                    "SELECT * FROM company;";
            ResultSet resultSet = statement.executeQuery(sqlCommand);
            while(resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String address = resultSet.getString("address");
                float salary = resultSet.getFloat("salary");

                System.out.println(String.format("ID = %d\n NAME = %s\n AGE = %d\n ADDRESS = %s\n SALARY = %.2f \n",id,name,age,address,salary));
            }
            resultSet.close();
            statement.close();
            System.out.println("Data Selected...");
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Catch all Exception occurred: "+e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }

    public static void update(Connection connection)
    {
        Statement statement = null;
        try{
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            String sqlCommand =
                    "UPDATE company set SALARY = 30000.00 where ID = 1;";
            statement.executeUpdate(sqlCommand);
            connection.commit();
            System.out.println("Data Updated...");


            select(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Catch all Exception occurred: "+e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }

    public static void delete(Connection connection)
    {
        Statement statement = null;
        try{
            connection.setAutoCommit(false);
            statement = connection.createStatement();
            String sqlCommand =
                    "DELETE from company where ID = 1;";
            statement.executeUpdate(sqlCommand);
            connection.commit();
            System.out.println("Data Deleted...");


            select(connection);
        } catch (SQLException e) {
            e.printStackTrace();
            System.exit(0);
        } catch (Exception e) {
            e.printStackTrace();
            System.err.println("Catch all Exception occurred: "+e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }
    }
}
