package cl.com.javdev.domain;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="trucks")
@SQLDelete(sql = "UPDATE trucks SET is_delete=true, delete_at=now() WHERE id_trucks=?")
@Where(clause = "is_delete = false")
public class Trucks implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTrucks;
    @NotEmpty(message = "El codigo no puede estar vacio")
    private String code;
    private boolean enabled;
    private boolean isDelete = false;
    private LocalDateTime deleteAt;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_drivers")
    private Driver drivers;
    @OneToMany(mappedBy = "trucks", fetch = FetchType.LAZY)
    private List<Packages> packagesList;
}
