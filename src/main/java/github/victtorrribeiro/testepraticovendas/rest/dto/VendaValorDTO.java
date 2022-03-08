package github.victtorrribeiro.testepraticovendas.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VendaValorDTO {

    private String nome_vendedor;
    private double valor_total;
    private double media_diaria;


}
