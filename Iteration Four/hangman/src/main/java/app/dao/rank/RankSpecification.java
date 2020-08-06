package app.dao.rank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import app.model.Rank;

public class RankSpecification implements Specification<Rank> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<SearchCriteria> list;

	public RankSpecification() {
		this.list = new ArrayList<>();
	}

	public void add(SearchCriteria criteria) {
		list.add(criteria);
	}

	@Override
	public Predicate toPredicate(Root<Rank> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
		List<Predicate> predicates = new ArrayList<Predicate>();

		for (SearchCriteria criteria : list) {

			switch (criteria.getOperation()) {
			case GREATER_THAN:
				predicates
						.add(criteriaBuilder.greaterThan(root.get(criteria.getKey()), criteria.getValue().toString()));
				break;
			case LESS_THAN:
				predicates.add(criteriaBuilder.lessThan(root.get(criteria.getKey()), criteria.getValue().toString()));
				break;
			case GREATER_THAN_EQUAL:
				predicates.add(criteriaBuilder.greaterThanOrEqualTo(root.get(criteria.getKey()),
						(LocalDate) criteria.getValue()));
				break;
			case LESS_THAN_EQUAL:
				predicates.add(criteriaBuilder.lessThanOrEqualTo(root.get(criteria.getKey()),
						(LocalDate) criteria.getValue()));
				break;
			case NOT_EQUAL:
				predicates.add(criteriaBuilder.notEqual(root.get(criteria.getKey()), criteria.getValue()));
				break;
			case EQUAL:
				predicates.add(criteriaBuilder.equal(root.get(criteria.getKey()), criteria.getValue()));
				break;
			case IN:
				predicates.add(criteriaBuilder.in(root.get(criteria.getKey())).value(criteria.getValue()));
				break;
			case NOT_IN:
				predicates.add(criteriaBuilder.not(root.get(criteria.getKey())).in(criteria.getValue()));
				break;
			default:
				break;
			}

		}

		return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	}

}