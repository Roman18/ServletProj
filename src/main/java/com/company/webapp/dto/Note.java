package com.company.webapp.dto;

import lombok.Data;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;


@Data
@Accessors(chain = true)
public class Note {
    private Integer id;
    private String name;
    private String description;
    private LocalDateTime time;
}
