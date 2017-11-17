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

                //--------------Create Tables and add data ----------
//            String string0 = "create table test10000_200 (iid INT,id VARCHAR(12),years VARCHAR(4),stint VARCHAR(5),team VARCHAR(5),lg VARCHAR(3),g VARCHAR(5),ab VARCHAR(5),r VARCHAR(5),h VARCHAR(5),X2b VARCHAR(5),X3b VARCHAR(5),hr VARCHAR(5),rbi VARCHAR(5),sb VARCHAR(5),cs VARCHAR(5),bb VARCHAR(5),so VARCHAR(5),ibb VARCHAR(3),hbp VARCHAR(3),sh VARCHAR(3),sf VARCHAR(3),gidp  VARCHAR(3))";
//            PreparedStatement pp0 = con.prepareStatement(string0);
//            pp0.execute();
//            pp0.close();
//            String string = "CALL SYSCS_UTIL.SYSCS_IMPORT_TABLE ('APP','TEST10000_200','c:\\Users\\Jayan\\Desktop\\db\\200\\test10000_200.csv',',',null,null,0)";
//            PreparedStatement pp = con.prepareStatement(string);
//            pp.execute();
//            pp.close();
//            System.out.println("Success ! ");


//            // ---------- INDEX TEST -------------
//            long totalTime = 0l;
//            String string0 = "CREATE INDEX prime ON TEST2000_200 (iid)";
//            String string1 = "DROP INDEX prime";
//
//            for (int i = 0; i < 100; i++) {
//                PreparedStatement pp = con.prepareStatement(string0);
//
//                long startTime = System.nanoTime();
//                pp.execute();
//                long stopTime = System.nanoTime();
//
//                long elapsedTime = stopTime - startTime;
//                totalTime = elapsedTime + totalTime;
//
//                PreparedStatement pp1 = con.prepareStatement(string1);
//                pp1.execute();
//
//            }
//            System.out.println("Avg time : " + totalTime / 100);
//            System.out.println("Success");
//
            //-----------------------------------------------

            // ------- Range Query -------------

            long totalTime = 0l;
            long sum = 0;
            int outputCount = 0;
            Statement sta = con.createStatement();

            ResultSet res = sta.executeQuery("SELECT * FROM TEST2000_1");
            while (res.next()) {
                no_of_rows++;
                int aaa = res.getInt("iid");
                sum = sum + aaa;
            }
            res.close();

            long avg = sum / no_of_rows;
            long ad = avg / 2;
            long q1 = avg - ad;
            long q3 = avg + ad;
           // System.out.println(q1 +" "+q3+" "+avg);
            for (int i = 0; i < 100; i++) {
                outputCount=0;
                long startTime = System.nanoTime();
                ResultSet res1 = sta.executeQuery("SELECT iid FROM TEST2000_1 WHERE iid<=" + q3 + " AND iid>=" + q1);
                long stopTime = System.nanoTime();
                long elapsedTime = stopTime - startTime;
                totalTime = elapsedTime + totalTime;
                while (res1.next()) {
                    outputCount++;
                    //System.out.println(res1.getInt("iid"));
                }
                res1.close();
            }
            sta.close();
            System.out.println("Avg Time : " + totalTime / 100);
            System.out.println("OutPut Count : " + outputCount);
            System.out.println("Total Count : " + no_of_rows);
            System.out.println("Success");
            //----------------------------------------------------------


            con.close();
        } catch (SQLException e) {
            System.out.println("SQL exception occured" + e);
        }
    }
}