package mindustry.utils;

import arc.struct.Seq;
import org.jline.reader.Completer;

import java.util.function.Function;

public class InputCompleter {
    Function<Seq<Seq<Completer>>, Seq<Seq<Completer>>> callback;
    Function<Seq<Completer>, Seq<Completer>> callback_low;

    private InputCompleter() { }

    public static InputCompleter from(Function<Seq<Completer>, Seq<Completer>> callback) {
        InputCompleter compl = new InputCompleter();
        compl.callback_low = callback;

        return compl;
    }

    public static InputCompleter fromAll(Function<Seq<Seq<Completer>>, Seq<Seq<Completer>>> callback) {
        InputCompleter compl = new InputCompleter();
        compl.callback = callback;

        return compl;
    }

    public void updateCallback(
            Function<Seq<Seq<Completer>>, Seq<Seq<Completer>>> newCallback) {
        callback = newCallback;
    }

    public Seq<Seq<Completer>> getCompleters() {
        Seq<Seq<Completer>> result = new Seq<>();

        if (callback == null) {
            return result.addAll(callback_low.apply(new Seq<>()));
        }

        return callback.apply(result);
    }
}
