

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class connection_mysql {


    public static ResultSet connectToDB(String qry)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM?useTimezone==true&serverTimezone=UTC","root","pk1234");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            return stmt.executeQuery(qry);
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }

        return  null;
    }

    public static void connectToDB(String qry,int i)
    {
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ATM?useTimezone==true&serverTimezone=UTC","root","pk1234");
            Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
            stmt.executeUpdate(qry);
        }
        catch (Exception e)
        {
            e.printStackTrace();

        }


    }

}
