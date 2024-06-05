package com.riwi.filtro.api.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StudentRequest {

    @NotBlank(message = "El nombre es requelido")
    @Size(min = 3, max = 100)
    private String name;
    @NotBlank(message = "El email es requerido")
    @Size(min = 1, max = 100, message = "El email debe tener entre 1 y 100 caracteres")
    private String email;
    
}

