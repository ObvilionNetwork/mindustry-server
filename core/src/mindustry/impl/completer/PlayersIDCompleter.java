package mindustry.impl.completer;

import arc.struct.Seq;
import mindustry.Vars;
import mindustry.net.Administration;
import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;
import org.jline.reader.impl.completer.StringsCompleter;

import java.util.List;

public class PlayersIDCompleter implements Completer {
    private final StringsCompleter c;

    public PlayersIDCompleter() {
        Seq<String> ids_str = new Seq<>();
        for (Administration.PlayerInfo p : Vars.netServer.admins.playerInfo.values()) {
            ids_str.add(p.id);
        }

        c = new StringsCompleter(ids_str);
    }

    @Override
    public void complete(LineReader reader, ParsedLine line, List<Candidate> candidates) {
        c.complete(reader, line, candidates);
    }
}