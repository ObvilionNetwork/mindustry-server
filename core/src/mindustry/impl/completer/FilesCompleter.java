package mindustry.impl.completer;

import arc.files.Fi;
import arc.struct.Seq;
import org.jline.reader.Candidate;
import org.jline.reader.Completer;
import org.jline.reader.LineReader;
import org.jline.reader.ParsedLine;
import org.jline.reader.impl.completer.StringsCompleter;

import java.util.List;

public class FilesCompleter implements Completer {
    private final StringsCompleter c;

    public FilesCompleter(Fi dir, boolean ignoreExtension) {
        Seq<String> gms_str = new Seq<>();
        if (ignoreExtension) {
            for (Fi f : dir.findAll()) {
                gms_str.add(f.nameWithoutExtension());
            }
        } else {
            for (Fi f : dir.findAll()) {
                gms_str.add(f.name());
            }
        }

        c = new StringsCompleter(gms_str);
    }

    @Override
    public void complete(LineReader reader, ParsedLine line, List<Candidate> candidates) {
        c.complete(reader, line, candidates);
    }
}