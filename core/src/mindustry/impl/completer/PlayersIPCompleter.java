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

public class PlayersIPCompleter implements Completer {
    private final StringsCompleter c;

    public PlayersIPCompleter() {
        Seq<String> ips_str = new Seq<>();
        for (Administration.PlayerInfo p : Vars.netServer.admins.playerInfo.values()) {
            ips_str.addAll(p.ips);
        }

        c = new StringsCompleter(ips_str);
    }

    @Override
    public void complete(LineReader reader, ParsedLine line, List<Candidate> candidates) {
        c.complete(reader, line, candidates);
    }
}
