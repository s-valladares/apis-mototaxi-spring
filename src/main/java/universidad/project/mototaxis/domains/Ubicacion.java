package universidad.project.mototaxis.domains;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import universidad.project.mototaxis.config.AuditModel;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ubicaciones")
public class Ubicacion implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn
    @JsonIgnoreProperties({ "updatedAt", "hibernateLazyInitializer", "handler" })
    private Usuario usuario;

    private Long latitud;
    private Long longitud;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Long getLatitud() {
        return latitud;
    }

    public void setLatitud(Long latitud) {
        this.latitud = latitud;
    }

    public Long getLongitud() {
        return longitud;
    }

    public void setLongitud(Long longitud) {
        this.longitud = longitud;
    }

    private static final long serialVersionUID = 1L;
}
