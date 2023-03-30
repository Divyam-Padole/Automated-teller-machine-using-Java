
import java.awt.*;
import java.sql.ResultSet;

public class detail {
    public String detail_screen(String id)
    {

        String str="\n\n\n        ERROR IN FETCHING\n " +
                "                   ACCOUNT DETAILS";
        String bank = "---";
        try {
            ResultSet result = connection_mysql.connectToDB("SELECT * FROM DETAIL WHERE ACCOUNT_NO=" + id + ";");
            assert result != null;
            result.next();
            str=null;
            String bank_code = result.getString(1);
            switch (bank_code) {
                case "111111" -> bank = "Axis Bank";
                case "101010" -> bank = "State Bank of India";
                case "123123" -> bank = "HDFC Bank";
                case "121212" -> bank = "ICICI Bank";
            }
            String account_no=result.getString(2);
            String name = result.getString(4);
            String mobile= result.getString(5);
            String amount = result.getString(6);
            str="\n\n                            ACCOUNT DETAILS\n\n" +
                    "    Bank name:   "+bank+"\n\n" +
                    "    Account No.: XXXXXXXX"+account_no.substring(8)+"\n\n" +
                    "    Name:           "+name+"\n\n" +
                    "    Mobile No.:   "+mobile+"\n\n" +
                    "    Amount:        "+amount+"\n" +
                "\n\n\n            YOU CAN REMOVE YOUR CARD OR CLICK CONTINUE";

            return str;
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return str;
    }
}
