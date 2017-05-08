package be.thibaulthelsmoortel.navigationbuilder;

import java.util.ArrayList;

/**
 * Builder supporting chained calls.
 *
 * @author Thibault Helsmoortel
 */
public class NavigateBuilder {

    private final NavigateSpecs navigateSpecs;

    public NavigateBuilder() {
        navigateSpecs = new NavigateSpecs();
        navigateSpecs.setNavigationListeners(new ArrayList<>());
    }

    /**
     * Specifies the navigation's destination url.
     *
     * @param url destination url
     * @return a self-reference
     */
    public NavigateBuilder to(String url) {
        navigateSpecs.setUrl(url);
        navigateSpecs.setToLocation(false);
        return this;
    }

    /**
     * Specifies the navigation's destination fragment.
     *
     * @param fragment destination fragment
     * @return a self-reference
     */
    public NavigateBuilder toLocation(String fragment) {
        navigateSpecs.setUrl(fragment);
        navigateSpecs.setToLocation(true);
        return this;
    }

    /**
     * Will perform the navigation in a new tab.
     *
     * @return a self-reference
     */
    public NavigateBuilder inNewTab() {
        navigateSpecs.setInNewTab(true);
        return this;
    }

    /**
     * Will try to perform the navigation in a popup.
     *
     * @return a self reference
     */
    public NavigateBuilder tryToOpenAsPopup() {
        navigateSpecs.setTryAsPopup(true);
        return this;
    }

    /**
     * Adds a listener to be executed upon navigation.
     *
     * @param listener the listener to be executed upon navigation
     * @return a self reference
     */
    public NavigateBuilder withListener(NavigationListener listener) {
        navigateSpecs.addListener(listener);
        return this;
    }

    /**
     * Builds and performs the navigation right away.
     */
    public void go() {
        build().perform();
    }

    /**
     * Builds the navigation to be performed later on.
     *
     * @return the navigation ready to be performed
     */
    public NavigateExecutor build() {
        return new NavigateExecutor(navigateSpecs);
    }
}