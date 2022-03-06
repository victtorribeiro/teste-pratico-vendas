package github.victtorrribeiro.testepraticovendas.domain.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@Table
public class Venda {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JoinColumn(name = "vendedor_id")
    private Vendedor vendedor;

    @Column(name = "data_venda")
    private LocalDate dataVenda;
    @Column(scale = 2, precision = 20)
    private BigDecimal valor;

}
