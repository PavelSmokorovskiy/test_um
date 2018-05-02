package task.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Pavel Smokorovskiy on 02.05.18
 */

@Entity
@Table(name = "users")
@Data
@Builder
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Email
    @Size(max = 40)
    @Column(name = "login_email", unique = true)
    private String loginEmail;

    @NotNull
    @Size(max = 20)
    @Column(name = "password")
    private String password;
////
//////    @OneToOne
//    private Set<Role> roles;

    @OneToOne(fetch = FetchType.LAZY,
            cascade =  CascadeType.ALL,
            mappedBy = "user")
    private UserProfile userProfile;

    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
    private boolean emailConfirmation;
    private String activationCode;

}
