package github.victtorrribeiro.testepraticovendas.service;

import github.victtorrribeiro.testepraticovendas.domain.entity.Vendedor;

import java.util.List;
import java.util.Optional;

public interface VendedorService {

    Vendedor salvarVendedor(Vendedor vendedor);

    Optional<Vendedor> obterPorId(Integer id);



}
