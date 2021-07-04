package mindustry.impl.completer;

import arc.struct.Seq;
import mindustry.entities.EntityGroup;
import mindustry.gen.Groups;
import mindustry.gen.Player;
import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;
import org.jline.reader.impl.completer.StringsCompleter;

import java.util.List;

public class PlayersCompleter implements Completer {
    private final StringsCompleter c;

    public PlayersCompleter(Seq<Player> players) {
        Seq<String> players_str = new Seq<>();
        for (Player player : players) {
            players_str.add(player.name);
        }

        c = new StringsCompleter(players_str);
    }

    public PlayersCompleter(EntityGroup<Player> players) {
        this(Seq.with(players));
    }

    public PlayersCompleter() {
        this(Groups.player);
    }

    @Override
    public void complete(LineReader reader, ParsedLine line, List<Candidate> candidates) {
        c.complete(reader, line, candidates);
    }
}
