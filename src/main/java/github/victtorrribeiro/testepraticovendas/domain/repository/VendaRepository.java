package github.victtorrribeiro.testepraticovendas.domain.repository;

import github.victtorrribeiro.testepraticovendas.domain.entity.Venda;
import github.victtorrribeiro.testepraticovendas.domain.entity.Vendedor;
import github.victtorrribeiro.testepraticovendas.rest.dto.VendaDTO;
import github.victtorrribeiro.testepraticovendas.rest.dto.VendaValorDTO;
import org.apache.tomcat.jni.Local;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface VendaRepository extends JpaRepository<Venda, Long> {


    @Query(value = "SELECT * FROM Venda v WHERE v.vendedor_id = :vendedor_id AND v.data_venda BETWEEN :data_inicial AND :data_final", nativeQuery = true)
    List<Venda> findByDataByVendedor(
            @Param("vendedor_id") Integer vendedor_id,
            @Param("data_inicial") LocalDate data_inicial,
            @Param("data_final") LocalDate data_final
            );

    @Query(value = "SELECT * FROM Venda v WHERE v.data_venda BETWEEN :data_inicial AND :data_final", nativeQuery = true)
    List<Venda> findByValorVendas(
            @Param("data_inicial") LocalDate data_inicial,
            @Param("data_final") LocalDate data_final
            );

    List<Venda> findByVendedor_id(Integer id);

}
