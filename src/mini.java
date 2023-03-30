
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class mini {
    public String mini_screen(String id)
    {
        String str="\n\n\n        ERROR IN FETCHING\n " +
                "                   ACCOUNT TRANSACTIONS";
        int count=0;
        try{
            ResultSet result = connection_mysql.connectToDB("SELECT * FROM TRANSACTION WHERE ACCOUNT_NO=" + id + " ORDER BY TR_DATE DESC;");
            assert result != null;
            result.next();
            str="\n   MINI STATEMENT\n" +
                    "   ACCOUNT NO: XXXXXXXX"+id.substring(8)+"\n-----------------------------------------------------------------------------------\n\n";
            String temp=str;
            do{

                    String date = result.getString(2);
                    String time= result.getString(3);
                    String before_amt = result.getString(4);
                    String credit = result.getString(5);
                    String deposit = result.getString(6);
                    String after_amt = result.getString(7);

                    if (Integer.parseInt(deposit) == 0) {
                        str = str + "   DATE                         " + date + "\n" +
                                "   TIME:                        " +time+"\n"+
                                "   BEFORE AMOUNT:     " + before_amt + "\n" +
                                "   CREDIT:                     " + credit + "\n" +
                                "   AFTER AMOUNT:       " + after_amt + "\n----------------------------------------------------------------------------------------\n";
                    } else {

                        str = str + "   DATE                          " + date + "\n" +
                                "   TIME:                         " +time+"\n"+
                                "   BEFORE AMOUNT:      " + before_amt + "\n" +
                                "   DEPOSIT:                    " + deposit + "\n" +
                                "   AFTER AMOUNT:         " + after_amt + "\n----------------------------------------------------------------------------------------\n";
                    }
                    count--;

            }while (result.next()&&count<3);

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return str;
    }

}
