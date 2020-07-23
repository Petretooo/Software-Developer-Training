package app.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "game_stats")
@Data
@NoArgsConstructor
public class GameStats {

	@Id
	@GeneratedValue(generator = "UUID")
	  @GenericGenerator(
	          name = "UUID",
	          strategy = "org.hibernate.id.UUIDGenerator"
	  )
    @Column(name = "game_stats_id")
	private String id;
	@Column(name = "is_word_found")
	private boolean isWordFound;
	@Column(name = "remain_tries")
	private int remainTries;
	@Column(name = "seconds")
	private double seconds;
	@Column(name = "start_date")
	private LocalDate startDate;
//	@Column(name = "game_id")
//	private String game_id;
	@OneToOne
	@JoinColumn(name = "game_stats_id", referencedColumnName = "game_id")
	private Game game;
	
}
