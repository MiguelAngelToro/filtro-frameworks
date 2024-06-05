package com.riwi.filtro.api.dto.response;

import java.time.LocalDateTime;

import com.riwi.filtro.utils.enums.MultimediaType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MultimediaBasicResp {

    private Long id;
    private MultimediaType multimediaType;
    private String url;
    private LocalDateTime createdAt;
    private boolean active;
    
}
