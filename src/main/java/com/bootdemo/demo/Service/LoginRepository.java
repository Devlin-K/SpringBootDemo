package com.bootdemo.demo.Service;

import com.bootdemo.demo.Domain.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoginRepository extends JpaRepository<Person, Long> {

}