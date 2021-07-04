package mindustry.impl.completer;

import arc.struct.Seq;
import mindustry.net.Administration;
import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;
import org.jline.reader.impl.completer.StringsCompleter;

import java.util.List;

public class ConfigCompleter implements Completer {
    private final StringsCompleter c;

    public ConfigCompleter() {
        Seq<String> gms_str = new Seq<>();
        for (Administration.Config c : Administration.Config.all) {
            gms_str.add(c.key);
        }

        c = new StringsCompleter(gms_str);
    }

    @Override
    public void complete(LineReader reader, ParsedLine line, List<Candidate> candidates) {
        c.complete(reader, line, candidates);
    }
}