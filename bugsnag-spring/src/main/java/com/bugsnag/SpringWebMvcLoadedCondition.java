package com.bugsnag;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * Check whether spring-webmvc is available to the application.
 */
class SpringWebMvcLoadedCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context,
                           AnnotatedTypeMetadata metadata) {
        ResourceLoader loader = context.getResourceLoader() == null
                ? new DefaultResourceLoader() : context.getResourceLoader();
        return loader != null
                && context.getClassLoader().getResource("org/springframework/web/servlet") != null;
    }
}