package DS;

import java.time.LocalDateTime;

public class Req {
    public String username, status;
    public int new_pack_id;
    public LocalDateTime req_time;

    public Req(String username, String status, int new_pack_id, LocalDateTime req_time) {
        this.username = username;
        this.status = status;
        this.new_pack_id = new_pack_id;
        this.req_time = req_time;
    }

}
