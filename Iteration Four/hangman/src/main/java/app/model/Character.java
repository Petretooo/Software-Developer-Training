package app.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "characters")
@Data
@NoArgsConstructor
public class Character {
	
	@Id
	@GeneratedValue(generator = "UUID")
	  @GenericGenerator(
	          name = "UUID",
	          strategy = "org.hibernate.id.UUIDGenerator"
	  )
    @Column(name = "character_id")
	private String characterId;
	@Column(name = "letter")
	private char letter;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_game_character")
	private Game game;
}
