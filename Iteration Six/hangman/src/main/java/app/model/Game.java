package app.model;

import java.util.HashSet;
import java.util.Set;

import javax.json.bind.annotation.JsonbProperty;
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
import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Game extends RepresentationModel<Game> {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "game_id")
	@JsonProperty("Id")
	private String id;
	@Column
	@JsonProperty("tries")
	private int numberTries;
	@Column
	@JsonProperty("currentWord")
	private String currentWord;
	@Column
	@JsonProperty("hiddenWord")
	private char[] hiddenWord;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "game_id")
	@JsonProperty("Characters")
	private Set<Symbol> characters;

	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "user_id")
	@JsonIgnore
	private User user;

	@OneToOne(mappedBy = "game")
	@JsonIgnore
	private GameStats gameStats;

}
