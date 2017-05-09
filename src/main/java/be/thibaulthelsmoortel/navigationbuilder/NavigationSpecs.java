package be.thibaulthelsmoortel.navigationbuilder;

import lombok.Data;

/**
 * Stateful class containing navigation data.
 *
 * @author Thibault Helsmoortel
 */
@Data
class NavigationSpecs {

    private String url;
    private boolean inNewTab;
    private boolean tryAsPopup;
    private boolean toLocation;
    private boolean reload;
    private boolean toPrevious;
    private boolean toNext;
    private NavigationType navigationType;
}