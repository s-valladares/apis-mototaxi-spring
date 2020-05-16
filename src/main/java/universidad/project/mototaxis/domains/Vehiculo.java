package universidad.project.mototaxis.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import universidad.project.mototaxis.config.AuditModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "vehiculos")
public class Vehiculo extends AuditModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn
    @JsonIgnoreProperties({ "updatedAt", "hibernateLazyInitializer", "handler" })
    private Usuario usuario;

    private String color;
    private String modelo;
    private String placa;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn
    @JsonIgnoreProperties({ "updatedAt", "hibernateLazyInitializer", "handler" })
    public Piloto piloto;
}
