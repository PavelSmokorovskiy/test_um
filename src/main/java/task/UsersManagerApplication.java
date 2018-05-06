package task;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import task.model.Gender;
import task.model.User;
import task.model.UserProfile;
import task.repository.UserProfileRepository;
import task.repository.UserRepository;

import java.util.Calendar;

@SpringBootApplication
@ComponentScan("task")
public class UsersManagerApplication implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserProfileRepository userProfileRepository;

    public static void main(String[] args) {
        SpringApplication.run(UsersManagerApplication.class, args);
    }

    @Override
    public void run(String... args) {

        userRepository.deleteAllInBatch();
        userProfileRepository.deleteAllInBatch();

        User user = User.builder()
                .loginEmail("pavel.smokorovskiy@zaelab.com")
                .password("1")
                .build();

        Calendar dateOfBirth = Calendar.getInstance();
        dateOfBirth.set(1984, Calendar.JULY, 12);

        UserProfile userProfile = UserProfile.builder()
                .firstName("Pavel")
                .lastName("Smokorovskiy")
                .dateOfBirth(dateOfBirth.getTime())
                .gender(Gender.MALE)
                .address("Kharkivske highway")
                .about("Java Junior Developer")
                .build();

        user.setUserProfile(userProfile);
        userProfile.setUser(user);
        userRepository.save(user);

    }
}
