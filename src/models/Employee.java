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
    private LocalDate birthDate;
    private double salary;
    private LocalDate hireDate;
    private Integer managerId;
}
