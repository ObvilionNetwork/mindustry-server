package mindustry.impl.completer;

import arc.struct.Seq;
import mindustry.game.Gamemode;
import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;
import org.jline.reader.impl.completer.StringsCompleter;

import java.util.List;

public class GamemodeCompleter implements Completer {
    private final StringsCompleter c;

    public GamemodeCompleter() {
        Seq<String> gms_str = new Seq<>();
        for (Gamemode gm : Gamemode.all) {
            gms_str.add(gm.name());
        }

        c = new StringsCompleter(gms_str);
    }

    @Override
    public void complete(LineReader reader, ParsedLine line, List<Candidate> candidates) {
        c.complete(reader, line, candidates);
    }
}
