package xm.util;

import java.util.ArrayList;
import java.util.List;

/**
 * A path is a list of visited elements with convenient access to the most recent one.
 * A path cannot be empty.
 *
 * @param <E> the type of objects in this path
 */
public class Path<E> {
    final List<E> path;

    /**
     * @param last the only element of this path
     */
    public Path(E last) {
        path = new ArrayList<>();
        path.add(last);
    }

    /**
     * @param last the latest element to add to the path
     * @param path a list of previously visited elements
     */
    public Path(E last, List<E> path) {
        this.path = new ArrayList<>(path);
        this.path.add(last);
    }

    public E getLast() {
        return path.get(path.size() - 1);
    }

    public List<E> getPath() {
        return path;
    }
}
