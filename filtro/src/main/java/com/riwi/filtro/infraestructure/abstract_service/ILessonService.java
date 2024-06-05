package com.riwi.filtro.infraestructure.abstract_service;

import com.riwi.filtro.api.dto.request.LessonRequest;
import com.riwi.filtro.api.dto.response.LessonResp;

public interface ILessonService extends CrudService<LessonRequest, LessonResp, Long> {

    public String FIELD_BY_SORT = "title";
    
}
