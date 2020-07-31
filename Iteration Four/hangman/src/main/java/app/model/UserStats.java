package app.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_stats")
@Data
@NoArgsConstructor
public class UserStats {

	@Id
	@GeneratedValue(generator = "UUID")
	  @GenericGenerator(
	          name = "UUID",
	          strategy = "org.hibernate.id.UUIDGenerator"
	  )
    @Column(name = "user_stats_id")
	private String id;
	@Column(name = "score")
	private int score;
	@Column(name = "word")
	private String word;
	@Column(name = "id_user_stats", insertable =false, updatable =false)
	private String idUserStats;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "id_user_stats")
	private User user;
}
