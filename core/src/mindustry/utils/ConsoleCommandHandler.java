package mindustry.utils;

import arc.func.Cons;
import arc.struct.Seq;
import arc.util.CommandHandler;

import org.jline.reader.Completer;
import org.jline.reader.impl.LineReaderImpl;
import org.jline.reader.impl.completer.AggregateCompleter;
import org.jline.reader.impl.completer.ArgumentCompleter;
import org.jline.reader.impl.completer.NullCompleter;
import org.jline.reader.impl.completer.StringsCompleter;

public class ConsoleCommandHandler extends CommandHandler {
    public static LineReaderImpl lr;

    public ConsoleCommandHandler(String prefix) {
        super(prefix);
    }

    @Override
    public <T> Command register(String text, String description, CommandRunner<T> runner) {
        return super.register(text, description, runner);
    }

    @Override
    public <T> Command register(String text, String params, String description, CommandRunner<T> runner) {
        return super.register(text, params, description, runner);
    }

    public Command register(String text, String description, Seq<Seq<Completer>> completers, Cons<String[]> runner) {
        updateCompleters(text, completers);
        return register(text, description, (args, p) -> runner.get(args));
    }

    public Command register(String text, String params, String description, Seq<Seq<Completer>> completers, Cons<String[]> runner) {
        updateCompleters(text, completers);
        return register(text, params, description, (args, p) -> runner.get(args));
    }

    @Override
    public Command register(String text, String description, Cons<String[]> runner) {
        Seq<Seq<Completer>> c = new Seq<>();
        Seq<Completer> c1 = new Seq<>();
        c1.add(new NullCompleter());
        c.add(c1);

        updateCompleters(text, c);
        return super.register(text, description, runner);
    }

    @Override
    public Command register(String text, String params, String description, Cons<String[]> runner) {
        Seq<Seq<Completer>> c = new Seq<>();
        Seq<Completer> c1 = new Seq<>();
        c1.add(new NullCompleter());
        c.add(c1);

        updateCompleters(text, c);
        return super.register(text, params, description, runner);
    }

    private void updateCompleters(String cmd, Seq<Seq<Completer>> completers) {
        Seq<Completer> c = Seq.with(((AggregateCompleter) lr.getCompleter()).getCompleters());
        for (Seq<Completer> comp : completers) {
            Seq<Completer> all = new Seq<>();
            all.add(new StringsCompleter(cmd));
            all.addAll(comp);

            c.add(new ArgumentCompleter(all.list()));
        }

        lr.setCompleter(new AggregateCompleter(c.list()));
    }
}
