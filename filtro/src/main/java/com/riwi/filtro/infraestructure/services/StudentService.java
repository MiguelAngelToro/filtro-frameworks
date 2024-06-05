package com.riwi.filtro.infraestructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.riwi.filtro.api.dto.request.StudentRequest;
import com.riwi.filtro.api.dto.response.StudentResp;
import com.riwi.filtro.domain.entities.Student;
import com.riwi.filtro.domain.repositories.StudentRepository;
import com.riwi.filtro.infraestructure.abstract_service.IStudentService;
import com.riwi.filtro.utils.enums.SortType;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StudentService implements IStudentService {
    
    @Autowired
    private final StudentRepository studentRepository;
    
    @Override
    public StudentResp create(StudentRequest request) {
        Student student = this.requestToEntity(request);

        return this.entityToResp(this.studentRepository.save(student));
        
    }

    @Override
    public StudentResp get(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public StudentResp update(StudentRequest request, Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

    @Override
    public Page<StudentResp> getAll(int page, int size, SortType sortType) {
        
        if (page <0) page = 0;

        PageRequest pagination = null;

        switch (sortType) {
            case NONE -> pagination = PageRequest.of(page, size);
            case ASC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).ascending());
            case DESC -> pagination = PageRequest.of(page, size, Sort.by(FIELD_BY_SORT).descending());
        }
        
        return this.studentRepository.findAll(pagination)
                .map(this::entityToResp);

    
    }

    private StudentResp entityToResp(Student entity) {
        return StudentResp.builder()
            .id(entity.getId())
            .name(entity.getName())
            .email(entity.getEmail())
            .createdAt(entity.getCreatedAt())
            .active(entity.getActive())
            .build();

    }

    private Student requestToEntity(StudentRequest request){
        return Student.builder()
        .name(request.getName())
        .email(request.getEmail())
        .build();
    }
    
}
