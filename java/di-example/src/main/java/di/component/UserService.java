package di.component;

import di.annotations.Autowired;
import di.annotations.Component;

@Component
public class UserService {
    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public void register() {
        repository.save();
        System.out.println("User registered");
    }
}
