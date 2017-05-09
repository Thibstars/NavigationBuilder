# NavigationBuilder

This is a Vaadin add-on project that you can find in the [Vaadin Directory](https://vaadin.com/directory#!addon/navigationbuilder).

Official releases, examples and implementation instructions can be found over there.

## Summary
This addon provides a builder-style way of programming navigation in Vaadin.

It enriches the existing functionality. No widgetset compiling required.

### Features
1. Builder-style navigation implementations;
2. Open (external) url's in current or new tab;
3. Navigate to url fragments (like '/app');
4. Navigate through browser history (back/next);
5. Make use of pre-configured navigations;
6. Attach your own listeners to be executed upon navigation;
7. Navigate right away, or prepare your navigation and perform it later (or again).

### Examples

Immediate navigation to external url in new tab with listener:
``` java
NavigationUtils.navigate()
                .to("www.google.com")
                .inNewTab()
                .withListener(event1 -> LOGGER.trace("Navigating to external url in a new tab."))
                .go();
```
Immediate navigation to fragment with listener:
``` java
NavigationUtils.navigate()
                    .toLocation("/register")
                    .withListener(e -> LOGGER.trace("Navigating to " + e.getUrl()))
                    .go();
```
Simple pre-configured navigations:
``` java
NavigationUtils.createReloadNavigation().withListener(l -> System.out.println("Page reloaded!")).go(); // Adding a listener to the pre-configured navigation.
NavigationUtils.createBackNavigation().go(); // Go back one page in the browser history
NavigationUtils.createNextNavigation().go(); // Go one page forward in the browser history
```
      
Preparing multiple navigations, adding a listener to them and performing them (note that you probably wouldn't perform multiple navigations at the same time):
``` java
List<NavigationBuilder> navigations = new ArrayList<>();
NavigationBuilder reload = NavigationUtils.navigate().reload();
NavigationBuilder openGoogleInNewTab = NavigationUtils.navigate()
        .to("http://www.google.com")
        .inNewTab();
NavigationListener navigationListener = navigationEvent -> {
    LOGGER.info("Some custom navigation of type: {} was executed.", navigationEvent.getNavigationType());
};
navigations.add(reload);
navigations.add(openGoogleInNewTab);
navigations.forEach(builder -> {
    builder.withListener(navigationListener);
    builder.go();
});
```