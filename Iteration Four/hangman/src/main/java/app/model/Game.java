package app.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Game {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "game_id")
	private String id;
	@Column
	private int numberTries;
	@Column
	private String currentWord;
	@Column
	private char[] hiddenWord;

	@OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
	private Set<Symbol> characters;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToOne(mappedBy = "game")
	private GameStats gameStats;

	public void add(Symbol character) {
		if (characters == null) {
			characters = new HashSet<Symbol>();
		}
		characters.add(character);
		character.setGame(this);
	}
}
