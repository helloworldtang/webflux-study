package com.tangcheng.webflux.mongo.controller;

import com.tangcheng.webflux.mongo.domain.Person;
import com.tangcheng.webflux.mongo.repository.PersonRepository;
import org.reactivestreams.Publisher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.SortDefault;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author tangcheng
 * 2017/11/24
 */
@RestController
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping("/")
    public String index() {
        return "welcome!";
    }

    @PostMapping("/person")
    public Mono<Void> add(@RequestBody Publisher<Person> person) {
        return personRepository.insert(person).then();
    }


    @GetMapping("/person/{person}")
    public Mono<Person> getById(@PathVariable Long person) {
        return personRepository.findById(person);
    }


    @GetMapping("/person/list")
    public Flux<Person> list() {
        return personRepository.findAll();
    }

    @DeleteMapping("/person/{person}")
    public Mono<Void> remove(@PathVariable Long person) {
        return personRepository.deleteById(person);
    }


}
