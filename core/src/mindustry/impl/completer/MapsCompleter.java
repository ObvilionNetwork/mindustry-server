package mindustry.impl.completer;

import arc.struct.Seq;
import mindustry.Vars;
import mindustry.maps.Map;
import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;
import org.jline.reader.impl.completer.StringsCompleter;

import java.util.List;

public class MapsCompleter implements Completer {
    private final StringsCompleter c;

    public MapsCompleter(Seq<Map> maps) {
        Seq<String> maps_str = new Seq<>();
        for (Map map : maps) {
            maps_str.add(map.name().replaceAll(" ", "_"));
        }

        c = new StringsCompleter(maps_str);
    }

    public MapsCompleter() {
        this(Vars.maps.all());
    }

    @Override
    public void complete(LineReader reader, ParsedLine line, List<Candidate> candidates) {
        c.complete(reader, line, candidates);
    }
}
