package app.model;

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

import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Table(name = "games")
@Data
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
  @Column(name = "numbers_tries")
  private int numberTries;
  @Column(name = "current_word")
  private String currentWord;
  @Column(name = "hiddenWord")
  private char[] hiddenWord;
  
  @OneToMany(mappedBy = "game", targetEntity = Character.class,
		  fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  private Set<Character> characters;
  @Column(name = "id_user_game", insertable=false, updatable=false)
  private String idUser;
  @ManyToOne
  @JoinColumn(name = "id_user_game", referencedColumnName = "user_id")
  private User user;
  
  @OneToOne(mappedBy = "game", targetEntity = GameStats.class)
  private GameStats gameStats;
}



