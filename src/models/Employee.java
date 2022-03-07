package models;

import lombok.*;

import java.time.LocalDate;
@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @EqualsAndHashCode.Include
    private Long id;
    private String name;
    private double salary;
    private LocalDate hireDate;
}
