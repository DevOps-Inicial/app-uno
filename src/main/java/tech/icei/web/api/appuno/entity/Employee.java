package tech.icei.web.api.appuno.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", unique = true, nullable = false)
    private Long employeeId;

    @Column(name = "nombre_completo", length = 85)
    private String nombreCompleto;

    @Column(length = 200)
    private String direccion;

    @Column(name = "puesto_asignado", length = 85)
    private String puestoAsignado;
}
