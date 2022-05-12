package com.example.mitarbeiterverwaltungapp.repository;



import com.example.mitarbeiterverwaltungapp.Entities.Mitarbeiter;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.RepositoryDefinition;

@RepositoryDefinition(domainClass = Mitarbeiter.class , idClass = Long.class)
public interface MitarbeiterRepository extends CrudRepository<Mitarbeiter,Long> {
}
