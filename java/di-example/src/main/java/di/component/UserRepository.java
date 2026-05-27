package di.component;

import di.annotations.Component;

@Component
public class UserRepository {
    public void save() {
        System.out.println("Saving user...");
    }
}