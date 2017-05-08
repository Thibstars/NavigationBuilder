package be.thibaulthelsmoortel.navigationbuilder;

/**
 * Utilities to perform navigation operations.
 *
 * @author Thibault Helsmoortel
 */
public class NavigationUtils {

    /**
     * Returns a builder for navigation creation.
     *
     * @return the builder for navigation creation
     */
    public static NavigateBuilder navigate() {
        return new NavigateBuilder();
    }


    /**
     * Returns a pre-configured reload navigation.
     *
     * @return a pre-configured reload navigation
     */
    public static NavigateBuilder createReloadNavigation() {
        NavigateBuilder navigateBuilder = new NavigateBuilder();
        navigateBuilder.reload();
        return navigateBuilder;
    }

    /**
     * Returns a pre-configured back navigation.
     *
     * @return a pre-configured back navigation
     */
    public static NavigateBuilder createBackNavigation() {
        NavigateBuilder navigateBuilder = new NavigateBuilder();
        navigateBuilder.toPrevious();
        return navigateBuilder;
    }

    /**
     * Returns a pre-configured next navigation.
     *
     * @return a pre-configured next navigation
     */
    public static NavigateBuilder createNextNavigation() {
        NavigateBuilder navigateBuilder = new NavigateBuilder();
        navigateBuilder.toNext();
        return navigateBuilder;
    }
}