package app.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class GameStats {

	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "game_stats_id")
	private String id;
	@Column
	private boolean isWordFound;
	@Column
	private int wrongTries;
	@Column
	private LocalDate gameStart;
	@Column
	private LocalDate gameEnd;
	@Column(name = "game_id", insertable = false, updatable = false)
	private String gameId;
	@OneToOne(fetch = FetchType.EAGER, optional = false, cascade = CascadeType.ALL)
	@JoinColumn(name = "game_id", referencedColumnName = "game_id")
	private Game game;
	
}
