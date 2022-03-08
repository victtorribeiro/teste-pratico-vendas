package github.victtorrribeiro.testepraticovendas.entity.repository;

import github.victtorrribeiro.testepraticovendas.domain.entity.Venda;
import github.victtorrribeiro.testepraticovendas.domain.entity.Vendedor;
import github.victtorrribeiro.testepraticovendas.domain.repository.VendaRepository;
import github.victtorrribeiro.testepraticovendas.domain.repository.VendedorRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.math.BigDecimal;
import java.time.LocalDate;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class VendaRepositoryTest {

    @Autowired
    VendaRepository repository;

    @Autowired
    VendedorRepository vendedorRepository;

    @Test
    public void deveCriarUmaVenda(){
        BigDecimal valor = BigDecimal.valueOf(100);
        Vendedor vendedor = Vendedor.builder().id(1).nome("Victor").build();
        Vendedor vendedorSalvo = vendedorRepository.save(vendedor);
        Venda venda = Venda.builder().dataVenda(LocalDate.now()).valor(valor).vendedor(vendedorSalvo).build();

        repository.save(venda);

        Assertions.assertThat(venda.getId()).isNotNull();
    }

//    @Test
//    public void deveRetornarSaldoTotalVendedorMedia(){
//
//
//
//    }

}
