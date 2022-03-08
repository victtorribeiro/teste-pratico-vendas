package github.victtorrribeiro.testepraticovendas.service.impl;

import github.victtorrribeiro.testepraticovendas.domain.entity.Venda;
import github.victtorrribeiro.testepraticovendas.domain.entity.Vendedor;
import github.victtorrribeiro.testepraticovendas.domain.repository.VendaRepository;
import github.victtorrribeiro.testepraticovendas.domain.repository.VendedorRepository;
import github.victtorrribeiro.testepraticovendas.rest.dto.VendaValorDTO;
import github.victtorrribeiro.testepraticovendas.service.VendaService;
import github.victtorrribeiro.testepraticovendas.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VendaSeriveceImpl implements VendaService {

    @Autowired
    private VendaRepository repository;
    @Autowired
    private VendedorRepository vendedorRepository;

    private VendedorService vendedorService;


    @Override
    @Transactional
    public Venda criarVenda(Venda venda) {

        return repository.save(venda);
    }

    @Override
    @Transactional
    public List<Venda> consultaByVendedorByData(Integer vendedor_id, LocalDate data_inicial, LocalDate data_final) {

        return repository.findByDataByVendedor(vendedor_id, data_inicial, data_final);

    }

    @Override
    @Transactional
    public List<VendaValorDTO> consultaByVendasVendedor(LocalDate data_inicial, LocalDate data_final) {
        List<Venda> vendasList = repository.findByValorVendas(data_inicial, data_final);
        ArrayList<VendaValorDTO> vendaValorDTOList = new ArrayList<>();;
        List<Vendedor> vendedorList = vendedorRepository.findAll();

        int dias = calculaDias(data_inicial, data_final);

        for (Vendedor vendedor: vendedorList) {
            VendaValorDTO vendaValorDTO = new VendaValorDTO();
            double valorTotal = 0;
            for (Venda v: vendasList) {
                if(vendedor.getId().equals(v.getVendedor().getId())){
                    valorTotal += v.getValor().doubleValue();
                }
            }
            vendaValorDTO.setNome_vendedor(vendedor.getNome());
            vendaValorDTO.setValor_total(valorTotal);
            vendaValorDTO.setMedia_diaria(valorTotal / dias);
            vendaValorDTOList.add(vendaValorDTO);
        }

        return vendaValorDTOList;
    }

    public Integer calculaDias(LocalDate data_inicial, LocalDate data_final){
        LocalDate aux = data_inicial;
        int count = 0;
        while (!data_inicial.isAfter(data_final)){
            data_inicial = data_inicial.plusDays(1);
            count++;
        }
        return count;
    }



    @Override
    @Transactional
    public List<Venda> consultaByVendedor(Integer vendedor_id) {
        return repository.findByVendedor_id(vendedor_id);
    }



}
