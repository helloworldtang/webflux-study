package com.tangcheng.webflux.mongo.repository;

import com.tangcheng.webflux.mongo.domain.Person;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

/**
 * @author tangcheng
 * 2017/11/24
 */
@Repository
@Primary
public interface PersonRepository extends ReactiveMongoRepository<Person, Long> {
}
