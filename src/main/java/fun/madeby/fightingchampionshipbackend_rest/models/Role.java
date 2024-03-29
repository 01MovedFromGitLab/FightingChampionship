package fun.madeby.fightingchampionshipbackend_rest.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@JsonIgnoreProperties("users")
public class Role {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@Column(name = "Name", columnDefinition = "VARCHAR(50) UNIQUE NOT NULL")
private String name;
// Sub side of ManyToMany:
@ManyToMany(mappedBy = "roles", fetch = FetchType.EAGER)
private Set<User> users = new HashSet<>();

public void addUser(User user) {
	this.users.add(user);
	if (!user.getRoles().contains(this)) {
		user.addRole(this);
	}
}
}
