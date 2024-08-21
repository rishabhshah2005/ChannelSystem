import java.sql.Statement;
import java.time.LocalTime;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import DS.LinkedListPrac;
import DS.Misc;
import DS.PlayQue;

public class SQLQueries {
  String dburl = "jdbc:mysql://localhost:3306/tvms";
  String dbuser = "root";
  String dbpass = "";

  Connection con;

  SQLQueries() throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    con = DriverManager.getConnection(dburl, dbuser, dbpass);
  }

  public void getPackage(int id, LinkedListPrac<Integer> ll_pack) throws SQLException {
    String sql = "select package_id from user where user_id=" + id;
    PreparedStatement pst = con.prepareStatement(sql);
    ResultSet rs = pst.executeQuery();
    rs.next();
    int p_id = rs.getInt(1);
    switch (p_id) {
      case 1:
        sql = "select * from free_channel";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
          ll_pack.addLast(rs.getInt(1));
        }
        break;

      case 2:
        sql = "select channel_id from channel where is_hd=true";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
          ll_pack.addLast(rs.getInt(1));
        }
        break;

      case 3:
        sql = "select channel_id from channel where is_hd=false";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
          ll_pack.addLast(rs.getInt(1));
        }
        break;

      case 4:
        sql = "select channel_id from channel";
        pst = con.prepareStatement(sql);
        rs = pst.executeQuery();
        while (rs.next()) {
          ll_pack.addLast(rs.getInt(1));
        }
        break;

      default:
        break;
    }
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
    String sql = "select * from user where username=?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setString(1, user);
    ResultSet rs = pst.executeQuery();
    return rs.next();
  }

  public void createUser(Scanner inp) throws SQLException {
    System.out.print("Create username: ");
    String username = inp.nextLine();
    while (checkUsername(username)) {
      System.out.println(Misc.ANSI_RED + "Username already exists! Pick a different one" + Misc.ANSI_RESET);
      System.out.print("Create username: ");
      username = inp.nextLine();
    }

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
      System.out.println("UserName = " + rs.getString(2) + " ");
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

  public LinkedListPrac<PlayQue> displayAllChannels(LinkedListPrac<Integer> ll_pack) throws SQLException {
    LinkedListPrac<PlayQue> res = new LinkedListPrac<>();
    
    String sql = "select * from currently_playing order by channel_id";
    PreparedStatement pst = con.prepareStatement(sql);
    ResultSet rs = pst.executeQuery();

    while (rs.next()) {
      if (ll_pack.contains(rs.getInt(1))) {
        String chann = rs.getString(2);
        String prog = rs.getString(3);
        LocalTime start = rs.getTime(4).toLocalTime();
        LocalTime end = rs.getTime(5).toLocalTime();
        PlayQue pq = new PlayQue(chann, prog, start, end);
        res.addLast(pq);
      }
    }

    return res;
  }

  public void changeUserPack(Scanner sc, int id) throws SQLException {
    Statement st = con.createStatement();

    System.out.println("1) change to free Channels.");
    System.out.println("2) change to HD Channels.");
    System.out.println("3) change to Normal Channels.");
    System.out.println("4) change to All Channels.");
    System.out.println();
    System.out.println("Enter your choice.");
    int ch = sc.nextInt();

    switch (ch) {

      case 1:
        String sql = "update user set package_id = 1 where user_id = " + id;
        int h = st.executeUpdate(sql);
        if (h > 0) {
          System.out.println("Update success");
        } else {
          System.out.println("Update failed");
        }
        break;

      case 2:
        String sql1 = "update user set package_id = 2 where user_id = " + id;
        int i = st.executeUpdate(sql1);
        if (i > 0) {
          System.out.println("Update success");
        } else {
          System.out.println("Update failed");
        }
        break;

      case 3:
        String sql2 = "update user set package_id = 3 where user_id = " + id;
        int j = st.executeUpdate(sql2);
        if (j > 0) {
          System.out.println("Update success");
        } else {
          System.out.println("Update failed");
        }
        break;

      case 4:
        String sql3 = "update user set package_id = 4 where user_id = " + id;
        int k = st.executeUpdate(sql3);
        if (k > 0) {
          System.out.println("Update success");
        } else {
          System.out.println("Update failed");
        }
        break;

      default:
        break;
    }

  }

  public void updateChannel(Scanner sc) throws SQLException {

    System.out.print("Enter old Channel name to update: ");
    sc.nextLine();
    String c_name = sc.nextLine();

    System.out.print("Enter new Channel name: ");
    String c_new_name = sc.nextLine();
    System.out.println("New name " + c_new_name);

    // String sql = "update user set password = '" + newpass + "' where user_id = "
    // + pid;

    String sql1 = "update channel set channel_name = '" + c_new_name + "' where channel_name = '" + c_name + "'";
    PreparedStatement pst = con.prepareStatement(sql1);
    // pst.setString(1, c_new_name);
    // pst.setString(2, c_name);

    pst.execute();

    String c_hd_name = c_name + "HD";
    String c_hd_new_name = c_new_name + "HD";
    String sql2 = "update channel set channel_name = '" + c_hd_new_name + "' where channel_name = '" + c_hd_name
        + "'";
    pst = con.prepareStatement(sql2);
    // pst.setString(1, c_hd_new_name);
    // pst.setString(2, c_hd_name);

    int j = pst.executeUpdate(sql2);
    if (j > 0) {
      System.out.println("Update success");
    } else {
      System.out.println("Update failed");
    }

  }
}
