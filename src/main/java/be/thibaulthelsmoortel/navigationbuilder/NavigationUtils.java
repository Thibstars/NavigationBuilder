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
    public static NavigationBuilder navigate() {
        return new NavigationBuilder();
    }


    /**
     * Returns a pre-configured reload navigation.
     *
     * @return a pre-configured reload navigation
     */
    public static NavigationBuilder createReloadNavigation() {
        NavigationBuilder navigationBuilder = new NavigationBuilder();
        navigationBuilder.reload();
        return navigationBuilder;
    }

    /**
     * Returns a pre-configured back navigation.
     *
     * @return a pre-configured back navigation
     */
    public static NavigationBuilder createBackNavigation() {
        NavigationBuilder navigationBuilder = new NavigationBuilder();
        navigationBuilder.toPrevious();
        return navigationBuilder;
    }

    /**
     * Returns a pre-configured next navigation.
     *
     * @return a pre-configured next navigation
     */
    public static NavigationBuilder createNextNavigation() {
        NavigationBuilder navigationBuilder = new NavigationBuilder();
        navigationBuilder.toNext();
        return navigationBuilder;
    }
}