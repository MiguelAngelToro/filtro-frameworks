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
public class ClassRequest {

    @NotBlank(message = "El nombre es requerido")
    @Size(min = 3, max = 100)
    private String name;
    @NotBlank(message = "La descripcion es requerida")
    @Size(min = 3, max = 100)
    private String description;
    
}
