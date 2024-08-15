import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SQLQueries {
  String dburl = "jdbc:mysql://localhost:3306/tvms";
  String dbuser = "root";
  String dbpass = "";

  Connection con;

  SQLQueries() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    con = DriverManager.getConnection(dburl, dbuser, dbpass);
  }

  int checkUsernamePass(String user, String pass) throws SQLException {
    String sql = "select user_id from user where username=? and password=?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setString(1, user);
    pst.setString(2, pass);
    ResultSet rs = pst.executeQuery();
    if (rs.next()) {
      return rs.getInt(1);
    } else {
      return 0;
    }
  }

  public boolean checkUsername(String user) throws SQLException {
    String sql = "select * from user where user_name=?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setString(1, user);
    ResultSet rs = pst.executeQuery();
    return rs.next();
  }

  public void createUser(Scanner inp) throws SQLException {
    System.out.print("Create username: ");
    String username = inp.nextLine();
    // while (checkUsername(username)) {
    //   System.out.println(Misc.ANSI_RED + "Username already exists! Pick a different one" + Misc.ANSI_RESET);
    //   System.out.print("Create username: ");
    //   username = inp.nextLine();
    // }
      // inp.nextLine();
    System.out.print("Create Password: ");
    String password = inp.nextLine();

    String sql = "insert into user values(null,?,?,1)";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setString(1, username);
    pst.setString(2, password);
    pst.execute();
  }

  public void fetchcurrentSettings(int id) throws SQLException {
    String sql = "Select * from user where user_id=? ";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setInt(1, id);

    ResultSet rs = pst.executeQuery();
    while (rs.next()) {
      System.out.println("User ID  = " + rs.getInt(1) + " ");
      System.out.println("UserName =" + rs.getString(2) + " ");
      System.out.println("UserPassword = " + rs.getString(3) + " ");
      System.out.println("Package Id = " + rs.getString(4) + " ");
    }
  }

  // Method to change usernmae
  public void changeUsername(Scanner sc) throws SQLException {
    Statement st = con.createStatement();

    System.out.print("Enter the name of the user: ");
    String user = sc.nextLine();
    System.out.print("Enter the password: ");
    String pass = sc.nextLine();
    String sql = "select * from  user where username = ? and password = ? ";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setString(1, user);
    pst.setString(2, pass);
    ResultSet rs = pst.executeQuery();
    int temp = 0;
    int pid = 0;
    while (rs.next()) {
      temp = 1;
      pid = rs.getInt(1);
    }
    if (temp == 1) {
      System.out.print("Enter new username: ");
      String newusername = sc.nextLine();
      String sqlupdate = "update user set username = '" + newusername + "' where user_id = " + pid;
      int i = st.executeUpdate(sqlupdate);
      if (i > 0) {
        System.out.println("Update success");
      } else {
        System.out.println("Update failed");
      }
    } else {
      System.out.println("Invalid userid and password");
    }

  }

  // Method to change user password
  public void changeUserpassword(Scanner sc) throws SQLException {

    Statement st = con.createStatement();

    System.out.print("Enter the name of the user: ");
    String user = sc.nextLine();
    System.out.print("Enter the old password: ");
    String pass = sc.nextLine();

    String checkSql = "select * from  user where username = '" + user + "' and password = '" + pass + "'";
    ResultSet rs = st.executeQuery(checkSql);
    int temp = 0;
    int pid = 0;
    while (rs.next()) {
      temp = 1;
      pid = rs.getInt(1);
    }
    if (temp == 1) {
      System.out.print("Enter new password: ");
      String newpass = sc.nextLine();
      String sql = "update user set password = '" + newpass + "' where user_id = " + pid;
      int i = st.executeUpdate(sql);
      if (i > 0) {
        System.out.println("Update success");
      } else {
        System.out.println("Update failed");
      }
    } else {
      System.out.println("Invalid userid and password");
    }
  }

}
