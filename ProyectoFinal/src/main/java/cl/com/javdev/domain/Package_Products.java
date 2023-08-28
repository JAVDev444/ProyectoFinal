package cl.com.javdev.domain;

import lombok.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name="package_products")
@SQLDelete(sql = "UPDATE package_products SET is_delete=true, delete_at=now() WHERE id_products=?")
@Where(clause = "is_delete = false")
public class Package_Products implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProducts;
    @NotEmpty
    private String code;
    @NotNull
    private double weight;
    @NotEmpty
    private String sku;
    @NotNull
    private Integer quantity;
    private boolean isDelete = false;
    private LocalDateTime delete_at;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="id_packages")
    private Packages packages;
}
