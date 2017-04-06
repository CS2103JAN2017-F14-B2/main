package seedu.task.ui;

import javafx.scene.Node;
import javafx.scene.control.ListView;
import javafx.scene.control.ScrollBar;
import seedu.task.model.task.ReadOnlyTask;
//@@author A0142939W
/**
 * This class controls the scroll bar of any listview.
 */
public class Scroll {
    private ScrollBar scrollBar;

    public Scroll() {
        scrollBar = null;
    }

    Scroll(ListView<ReadOnlyTask> taskListView) {
        Node n = taskListView.lookup(".scroll-bar");
        if (n == null) {
            return;
        }
        if (n instanceof ScrollBar) {
            scrollBar = (ScrollBar) n;
        }
    }

    public void scrollDown(ListView<ReadOnlyTask> taskListView) {
        if (scrollBar == null) {
            Node n = taskListView.lookup(".scroll-bar");
            if (n == null) {
                return;
            }
            if (n instanceof ScrollBar) {
                scrollBar = (ScrollBar) n;
            }
        }
        scrollBar.increment();
        scrollBar.increment();
        scrollBar.increment();
        scrollBar.increment();
        scrollBar.increment();
    }

    public void scrollUp(ListView<ReadOnlyTask> taskListView) {
        if (scrollBar == null) {
            Node n = taskListView.lookup(".scroll-bar");
            if (n == null) {
                return;
            }
            if (n instanceof ScrollBar) {
                scrollBar = (ScrollBar) n;
            }
        }
        scrollBar.decrement();
        scrollBar.decrement();
        scrollBar.decrement();
        scrollBar.decrement();
        scrollBar.decrement();
    }

    public double getScrollValue(ListView<ReadOnlyTask> taskListView) {
        if (scrollBar == null) {
            Node n = taskListView.lookup(".scroll-bar");
            if (n == null) {
                return -1;
            }
            if (n instanceof ScrollBar) {
                scrollBar = (ScrollBar) n;
            }
        }

        return scrollBar.getValue();
    }

}
