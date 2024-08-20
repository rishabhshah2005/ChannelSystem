import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

class RecordShow {
    // start Recoding after inserting programme name and time id
    int user_id;

    void recordShow(Scanner inp, int user_id) throws Exception {
        user_id = this.user_id;
        PreparedStatement pst;
        int rs;
        ResultSet resultSet;
        SQLQueries sql = new SQLQueries();

        String program_routine = "select * from program_routine join channel on program_routine.channel_id=channel.channel_id join  time_slot on program_routine.time_slot_id=time_slot.time_slot_id ";
        pst = sql.con.prepareStatement(program_routine);
        resultSet = pst.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getInt("program_id") + "\t"
                    + resultSet.getString("program_name") + "\t                  " + resultSet.getTime("start_time")
                    + "-"
                    + resultSet.getTime("end_time"));
        }

        System.out.print("\n Enter  program_id  you want to record : ");
        int program_id = inp.nextInt();
        String getprogramDetails = "select * from program_routine where program_id=?";
        pst = sql.con.prepareStatement(getprogramDetails);
        pst.setInt(1, program_id);
        resultSet = pst.executeQuery();
        String prg_name = "";
        int channel_id = 0;
        int time_id = 0;
        while (resultSet.next()) {
            prg_name = resultSet.getString("program_name");
            channel_id = resultSet.getInt("channel_id");
            time_id = resultSet.getInt("time_slot_id");
        }
        if (recAlreadyExists(prg_name, user_id)) {
            String startRecord = "insert into record_shows(programe_name,channel_id,time_slot_id,user_id) values( ? , ? , ? , ?)";
            pst = sql.con.prepareStatement(startRecord);
            pst.setString(1, prg_name);
            pst.setInt(2, channel_id);
            pst.setInt(3, time_id);
            pst.setInt(4, user_id);

            rs = pst.executeUpdate();
            if (rs > 0) {
                System.out.println("\tRecording Starts!");
            } else {
                System.out.println("\tRecoding start failed!");
            }
        } else {
            System.out.println("\tYou Have already recorded!");
        }

    }

    boolean recAlreadyExists(String prg_name, int user_id) throws Exception {
        SQLQueries sql = new SQLQueries();
        String record = "select programe_name,user_id from record_shows where programe_name=? and user_id=?  ";
        PreparedStatement pst = sql.con.prepareStatement(record);
        pst.setString(1, prg_name);
        pst.setInt(2, this.user_id);
        ResultSet rs = pst.executeQuery();
        while (rs.next()) {
            if (prg_name.equals(rs.getString("programe_name"))) {
                int u_id = rs.getInt("user_id");

                if (this.user_id == u_id) {
                    return false;
                }
            }

        }
        return true;
    }

    // Here you can view all Recoding
    void viewRecording(int user_id) throws Exception {
        String viewRecord = "select * FROM record_shows join time_slot on record_shows.time_slot_id=time_slot.time_slot_id where user_id=?";
        SQLQueries sq = new SQLQueries();
        PreparedStatement pst = sq.con.prepareStatement(viewRecord);
        pst.setInt(1, this.user_id);
        ResultSet rs = pst.executeQuery();
        System.out.println("Record ID" + "\t" + "Programm name" + "\t                            " + "Time");
        while (rs.next()) {
            System.out.println(
                    rs.getInt(1) + "\t      " + rs.getString("programe_name") + "\t                         "
                            + rs.getTime("start_time")
                            + "-"
                            + rs.getTime("end_time"));
        }

    }

    // you can delete recording by recording id
    void deleteRecordById(int record_id, int user_id) throws Exception {
        String deleteRecord = "Delete from record_shows where record_id=?  and user_id =? ";
        SQLQueries sq = new SQLQueries();

        PreparedStatement pst = sq.con.prepareStatement(deleteRecord);
        pst.setInt(1, record_id);
        pst.setInt(2, this.user_id);
        int rs = pst.executeUpdate();
        if (rs > 0) {
            System.out.println("You Have Successfully Deleted Recording ! ");
        } else {
            System.out.println("Recording Doesn't Exists! ");
        }
    }
}
