package com.enesseven.cvfrom.database.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CvDto {

    private long id;
    private String name;
    private  String surname;
    private  String email;
    private String message;

    public CvDto(long id, String name, String surname,String message) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.message = message;
    }

}
