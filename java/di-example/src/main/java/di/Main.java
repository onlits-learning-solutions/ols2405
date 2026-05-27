package di;

import java.util.Set;

import di.component.UserRepository;
import di.component.UserService;
import di.container.ApplicationContext;

public class Main {
    public static void main(String[] args) {
        Set<Class<?>> components = Set.of(
            UserRepository.class,
            UserService.class
        );

        ApplicationContext context = new ApplicationContext(components);

        UserService service = context.getBean(UserService.class);

        service.register();
    }
}
