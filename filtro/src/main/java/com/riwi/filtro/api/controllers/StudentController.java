package com.riwi.filtro.api.controllers;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.riwi.filtro.api.dto.request.StudentRequest;
import com.riwi.filtro.api.dto.response.StudentResp;
import com.riwi.filtro.infraestructure.abstract_service.IStudentService;
import com.riwi.filtro.utils.enums.SortType;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(path = "/students")
@AllArgsConstructor
public class StudentController {

    @Autowired
    private final IStudentService studentService;
    
    @GetMapping
    public ResponseEntity<Page<StudentResp>> getAll(
        @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int size,
        @RequestHeader(required = false) SortType sortType){
            if (Objects.isNull(sortType))
                sortType = SortType.NONE;
            return ResponseEntity.ok(this.studentService.getAll(page -1, size, sortType));
        }


    @PostMapping
    public ResponseEntity<StudentResp> insert(
        @Validated @RequestBody StudentRequest request
    ){
        return ResponseEntity.ok(this.studentService.create(request));
    }
}
