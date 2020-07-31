package app.model;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ranks")
@Getter
@Setter
@NoArgsConstructor
public class Rank {
	
	@Id
	@GeneratedValue(generator = "UUID")
	@GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "rank_id")
	private String id;
	@Column(name = "id_user_rank", insertable =false, updatable =false)
	private String idUserRank;
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "id_user_rank")
	private User user;
	@Column(name = "word")
	private String word;
	@Column(name = "score")
	private int score;
	@Column(name = "date_game")
	private LocalDate date;
	
}
