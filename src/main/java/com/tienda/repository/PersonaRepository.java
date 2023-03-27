package com.tienda.repository;

import com.tienda.entity.Persona;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long>{
    
    @Query(value = "select * from personas p where p.apellido1 like %:keyword%", nativeQuery = true)
    List<Persona> findByKeyword(@Param("keyword") String keyword);
    
}
