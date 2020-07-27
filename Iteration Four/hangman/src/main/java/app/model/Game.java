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
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;



@Entity
@Table(name = "games")
@Getter 
@Setter
@NoArgsConstructor
public class Game {
  
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(
          name = "UUID",
          strategy = "org.hibernate.id.UUIDGenerator"
  )
  @Column(name = "game_id")
  private String id;
  @Column(name = "number_tries")
  private int numberTries;
  @Column(name = "current_word")
  private String currentWord;
  @Column(name = "hidden_word")
  private char[] hiddenWord;
  
  @OneToMany(mappedBy = "game", cascade = CascadeType.ALL)
  private Set<Character> characters;
  
  @ManyToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "id_user_game")
  private User user;
  
  @OneToOne(mappedBy = "game", targetEntity = GameStats.class)
  private GameStats gameStats;
  
  
  public void add(Character character) {
	  if(characters == null) {
		  characters = new HashSet<Character>();
	  }
	  characters.add(character);
	  character.setGame(this);
  }
}



