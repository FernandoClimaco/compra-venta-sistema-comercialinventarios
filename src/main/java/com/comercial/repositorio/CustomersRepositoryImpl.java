package com.comercial.repositorio;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.comercial.entidades.CustomersEntity;

public class CustomersRepositoryImpl {
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public static final String GREATER_THAN="greater";
	public static final String LESS_THAN="less";
	public static final String EQUAL="equal";
	
	
	
	
	public List<CustomersEntity> getData(HashMap<String, Object> conditions)
	{
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
		CriteriaQuery<CustomersEntity> query= cb.createQuery(CustomersEntity.class);
		Root<CustomersEntity> root = query.from(CustomersEntity.class);
		
		List<Predicate> predicates = new ArrayList<>();
		conditions.forEach((field,value) ->
		{
			switch (field)
			{
				case "id":
					predicates.add(cb.equal(root.get(field), (Integer)value));
					break;
				case "name":
					predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
					break;
				case "address":
					predicates.add(cb.like(root.get(field),"%"+(String)value+"%"));
					break;
				case "created":
					String dateCondition=(String) conditions.get("dateCondition");					
					switch (dateCondition)
					{
						case GREATER_THAN:
							predicates.add(cb.greaterThan(root.<Date>get(field),(Date)value));
							break;
						case LESS_THAN:
							predicates.add(cb.lessThan(root.<Date>get(field),(Date)value));
							break;
						case EQUAL:
							predicates.add(cb.equal(root.<Date>get(field),(Date)value));
							break;
					}
					break;
			}
			
		});
		query.select(root).where(predicates.toArray(new Predicate[predicates.size()]));
		return entityManager.createQuery(query).getResultList(); 		
	}

}
