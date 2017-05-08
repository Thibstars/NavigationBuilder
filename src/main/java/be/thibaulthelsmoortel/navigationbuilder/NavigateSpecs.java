package be.thibaulthelsmoortel.navigationbuilder;

import lombok.Data;

import java.util.List;

/**
 * Stateful class containing navigation data.
 *
 * @author Thibault Helsmoortel
 */
@Data
class NavigateSpecs {

    private String url;
    private boolean inNewTab;
    private boolean tryAsPopup;
    private boolean toLocation;
    private boolean reload;
    private boolean toPrevious;
    private boolean toNext;
    private List<NavigationListener> navigationListeners;

    /**
     * Adds a listener to the list.
     *
     * @param listener the listener to add
     */
    protected void addListener(NavigationListener listener) {
        navigationListeners.add(listener);
    }

    /**
     * Removes a listener from the list.
     *
     * @param listener the listener to remove
     */
    protected void removeListener(NavigationListener listener) {
        navigationListeners.remove(listener);
    }
}