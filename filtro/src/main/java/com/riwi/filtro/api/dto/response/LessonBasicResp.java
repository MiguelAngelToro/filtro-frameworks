package com.riwi.filtro.api.dto.response;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LessonBasicResp {
    
    private Long id;
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private boolean active;
}
