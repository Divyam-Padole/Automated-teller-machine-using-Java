
import java.sql.ResultSet;

public class balance {
    public String balance_amount(String id) {

        String str = "\n\n\n        ERROR IN FETCHING\n " +
                "                   ACCOUNT DETAILS";
        try {
            ResultSet r = connection_mysql.connectToDB("SELECT AMOUNT FROM DETAIL WHERE ACCOUNT_NO=" + id + ";");
            assert r!=null;
            r.next();
            String ba=r.getString(1);

            str="\n\n\n\n\n  ACCOUNT NO: XXXXXXXX"+id.substring(8)+"\n\n\n"+
                    "  YOUR BANK BALANCE IS "+ba+"\n\n";

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        return str;
    }
}
