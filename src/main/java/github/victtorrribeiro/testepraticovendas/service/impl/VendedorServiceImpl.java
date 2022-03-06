package github.victtorrribeiro.testepraticovendas.service.impl;

import github.victtorrribeiro.testepraticovendas.domain.entity.Vendedor;
import github.victtorrribeiro.testepraticovendas.domain.repository.VendedorRepository;
import github.victtorrribeiro.testepraticovendas.service.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.Optional;

@Service
public class VendedorServiceImpl implements VendedorService {
    @Autowired
    private VendedorRepository repository;

    @Override
    @Transactional
    public Vendedor salvarVendedor(Vendedor vendedor) {

        return repository.save(vendedor);
    }

    @Override
    public Optional<Vendedor> obterPorId(Integer id) {
        return repository.findById(id);
    }
}
