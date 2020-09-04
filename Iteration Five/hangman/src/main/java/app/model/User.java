package app.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column
	private String userId;
	@Column
	private String username;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@NonNull
	Set<Game> games;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<UserStats> userStats;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL )
	private Set<Ranking> rank;
	
	
}
