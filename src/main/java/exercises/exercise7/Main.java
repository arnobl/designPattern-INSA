package exercises.exercise7;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

interface Bar {
    boolean isBabar();
}

public class Main {
    Optional<Bar> getBar(final List<Bar> src) {
        for (final Bar bar : src) {
            if (bar.isBabar()) {
                return Optional.of(bar);
            }
        }
        return Optional.empty();
    }


    public List<String> foo(final List<List<String>> ls) {
        final List<String> res = new ArrayList<>();
        for (final List<String> l : ls) {
            for (final String s : l) {
                res.add(s);
            }
        }
        return res;
    }


    public List<String> yolo(final List<Integer> data) {
        final int size = data.size();
        final List<String> res = new ArrayList<>();
        int i = 0;
        while (i < size) {
            if (data.get(i) < 10) {
                res.add(data.get(i).toString());
            }
            i++;
        }
        return res;
    }
}
