package github.victtorrribeiro.testepraticovendas.entity.repository;

import github.victtorrribeiro.testepraticovendas.domain.entity.Vendedor;
import github.victtorrribeiro.testepraticovendas.domain.repository.VendedorRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
public class VendedorRepositoryTest {

    @Autowired
    VendedorRepository repository;

    @Test
    public void DevePersistirUmVendedorNaBaseDeDados(){
        Vendedor vendedor = Vendedor.builder().nome("Victor").build();

        Vendedor vendedorSalvo = repository.save(vendedor);

        Assertions.assertThat(vendedorSalvo.getNome()).isNotNull();
    }

}
