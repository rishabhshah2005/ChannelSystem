import java.sql.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Scanner;

import DS.*;

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

  public LinkedListPrac<PlayQue> AllChannels(LinkedListPrac<Integer> ll_pack) throws SQLException {
    LinkedListPrac<PlayQue> res = new LinkedListPrac<>();

    String sql = "select * from currently_playing order by channel_id";
    PreparedStatement pst = con.prepareStatement(sql);
    ResultSet rs = pst.executeQuery();

    while (rs.next()) {
      if (ll_pack.contains(rs.getInt(1))) {
        int id = rs.getInt(1);
        String chann = rs.getString(2);
        String type = rs.getString(3);
        String lang = rs.getString(4);
        String prog = rs.getString(5);
        LocalTime start = rs.getTime(6).toLocalTime();
        LocalTime end = rs.getTime(7).toLocalTime();
        PlayQue pq = new PlayQue(id, chann, type, lang, prog, start, end);
        res.addLast(pq);
      }
    }

    return res;
  }

  public void changeUserPack(Scanner sc, String username) throws SQLException {

    System.out.println("1) change to free Channels.");
    System.out.println("2) change to HD Channels.");
    System.out.println("3) change to Normal Channels.");
    System.out.println("4) change to All Channels.");
    System.out.println();
    int ch = Misc.checkInt(sc, "Enter Index: ");
    while (!(ch > 0 && ch < 5)) {
      System.out.println("Enter correct index!!");
      ch = Misc.checkInt(sc, "Enter Index: ");
    }

    String sql = "update user set package_id = ? where username = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setInt(1, ch);
    pst.setString(2, username);

    int h = pst.executeUpdate();
    if (h > 0) {
      Misc.cls();
      System.out.println(Misc.ANSI_GREEN + "Update successful" + Misc.ANSI_RESET);
    } else {
      Misc.cls();
      System.out.println(Misc.ANSI_RED + "User not found" + Misc.ANSI_RESET);
    }

  }

  public void updateChannel(Scanner sc) throws SQLException {

    System.out.print("Enter old Channel name to update: ");
    String c_name = sc.nextLine();

    System.out.print("Enter new Channel name: ");
    String c_new_name = sc.nextLine();
    System.out.println("New name " + c_new_name);

    String sql1 = "update channel set channel_name = '" + c_new_name + "' where channel_name = '" + c_name + "'";
    PreparedStatement pst = con.prepareStatement(sql1);

    pst.execute();

    String c_hd_name = c_name + "HD";
    String c_hd_new_name = c_new_name + "HD";
    String sql2 = "update channel set channel_name = '" + c_hd_new_name + "' where channel_name = '" + c_hd_name
        + "'";
    pst = con.prepareStatement(sql2);

    int j = pst.executeUpdate(sql2);
    if (j > 0) {
      Misc.cls();
      System.out.println("Update success");
    } else {
      Misc.cls();
      System.out.println("Update failed");
    }

  }

  public void record(int user_id, Scanner sc, int channel_no) throws SQLException {

    while (true) {
      @SuppressWarnings("unused")
      int timeid = 0;
      int check = 0;
      String heading[] = { "Channel ID", "Progam ID ", "Program Name", "Time" };

      String record = "select package_id from user where user_id=" + user_id;
      PreparedStatement pst = con.prepareStatement(record);
      ResultSet rs = pst.executeQuery();
      rs.next();
      int p_id = rs.getInt(1);
      switch (p_id) {
        case 1:
          record = "select * from program_routine join time_slot on program_routine.time_slot_id=time_slot.time_slot_id where channel_id In(select free_channel_id from free_channel where free_channel_id=?) ";
          pst = con.prepareStatement(record);
          pst.setInt(1, channel_no);

          rs = pst.executeQuery();

          System.out.println(Misc.padAllRight(heading, 27));
          while (rs.next()) {

            timeid = rs.getInt("time_slot_id");
            String time = Misc.printTime(rs.getTime("start_time").toLocalTime()) + "-"
                + Misc.printTime(rs.getTime("end_time").toLocalTime());
            String arr[] = { Integer.toString(rs.getInt("channel_id")), Integer.toString(rs.getInt("program_id")),
                rs.getString("program_name"), time };

            System.out.println(Misc.padAllRight(arr, 27));
            check = 1;
          }

          break;

        case 2:
          record = "select * from program_routine join time_slot on program_routine.time_slot_id=time_slot.time_slot_id where channel_id In(select channel_id from channel where is_hd=true and channel_id=? )";
          pst = con.prepareStatement(record);
          pst.setInt(1, channel_no);

          rs = pst.executeQuery();

          System.out.println(Misc.padAllRight(heading, 27));
          while (rs.next()) {

            timeid = rs.getInt("time_slot_id");
            String time = Misc.printTime(rs.getTime("start_time").toLocalTime()) + "-"
                + Misc.printTime(rs.getTime("end_time").toLocalTime());
            String arr[] = { Integer.toString(rs.getInt("channel_id")), Integer.toString(rs.getInt("program_id")),
                rs.getString("program_name"), time };

            System.out.println(Misc.padAllRight(arr, 27));
            check = 1;

          }
          break;

        case 3:
          record = "select * from program_routine join time_slot on program_routine.time_slot_id=time_slot.time_slot_id where channel_id In(select channel_id from channel where is_hd=false and channel_id=?)";
          pst = con.prepareStatement(record);
          pst.setInt(1, channel_no);
          rs = pst.executeQuery();
          System.out.println(Misc.padAllRight(heading, 35));
          while (rs.next()) {

            timeid = rs.getInt("time_slot_id");
            String time = Misc.printTime(rs.getTime("start_time").toLocalTime()) + "-"
                + Misc.printTime(rs.getTime("end_time").toLocalTime());
            String arr[] = { Integer.toString(rs.getInt("channel_id")), Integer.toString(rs.getInt("program_id")),
                rs.getString("program_name"), time };

            System.out.println(Misc.padAllRight(arr, 27));
            check = 1;
          }
          break;

        case 4:
          record = "select * from program_routine join time_slot on program_routine.time_slot_id=time_slot.time_slot_id where channel_id In(select channel_id from channel where channel_id=?)";
          pst = con.prepareStatement(record);
          pst.setInt(1, channel_no);

          rs = pst.executeQuery();
          System.out.println(Misc.padAllRight(heading, 27));
          while (rs.next()) {

            timeid = rs.getInt("time_slot_id");
            String time = Misc.printTime(rs.getTime("start_time").toLocalTime()) + "-"
                + Misc.printTime(rs.getTime("end_time").toLocalTime());
            String arr[] = { Integer.toString(rs.getInt("channel_id")), Integer.toString(rs.getInt("program_id")),
                rs.getString("program_name"), time };

            System.out.println(Misc.padAllRight(arr, 27));
            check = 1;
          }
          break;

        default:
          break;
      }

      if (check != 1) {
        System.out.println("This channel is not available in your package!");
      } else {
        System.out.print("Enter Program ID  you want to record : ");
        int prg_id = sc.nextInt();
        recordProgram(prg_id, user_id);
      }
      break;
    }
  }

  void recordProgram(int program_id, int user_id) throws SQLException {
    int prg_id = program_id;
    int channel_Id = 0;
    int timeid = 0;
    String prog_name = "";
    String selectprogram = "select * from program_routine where program_id=? ";
    PreparedStatement pst = con.prepareStatement(selectprogram);
    pst.setInt(1, prg_id);
    ResultSet rs = pst.executeQuery();
    while (rs.next()) {
      prog_name = rs.getString("program_name");

      channel_Id = rs.getInt("channel_id");
      timeid = rs.getInt("time_slot_id");
    }

    String insertRecord = "insert into record_shows (programe_name,channel_id,time_slot_id,user_id) values(? , ? , ? , ? )";

    pst = con.prepareStatement(insertRecord);
    pst.setString(1, prog_name);
    pst.setInt(2, channel_Id);
    pst.setInt(3, timeid);
    pst.setInt(4, user_id);
    int result = pst.executeUpdate();
    System.out.println((result > 0) ? "Recording Done Successfull!" : "Recording Failed!");

  }

  void viewMyrecording(int uid) throws SQLException {
    int check = 0;
    String view = "select * from record_shows join time_slot on record_shows.time_slot_id= time_slot.time_slot_id where user_id=?";
    PreparedStatement pst = con.prepareStatement(view);
    pst.setInt(1, uid);
    ResultSet rs = pst.executeQuery();
    String heading[] = { "Recording ID", "Channel ID", "Program Name", "Time" };
    System.out.println(Misc.padAllRight(heading, 35, Misc.ANSI_YELLOW));
    while (rs.next()) {

      String time = Misc.printTime(rs.getTime("start_time").toLocalTime()) + "-"
          + Misc.printTime(rs.getTime("end_time").toLocalTime());
      String arr[] = { Integer.toString(rs.getInt("record_id")), Integer.toString(rs.getInt("channel_id")),
          rs.getString("programe_name"), time };
      System.out.println(Misc.padAllRight(arr, 35));
      check = 1;
    }
    System.out.println((check != 1) ? "No recordings Available!" : "");

  }

  void deleteRecordById(int record_id, int user_id) throws SQLException {
    String deleteRecord = "delete from record_shows where record_id=? and user_id=?";
    PreparedStatement pst = con.prepareStatement(deleteRecord);
    pst.setInt(1, record_id);
    pst.setInt(2, user_id);
    int rs = pst.executeUpdate();
    System.out.println((rs > 0) ? "You Have Successfully Deleted Recording !"
        : "There is no Recording with RecordingID! " + record_id);
  }

  public boolean checkRequest(String username) throws SQLException {
    boolean found = false;
    String sql = "select * from requests where username = ?";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setString(1, username);
    ResultSet rs = pst.executeQuery();
    while (rs.next()) {
      String stat = rs.getString("status");
      if (stat.equals("pending")) {
        found = true;
        break;
      }
    }
    return found;
  }

  public void insertRequest(String username, int new_id) throws SQLException {
    String sql = "insert into requests values(null,?,?,'pending',null)";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setString(1, username);
    pst.setInt(2, new_id);
    pst.executeUpdate();
  }

  public LinkedListPrac<Req> getAllRequests() throws SQLException {
    LinkedListPrac<Req> res = new LinkedListPrac<>();

    String sql = "select * from requests order by req_time";
    PreparedStatement pst = con.prepareStatement(sql);
    ResultSet rs = pst.executeQuery();
    while (rs.next()) {
      String user = rs.getString(2);
      int id = rs.getInt(3);
      String stat = rs.getString(4);
      Timestamp t = rs.getTimestamp(5);
      LocalDateTime ldt = LocalDateTime.ofInstant(t.toInstant(), ZoneId.of("Asia/Kolkata"));
      Req q = new Req(user, stat, id, ldt);
      res.addLast(q);
    }
    return res;
  }

  public Que<Req> getPendingReqs() throws SQLException {
    Que<Req> res = new Que<>();

    String sql = "select * from requests where status='pending' order by req_time";
    PreparedStatement pst = con.prepareStatement(sql);
    ResultSet rs = pst.executeQuery();
    while (rs.next()) {
      String user = rs.getString(2);
      int id = rs.getInt(3);
      String stat = rs.getString(4);
      Timestamp t = rs.getTimestamp(5);
      LocalDateTime ldt = LocalDateTime.ofInstant(t.toInstant(), ZoneId.of("Asia/Kolkata"));
      Req q = new Req(user, stat, id, ldt);
      res.enque(q);
    }
    return res;
  }

  public void updateReq(String stat, String user) throws SQLException {
    String sql = "update requests set status=? where username=? and status='pending'";
    PreparedStatement pst = con.prepareStatement(sql);
    pst.setString(1, stat);
    pst.setString(2, user);
    pst.executeUpdate();
  }

}
