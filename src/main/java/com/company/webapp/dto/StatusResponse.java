package com.company.webapp.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.experimental.Accessors;


@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Accessors(chain = true)
public class StatusResponse {
    private String status;
    private Note note;
    private String error;


    @Override
    public String toString() {
        return "{" +
                "status='" + status + '\'' +
                ", note=" + note +
                ", error='" + error + '\'' +
                '}';
    }
}
