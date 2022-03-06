package github.victtorrribeiro.testepraticovendas.domain.repository;

import github.victtorrribeiro.testepraticovendas.domain.entity.Venda;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VendaRepository extends JpaRepository<Venda, Long> {
}
