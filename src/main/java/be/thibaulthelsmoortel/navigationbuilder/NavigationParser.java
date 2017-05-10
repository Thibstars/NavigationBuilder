package be.thibaulthelsmoortel.navigationbuilder;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Annotation parser for the {@link Navigation} annotation.
 *
 * @author Thibault Helsmoortel
 */
public class NavigationParser {

    /**
     * Parses the {@link Navigation} annotation for the given object.
     *
     * @param o the object from which to parse the annotation
     * @throws IllegalAccessException when annotated fields can't be accessed
     */
    public static void parse(Object o) throws IllegalAccessException {
        Class clazz = o.getClass();

        for (Field field : Arrays.stream(clazz.getDeclaredFields()).filter(f -> f.getType().equals(NavigationBuilder.class)).collect(Collectors.toList())) {
            Navigation navigation = field.getAnnotation(Navigation.class);
            NavigationBuilder builder = new NavigationBuilder();

            if (navigation.reload()) {
                builder.reload();
            } else if (navigation.toPrevious()) {
                builder.toPrevious();
            } else if (navigation.toNext()) {
                builder.toNext();
            } else {
                if (navigation.inNewTab()) {
                    builder.inNewTab();
                }
                if (navigation.tryAsPopup()) {
                    builder.tryToOpenAsPopup();
                }
                if (navigation.toLocation()) {
                    builder.toLocation(navigation.url());
                } else {
                    builder.to(navigation.url());
                }
            }

            field.set(o, builder);
        }
    }
}
