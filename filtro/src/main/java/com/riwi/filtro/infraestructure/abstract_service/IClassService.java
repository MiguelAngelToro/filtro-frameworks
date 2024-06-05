package com.riwi.filtro.infraestructure.abstract_service;

import com.riwi.filtro.api.dto.request.ClassRequest;
import com.riwi.filtro.api.dto.response.ClassResp;

public interface IClassService extends CrudService<ClassRequest, ClassResp, Long> {

    public String FIELD_BY_SORT = "name";
    
}
