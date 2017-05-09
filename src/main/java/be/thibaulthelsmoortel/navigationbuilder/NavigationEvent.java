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
     * @param executor The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public NavigationEvent(NavigationExecutor executor) {
        super(executor);
    }

    /**
     * Returns the url of the performed navigation.
     *
     * @return the url of the performed navigation
     */
    public String getUrl() {
        return ((NavigationExecutor) source).getNavigationSpecs().getUrl();
    }

    /**
     * Returns the navigation type of the performed navigation.
     *
     * @return the navigation type of the performed navigation
     */
    public NavigationType getNavigationType() {
        return ((NavigationExecutor) source).getNavigationSpecs().getNavigationType();
    }
}
