package derby;


import java.sql.*;

public class DerbyConnection {
    public static void main(String[] args) {
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found " + e);
        }
        System.out.println("JDBC Class found");
        int no_of_rows = 0;

        try {
            Connection con = DriverManager.getConnection("jdbc:derby:APP;create=true");
//            String ddd= "SELECT * FROM BASEDATA";
            // String ddd= "CREATE TABELE  * FROM BASEDATA";

//
//           String string = "create table basedata (iid INT,id VARCHAR(12),years VARCHAR(4),stint VARCHAR(5),team VARCHAR(5),lg VARCHAR(3),g VARCHAR(5),ab VARCHAR(5),r VARCHAR(5),h VARCHAR(5),X2b VARCHAR(5),X3b VARCHAR(5),hr VARCHAR(5),rbi VARCHAR(5),sb VARCHAR(5),cs VARCHAR(5),bb VARCHAR(5),so VARCHAR(5),ibb VARCHAR(3),hbp VARCHAR(3),sh VARCHAR(3),sf VARCHAR(3),gidp  VARCHAR(3))";
//            String string = "CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE ('APP','BASEDATA','c:\\Users\\Jayan\\Desktop\\basedata.csv',',',null,null,0)";

//            // ---------- INDEX TEST -------------
//            long totalTime=0l;
//            String string0 = "CREATE INDEX prime ON BASEDATA (iid)";
//            String string1 = "DROP INDEX prime ";
//
//            for (int i = 0; i <10 ; i++) {
//
//                PreparedStatement pp = con.prepareStatement(string0);
//                long startTime = System.nanoTime();
//                pp.execute();
//                long stopTime = System.nanoTime();
//
//                long elapsedTime = stopTime - startTime;
//                totalTime=elapsedTime+totalTime;
//
//                PreparedStatement pp1 = con.prepareStatement(string1);
//                pp1.execute();
//
//            }
//
//            System.out.println(totalTime);
//            System.out.println(totalTime/10);
//            System.out.println("Success");

            // ------- Range Query -------------
            Statement sta = con.createStatement();
            ResultSet res = sta.executeQuery("SELECT * FROM BASEDATA");
            while (res.next()) {
                no_of_rows++;
            }
            while (res.next()) {
                System.out.println(
                        "  "+res.getInt("ID")
                                + ", "+res.getString("StreetName")
                                + ", "+res.getString("City"));
            }

            res.close();


//            Statement sta = con.createStatement();
//            ResultSet res = sta.executeQuery("SELECT * FROM BASEDATA");
//            while (res.next()) {
//                no_of_rows++;
//            }
//            res.close();


        } catch (SQLException e) {
            System.out.println("SQL exception occured" + e);
        }
    }
}