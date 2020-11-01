package fr.formation.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import fr.formation.model.Element;

public interface IElementRepository extends JpaRepository<Element, Integer> {

}
