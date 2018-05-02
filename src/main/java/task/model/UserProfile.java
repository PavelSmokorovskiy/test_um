package task.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Pavel Smokorovskiy on 02.05.18
 */

@Entity
@Table(name = "users_profile")
@Data
@Builder
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long id;

    @Column(name = "first_name")
    @Size(max = 20)
    private String firstName;

    @Column(name = "last_name")
    @Size(max = 20)
    private String lastName;

    @Temporal(TemporalType.DATE)
    @Column(name = "dob")
    private Date dateOfBirth;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(length = 6)
    private Gender gender;

    @Column(name = "address")
    @Size(max = 100)
    private String address;

    @Column(name = "about")
    @Size(max = 200)
    private String about;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

}
