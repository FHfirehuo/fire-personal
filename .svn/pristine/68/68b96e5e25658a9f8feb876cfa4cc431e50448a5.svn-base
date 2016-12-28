package com.ciecc.fire.personal.backstage.security;

import java.io.Serializable;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

public interface PagingAndSortingRepository<T, ID extends Serializable> extends CrudRepository<T, ID> {

	Iterable<T> findAll(Sort sort);

	Page<T> findAll(Pageable pageable);
	
	/*PagingAndSortingRepository<User, Long> repository = // … get access to a bean
			Page<User> users = repository.findAll(new PageRequest(1, 20));*/
}
