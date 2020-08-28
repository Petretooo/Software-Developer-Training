package app.dao.rank;

import java.time.LocalDate;

import org.springframework.data.jpa.domain.Specification;

import app.model.Ranking;
import app.model.Ranking_;

public class RankingSpecification {
	
	public static Specification<Ranking> greaterThanEq(LocalDate date){
		return (root, cq, cb) -> {
			return cb.greaterThanOrEqualTo(root.get(Ranking_.date), date);
		};
	}
	
	public static Specification<Ranking> lessThanEq(LocalDate date){
		return (root, cq, cb) -> {
			return cb.lessThanOrEqualTo(root.get(Ranking_.date), date);
		};
	}

}
