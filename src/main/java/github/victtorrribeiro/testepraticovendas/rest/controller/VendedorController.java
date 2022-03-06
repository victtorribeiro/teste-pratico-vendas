package github.victtorrribeiro.testepraticovendas.api.controller;


import github.victtorrribeiro.testepraticovendas.domain.entity.Vendedor;
import github.victtorrribeiro.testepraticovendas.rest.dto.VendedorDTO;
import github.victtorrribeiro.testepraticovendas.service.VendedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/vendedor")
@RequiredArgsConstructor
public class VendedorController {

    private final VendedorService service;

    @PostMapping("/salvar")
    public ResponseEntity salvarVendedor(@RequestBody VendedorDTO dto){

        Vendedor vendedor = Vendedor.builder()
                .nome(dto.getNome()).build();
        try{
            Vendedor vendedorSalvo = service.salvarVendedor(vendedor);
            return new ResponseEntity(vendedorSalvo, HttpStatus.CREATED);
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
