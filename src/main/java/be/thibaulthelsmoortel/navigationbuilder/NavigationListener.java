package be.thibaulthelsmoortel.navigationbuilder;

/**
 * Interface for listening to {@link NavigationEvent}.
 *
 * @author Thibault Helsmoortel
 */
public interface NavigationListener {

    void navigationPerformed(NavigationEvent event);
}
