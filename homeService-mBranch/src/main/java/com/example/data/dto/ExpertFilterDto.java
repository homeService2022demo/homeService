package com.example.data.dto;

import lombok.Data;
import lombok.ToString;

/**
 * @author fh.kazemi
 **/
@Data
@ToString
public class ExpertFilterDto {
    private String name;
    private String surname;
    private String email;
    private double score;
    private String subServiceName;
}
