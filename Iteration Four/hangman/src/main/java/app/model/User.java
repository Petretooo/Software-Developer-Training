package app.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
public class User {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "user_id")
	private String userId;
	@Column(name = "username")
	private String username;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	@NonNull
	Set<Game> games;
	
	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<UserStats> userStats;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL )
	private Set<Rank> rank;
	
	
//	public void addGame(Game game) {	
//		if (games == null) {
//			games = new HashSet<Game>();
//		}
//		games.add(game);
////		game.setUser(this);
//	}
//	
//	public void addStats(UserStats userStat) {
//		if (userStats == null) {
//			userStats = new HashSet<UserStats>();
//		}
//		userStats.add(userStat);
//		userStat.setUser(this);
//	}
}
