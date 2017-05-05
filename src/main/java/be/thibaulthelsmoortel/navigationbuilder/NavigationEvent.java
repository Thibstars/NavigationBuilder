package be.thibaulthelsmoortel.navigationbuilder;

import java.util.EventObject;

/**
 * Event that will be fired upon navigation.
 *
 * @author Thibault Helsmoortel
 */
public class NavigationEvent extends EventObject {

    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public NavigationEvent(Object source) {
        super(source);
    }

    /**
     * Returns the url of the performed navigation if the event source was an instance of {@link NavigateExecutor}.
     *
     * @return the url of the performed navigation
     */
    public String getUrl() {
        if (source instanceof NavigateExecutor) {
            return ((NavigateExecutor) source).getNavigateSpecs().getUrl();
        }
        return null;
    }
}
