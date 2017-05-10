package be.thibaulthelsmoortel.navigationbuilder;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Annotation for quick creation of {@link NavigationBuilder} fields.
 *
 * @author Thibault helsmoortel
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Navigation {

    String url();

    boolean inNewTab() default false;

    boolean tryAsPopup() default false;

    boolean toLocation() default false;

    boolean reload() default false;

    boolean toPrevious() default false;

    boolean toNext() default false;

}
