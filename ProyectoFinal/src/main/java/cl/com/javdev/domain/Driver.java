package cl.com.javdev.domain;

import lombok.Data;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "drivers")
@SQLDelete(sql = "UPDATE drivers SET is_delete=true, delete_at=now() WHERE id_drivers=?")
@Where(clause = "is_delete = false")

public class Driver implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDrivers;
    @NotEmpty
    private String code;
    @NotEmpty
    private String name;
    @NotNull (message = "campo no nulo")
    private String cellphone;
    @Email
    private String email;
    private boolean enabled;
    @Column(name = "is_delete")
    private boolean isDelete = Boolean.FALSE;
    private LocalDateTime delete_at;
    @OneToMany(mappedBy = "drivers", fetch = FetchType.LAZY)
    private List<Trucks> truckList;


}
