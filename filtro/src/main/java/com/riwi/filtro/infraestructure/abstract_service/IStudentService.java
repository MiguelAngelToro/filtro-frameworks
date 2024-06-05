package com.riwi.filtro.infraestructure.abstract_service;

import com.riwi.filtro.api.dto.request.StudentRequest;
import com.riwi.filtro.api.dto.response.StudentResp;

public interface IStudentService extends CrudService<StudentRequest, StudentResp, Long> {

    public String FIELD_BY_SORT = "name";

}