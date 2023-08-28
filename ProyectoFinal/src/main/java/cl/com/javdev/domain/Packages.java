package cl.com.javdev.domain;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;


@Getter
@Setter
@Entity
@Table(name="packages")
@SQLDelete(sql = "UPDATE packages SET is_delete=true, delete_at=now() WHERE id_packages=?")
@Where(clause = "is_delete = false")
public class Packages implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idPackages;
    @NotEmpty
    private String code;
    @NotNull
    private double weight;
    private LocalDateTime schedule;
    @Column(length = 100)
    @Enumerated(EnumType.STRING)
    private StatusType statusType = StatusType.LOADED;

    private boolean isDelete = false;
    private LocalDateTime delete_at;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_trucks")
    private Trucks trucks;
    @OneToMany(mappedBy = "packages", fetch = FetchType.LAZY)
    private List<Package_Products> packages_ProductList;
}
