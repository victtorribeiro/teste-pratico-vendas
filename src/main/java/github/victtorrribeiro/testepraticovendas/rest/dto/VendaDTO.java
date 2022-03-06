package github.victtorrribeiro.testepraticovendas.rest.dto;

import github.victtorrribeiro.testepraticovendas.domain.entity.Vendedor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@Builder
public class VendaDTO {

    private Integer vendedor_id;
    private LocalDate dataVenda;
    private BigDecimal valor;


}
