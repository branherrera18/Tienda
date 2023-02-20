package com.tienda.repository;

import com.tienda.entity.Pais;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository                             //Java Generics -> no indica el tipo de dato que vamos a utilizar hasta usarlo
public interface PaisRepository extends CrudRepository<Pais, Long> {
    
}
