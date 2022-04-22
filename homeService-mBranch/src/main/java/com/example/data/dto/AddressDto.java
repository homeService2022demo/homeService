package com.example.data.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressDto {
    private String province;
    private String city;
    private String street;
    private String alley;
    private String no;
    private String zipcode;
    private String unitNumber;
}
