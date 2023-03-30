
import java.sql.ResultSet;

public class withdraw {

    public String wintdrawnmethod(String id, int subamount,String datetime) {
        int modifamou;
        String str="\n\n\n        ERROR IN FETCHING\n " +
                "                   ACCOUNT DETAILS";
        try {
            ResultSet result = connection_mysql.connectToDB("SELECT AMOUNT FROM DETAIL WHERE ACCOUNT_NO=" + id + ";");

            assert result != null;
            result.next();

            String amount = result.getString(1);
            if(subamount<Integer.parseInt(amount)) {

                modifamou = Integer.parseInt(amount) - subamount;


                connection_mysql.connectToDB("UPDATE DETAIL SET AMOUNT=" + modifamou + " WHERE ACCOUNT_NO=" + id + ";", 0);

                str = "\n\n\n\n      Account No.: XXXXXXXX"+id.substring(8)+"\n\n\n\n      WITHDRAWAL AMOUNT: "+subamount+
                      "\n\n      BALANCE: "+modifamou+"\n\n\n            YOU CAN REMOVE YOUR CARD OR CLICK CONTINUE";

                connection_mysql.connectToDB("INSERT INTO TRANSACTION VALUES("+id+","+"\""+datetime.substring(0,11)+"\""+","+"\""+datetime.substring(datetime.length()-11)+"\""+","+amount+","+subamount+","+0+","+modifamou+");",0);

            }
            else {
                str="\n\n\n\n\n\nNOT ENOUGH MONEY\n" +
                        "           Current Bank Balance: "+amount;
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return str;


    }
}
