package di.container;

import di.annotations.Autowired;
import di.annotations.Component;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class ApplicationContext {
    private final Map<Class<?>, Object> beans = new HashMap<>();

    public ApplicationContext(Set<Class<?>> componentClasses) {
        for (Class<?> clazz : componentClasses) {
            createBean(clazz);
        }
    }

    private Object createBean(Class<?> clazz) {
        if (beans.containsKey(clazz)) {
            return beans.get(clazz);
        }

        try {
            if (!clazz.isAnnotationPresent(Component.class)) {
                throw new RuntimeException(clazz.getName() + "is not a component");
            }

            Constructor<?>[] constructors = clazz.getDeclaredConstructors();

            Constructor<?> targetConstructor = null;

            for (Constructor<?> constructor : constructors) {
                if (constructor.isAnnotationPresent(Autowired.class)) {
                    targetConstructor = constructor;
                    break;
                }
            }

            if (targetConstructor == null) {
                targetConstructor = clazz.getDeclaredConstructor();
            }

            Class<?>[] parameterTypes = targetConstructor.getParameterTypes();

            Object[] dependencies = new Object[parameterTypes.length];

            for (int i = 0; i < parameterTypes.length; i++) {
                dependencies[i] = createBean(parameterTypes[i]);
            }

            Object instance = targetConstructor.newInstance(dependencies);

            beans.put(clazz, instance);

            return instance;

        } catch (Exception e) {
            throw new RuntimeException("Failed to create bean: " + clazz.getName(), e);
        }
    }

    public <T> T getBean(Class<T> clazz) {
        return clazz.cast(beans.get(clazz));
    }
}