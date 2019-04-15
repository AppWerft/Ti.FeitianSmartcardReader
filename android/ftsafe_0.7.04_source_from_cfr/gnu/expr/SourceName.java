/*
 * Decompiled with CFR 0.139.
 */
package gnu.expr;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(value=RetentionPolicy.RUNTIME)
@Target(value={ElementType.FIELD})
public @interface SourceName {
    public String name();

    public String prefix() default "";

    public String uri() default "";
}

