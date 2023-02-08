package com.tienda.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import java.io.Serializable;
import org.springframework.data.annotation.Id;

        
@Entity
@Table (name="paises")
public class Pais implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
    private long id;
    private String pais;

    public long getId() {
        return id;
    }

    public String getPais() {
        return pais;
    }
    
    public void setId(long id) {
        this.id = id;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    
    
}
