package github.victtorrribeiro.testepraticovendas.service;

import github.victtorrribeiro.testepraticovendas.domain.entity.Venda;
import github.victtorrribeiro.testepraticovendas.rest.dto.VendaValorDTO;

import java.time.LocalDate;
import java.util.List;

public interface VendaService {

    Venda criarVenda(Venda venda);

    List<Venda> consultaByVendedorByData(Integer vendedor_id, LocalDate data_inicial, LocalDate data_final);

    List<VendaValorDTO> consultaByVendasVendedor(LocalDate data_inicial, LocalDate data_final);
    List<Venda> consultaByVendedor(Integer vendedor_id);





}
