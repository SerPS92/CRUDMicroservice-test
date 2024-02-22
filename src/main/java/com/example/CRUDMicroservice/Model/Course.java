package com.example.CRUDMicroservice.Model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Course {

    private String name;
    private int duration;
    private String timetable;
}
