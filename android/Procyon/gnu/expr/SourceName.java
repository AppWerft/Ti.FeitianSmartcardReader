// 
// Decompiled by Procyon v0.5.36
// 

package gnu.expr;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Retention;
import java.lang.annotation.Annotation;

@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD })
public @interface SourceName {
    String name();
    
    String prefix() default "";
    
    String uri() default "";
}
