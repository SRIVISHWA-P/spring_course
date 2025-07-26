import java.sql.*;
/*
 * steps
 * 1.import package
 * 2.load and register
 * 3.create connection
 * 4.create statement
 * 5.execute statement
 * 6.process and results
 * 7.close
 */
public class DemoJdbc{
    public static void main(String[] args) throws Exception {
        //loading the driver
        Class.forName("org.postgresql.Driver");
        System.out.println("Class Loaded");

        Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/demo","postgres","9090");
        System.out.println("Successfully connected to the database");

//        Statement st =con.createStatement();
//        ResultSet rs = st.executeQuery("select*from student");
//        System.out.println("ID"+"\t"+"age"+"\t"+"name");
//        while(rs.next()) {
////            System.out.println(rs.getString("name")+"\t"+rs.getInt("age"));
//            System.out.println(rs.getInt(1)+"\t"+rs.getInt(2)+"\t"+rs.getString(3));
//            if(rs.isLast())
//                break;
//        }

        String name = "ali";
        int age = 26;
        int id = 22;
        String sql= "insert into student values(?,?,?)";
        PreparedStatement st = con.prepareStatement(sql);
        st.setInt(1,id);
        st.setInt(2,age);
        st.setString(3,name);
        st.execute();
        con.close();
    }
}
