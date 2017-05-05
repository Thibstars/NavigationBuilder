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
}