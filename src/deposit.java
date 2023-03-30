

import java.sql.ResultSet;

public class deposit {

    public String deposits(String id,int addedlamount,String datetime){
        int modifamou;
        String str="\n\n\n        ERROR IN FETCHING\n " +
                "                   ACCOUNT DETAILS";
        try {
            ResultSet result = connection_mysql.connectToDB("SELECT AMOUNT FROM DETAIL WHERE ACCOUNT_NO=" + id + ";");

            assert result != null;
            result.next();

            String amount = result.getString(1);
            if(addedlamount<50000) {

                modifamou = Integer.parseInt(amount) + addedlamount;


                connection_mysql.connectToDB("UPDATE DETAIL SET AMOUNT=" + modifamou + " WHERE ACCOUNT_NO=" + id + ";", 0);

                str = "\n\n\n\n      Account No.: XXXXXXXX"+id.substring(8)+"\n\n\n\n      DEPOSITION AMOUNT: "+addedlamount+
                "\n\n      BALANCE: "+modifamou+"\n\n\n            YOU CAN REMOVE YOUR CARD OR CLICK CONTINUE";


                connection_mysql.connectToDB("INSERT INTO TRANSACTION VALUES("+id+","+"\""+datetime.substring(0,11)+"\""+","+"\""+datetime.substring(datetime.length()-11)+"\""+","+amount+","+0+","+addedlamount+","+modifamou+");",0);

            }

            else {
                str="\n\n\n\n\n\n       MONEY LIMIT EXCEED\n\n";
            }

        }
        catch (Exception e) {
            e.printStackTrace();
        }

        return str;


    }
}
