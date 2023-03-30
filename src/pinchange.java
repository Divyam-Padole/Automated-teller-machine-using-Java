import java.sql.ResultSet;

public class pinchange {
    public String pinchangedm(String id,int enteredgpin){
         String str="ERROR";
        try {
            connection_mysql.connectToDB("UPDATE DETAIL SET PIN="+enteredgpin+" WHERE ACCOUNT_NO=" + id + ";",0);
            str="\n\n\n\n\n\n\n\n                        YOUR PIN HAS BEEN UPDATED\n\n";

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return str;
    }
}
