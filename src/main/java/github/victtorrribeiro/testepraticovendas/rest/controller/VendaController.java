package github.victtorrribeiro.testepraticovendas.rest.controller;

import github.victtorrribeiro.testepraticovendas.domain.entity.Venda;
import github.victtorrribeiro.testepraticovendas.domain.entity.Vendedor;
import github.victtorrribeiro.testepraticovendas.exception.RegraNegocioException;
import github.victtorrribeiro.testepraticovendas.rest.dto.VendaDTO;
import github.victtorrribeiro.testepraticovendas.service.VendaService;
import github.victtorrribeiro.testepraticovendas.service.VendedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/api/venda")
@RequiredArgsConstructor
public class VendaController {

    private final VendaService service;
    private final VendedorService vendedorService;

    @PostMapping("/salvar")
    public ResponseEntity criarVenda(@RequestBody VendaDTO dto){
        try {
            Venda entity = converter(dto);
            service.criarVenda(entity);
            return new ResponseEntity(entity, HttpStatus.CREATED);
        }catch (RegraNegocioException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }


//
//        try {
//            Venda venda = service.criarVenda(dto);
//            return new ResponseEntity(venda, HttpStatus.CREATED);
//        }catch (Exception e){
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }

//        Venda venda = Venda.builder()
//                .vendedor(dto.getVendedor())
//                .valor(dto.getValor())
//                .dataVenda(LocalDate.now())
//                .build();
//
//        try{
//            Venda vendaCriada = service.criarVenda(venda);
//            return new ResponseEntity(vendaCriada, HttpStatus.CREATED);
//        } catch (Exception e){
//            return ResponseEntity.badRequest().body(e.getMessage());
//        }
    }

    private Venda converter(VendaDTO dto) {
        Venda venda = new Venda();

        venda.setDataVenda(LocalDate.now());
        venda.setValor(dto.getValor());

        Vendedor vendedor = vendedorService.obterPorId(dto.getVendedor_id())
                .orElseThrow(() -> new RegraNegocioException("Vendedor não encontrado"));
        venda.setVendedor(vendedor);

        return venda;
    }

}
