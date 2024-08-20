package DS;

import java.time.LocalTime;

public class PlayQue {
    public String channel_name, prog_name;
    public LocalTime start, end;

    public PlayQue(String channel_name, String prog_name, LocalTime start, LocalTime end) {
        this.channel_name = channel_name;
        this.prog_name = prog_name;
        this.start = start;
        this.end = end;
    }

}