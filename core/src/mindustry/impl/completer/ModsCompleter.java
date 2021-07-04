package mindustry.impl.completer;

import arc.struct.Seq;
import mindustry.Vars;
import mindustry.mod.Mods;
import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;
import org.jline.reader.impl.completer.StringsCompleter;

import java.util.List;

public class ModsCompleter implements Completer {
    private final StringsCompleter c;

    public ModsCompleter(Seq<Mods.LoadedMod> mods) {
        Seq<String> mods_str = new Seq<>();
        for (Mods.LoadedMod mod : mods) {
            mods_str.add(mod.name);
        }

        c = new StringsCompleter(mods_str);
    }

    public ModsCompleter() {
        this(Vars.mods.list());
    }

    @Override
    public void complete(LineReader reader, ParsedLine line, List<Candidate> candidates) {
        c.complete(reader, line, candidates);
    }
}
