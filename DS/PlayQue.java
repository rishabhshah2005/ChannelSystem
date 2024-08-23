package DS;

import java.time.LocalTime;

public class PlayQue {
    public String channel_name, prog_name, type, lang;
    public LocalTime start, end;
    public int id;

    public PlayQue(int id, String channel_name, String type, String lang, String prog_name, LocalTime start,
            LocalTime end) {
        this.id = id;
        this.channel_name = channel_name;
        this.lang = lang;
        this.type = type;
        this.prog_name = prog_name;
        this.start = start;
        this.end = end;
    }

}