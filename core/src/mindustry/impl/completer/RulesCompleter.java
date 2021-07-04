package mindustry.impl.completer;

import arc.struct.Seq;
import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;
import org.jline.reader.impl.completer.StringsCompleter;

import java.lang.reflect.Field;
import java.util.List;

import static mindustry.Vars.state;

public class RulesCompleter implements Completer {
    private final StringsCompleter c;

    public RulesCompleter() {
        Seq<String> rules_str = new Seq<>();
        for (Field f : state.rules.getClass().getFields()) {
            rules_str.add(f.getName());
        }

        c = new StringsCompleter(rules_str);
    }

    @Override
    public void complete(LineReader reader, ParsedLine line, List<Candidate> candidates) {
        c.complete(reader, line, candidates);
    }
}
