package github.victtorrribeiro.testepraticovendas.service.impl;

import github.victtorrribeiro.testepraticovendas.domain.entity.Venda;
import github.victtorrribeiro.testepraticovendas.domain.entity.Vendedor;
import github.victtorrribeiro.testepraticovendas.domain.repository.VendaRepository;
import github.victtorrribeiro.testepraticovendas.domain.repository.VendedorRepository;
import github.victtorrribeiro.testepraticovendas.rest.dto.VendaDTO;
import github.victtorrribeiro.testepraticovendas.service.VendaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VendaSeriveceImpl implements VendaService {

    private final VendaRepository repository;
    private final VendedorRepository vendedorRepository;


    @Override
    @Transactional
    public Venda criarVenda(Venda venda) {

        return repository.save(venda);
    }
}
