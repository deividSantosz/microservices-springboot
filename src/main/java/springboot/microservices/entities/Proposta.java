package springboot.microservices.entities;
import jakarta.persistence.*;

@Entity
public class Proposta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double valorSolicitado;
    private Integer prazoPagamento;
    private Boolean aprovada;
    private boolean integrada;
    private String observacao;
    @OneToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;
}