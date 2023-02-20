package com.tienda.service;

import com.tienda.entity.Pais;
import java.util.List;

public interface IPaisService {
    //trae la lista de paises que esta en la db
    public List<Pais> listCountry();
    
}
