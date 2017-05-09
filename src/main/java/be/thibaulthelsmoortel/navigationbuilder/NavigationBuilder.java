package be.thibaulthelsmoortel.navigationbuilder;

/**
 * Builder supporting chained calls.
 *
 * @author Thibault Helsmoortel
 */
public class NavigationBuilder {

    private final NavigationSpecs navigationSpecs;
    private final NavigationExecutor navigationExecutor;

    public NavigationBuilder() {
        navigationSpecs = new NavigationSpecs();
        navigationExecutor = new NavigationExecutor();
    }

    /**
     * Specifies the navigation's destination url.
     *
     * @param url destination url
     * @return a self-reference
     */
    public NavigationBuilder to(String url) {
        navigationSpecs.setUrl(url);
        navigationSpecs.setToLocation(false);
        navigationSpecs.setReload(false);
        navigationSpecs.setToPrevious(false);
        navigationSpecs.setToNext(false);
        navigationSpecs.setNavigationType(NavigationType.URL);
        return this;
    }

    /**
     * Specifies the navigation's destination fragment.
     *
     * @param fragment destination fragment
     * @return a self-reference
     */
    public NavigationBuilder toLocation(String fragment) {
        navigationSpecs.setUrl(fragment);
        navigationSpecs.setToLocation(true);
        navigationSpecs.setNavigationType(NavigationType.LOCATION);
        return this;
    }

    /**
     * Use to perform a refresh navigation.
     *
     * @return a self-reference
     */
    public NavigationBuilder reload() {
        navigationSpecs.setReload(true);
        navigationSpecs.setNavigationType(NavigationType.RELOAD);
        return this;
    }

    /**
     * Use to the previous page in history.
     *
     * @return a self-reference
     */
    public NavigationBuilder toPrevious() {
        navigationSpecs.setToPrevious(true);
        navigationSpecs.setNavigationType(NavigationType.PREVIOUS);
        return this;
    }

    /**
     * Use to navigate to the next page in history.
     *
     * @return a self-reference
     */
    public NavigationBuilder toNext() {
        navigationSpecs.setToNext(true);
        navigationSpecs.setNavigationType(NavigationType.NEXT);
        return this;
    }

    /**
     * Will perform the navigation in a new tab.
     *
     * @return a self-reference
     */
    public NavigationBuilder inNewTab() {
        navigationSpecs.setInNewTab(true);
        return this;
    }

    /**
     * Will try to perform the navigation in a popup.
     *
     * @return a self-reference
     */
    public NavigationBuilder tryToOpenAsPopup() {
        navigationSpecs.setTryAsPopup(true);
        return this;
    }

    /**
     * Adds a listener to be executed upon navigation.
     *
     * @param listener the listener to be executed upon navigation
     * @return a self-reference
     */
    public NavigationBuilder withListener(NavigationListener listener) {
        navigationExecutor.addListener(listener);
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
    public NavigationExecutor build() {
        navigationExecutor.setNavigationSpecs(navigationSpecs);
        return navigationExecutor;
    }
}