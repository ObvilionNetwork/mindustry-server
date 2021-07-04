package mindustry.impl.completer;

import arc.struct.Seq;
import mindustry.game.Team;
import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;
import org.jline.reader.impl.completer.StringsCompleter;

import java.util.List;

public class TeamsCompleter implements Completer {
    private final StringsCompleter c;

    public TeamsCompleter(Seq<Team> teams) {
        Seq<String> teams_str = new Seq<>();
        for (Team t : teams) {
            teams_str.add(t.name);
        }

        c = new StringsCompleter(teams_str);
    }

    @Override
    public void complete(LineReader reader, ParsedLine line, List<Candidate> candidates) {
        c.complete(reader, line, candidates);
    }
}