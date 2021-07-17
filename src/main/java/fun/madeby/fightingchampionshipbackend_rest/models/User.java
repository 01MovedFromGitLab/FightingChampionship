package fun.madeby.fightingchampionshipbackend_rest.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Getter
@Setter
public class User {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
@NotBlank
@Column(name = "UserName", columnDefinition = "VARCHAR(50) NOT NULL")
private String userName;
@NotBlank
@Column(name = "Password", columnDefinition = "VARCHAR(500) NOT NULL")
private String password;
@NotBlank
@Column(name = "FirstName", columnDefinition = "VARCHAR(50) NOT NULL")
private String firstName;
@NotBlank
@Column(name = "LastName", columnDefinition = "VARCHAR(50) NOT NULL")
private String lastName;
@NotBlank
@Column(name = "Age", columnDefinition = "INT NOT NULL")
private Integer age;
@NotBlank
@Column(name = "Country", columnDefinition = "VARCHAR(50) NOT NULL")
private String country;

public User() {
}

public User(String userName, String password, String firstName, String lastName, Integer age, String country) {
	this.userName = userName;
	this.password = password;
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
	this.country = country;
}

@Override
public boolean equals(Object o) {
	if (this == o) return true;
	if (o == null || getClass() != o.getClass()) return false;
	User user = (User) o;
	return Objects.equals(id, user.id);
}

@Override
public int hashCode() {
	return Objects.hash(id);
}
}
