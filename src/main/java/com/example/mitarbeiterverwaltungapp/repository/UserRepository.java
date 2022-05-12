package com.example.mitarbeiterverwaltungapp.repository;


import com.example.mitarbeiterverwaltungapp.Entities.User;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.CrudRepository;

@RepositoryDefinition(domainClass= User.class , idClass = Long.class)
public interface UserRepository extends CrudRepository<User,Long> {



}
