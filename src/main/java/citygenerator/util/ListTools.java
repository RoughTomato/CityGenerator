package citygenerator.util;

import java.util.List;
import java.util.stream.Collectors;

public class ListTools {

    public static <E> List<E> removeDuplicates(List<E> list) {
        return list.stream().distinct().collect(Collectors.toList());
    }

}
