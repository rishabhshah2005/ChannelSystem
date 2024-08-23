import java.sql.SQLException;
import java.util.Scanner;
import DS.Misc;

public class RecordShow {
    Scanner inp;
    SQLQueries sql;

    int user_id;

    RecordShow(Scanner inp, SQLQueries sql, int user_id) {
        this.inp = inp;
        this.sql = sql;
        this.user_id = user_id;
    }

    // start Recoding after inserting programme name and time id
    void recordShow() throws SQLException {
        System.out.print("Enter channel number: ");
        int channel_id = inp.nextInt();
        sql.record(user_id, inp, channel_id);

    }

    // Here you can view all Recoding
    void viewRecording() throws SQLException {
        sql.viewMyrecording(user_id);
    }

    // you can delete recording by recording id
    void deleteRecordById() throws SQLException {
        System.out.print("Enter recording id you want to delete: ");
        int record_id = inp.nextInt();
        sql.deleteRecordById(record_id, user_id);
    }

    public void main() throws SQLException {
        int index = 0;
        Misc.cls();
        while (index != 4) {

            System.out.println("1) Record");
            System.out.println("2) View Recordings");
            System.out.println("3) Delete Recordings");
            System.out.println("4) Exit");
            index = Misc.checkInt(inp, "Enter choice: ");
            switch (index) {
                case 1:
                    Misc.cls();
                    recordShow();
                    break;
                case 2:
                    Misc.cls();
                    viewRecording();
                    break;
                case 3:
                    Misc.cls();
                    deleteRecordById();
                    break;
                case 4:
                    Misc.cls();
                    break;

                default:
                    System.out.println("Enter valid choice!");
                    break;
            }

        }
    }
}
