package github.victtorrribeiro.testepraticovendas.rest.controller;

import github.victtorrribeiro.testepraticovendas.domain.entity.Venda;
import github.victtorrribeiro.testepraticovendas.domain.entity.Vendedor;
import github.victtorrribeiro.testepraticovendas.exception.RegraNegocioException;
import github.victtorrribeiro.testepraticovendas.rest.dto.VendaDTO;
import github.victtorrribeiro.testepraticovendas.rest.dto.VendaValorDTO;
import github.victtorrribeiro.testepraticovendas.service.VendaService;
import github.victtorrribeiro.testepraticovendas.service.VendedorService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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

    }
    @GetMapping("/consultaIdVendedor/{vendedor_id}")
    public List<Venda> consultaT( @PathVariable Integer vendedor_id){

        return service.consultaByVendedor(vendedor_id);
    }

    @GetMapping("/consultaVendedorData")
    public List<Venda> consultarVendedorData(
                    @RequestParam(value = "vendedor_id") Integer vendedor_id,
                    @RequestParam(value = "data_inicial", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data_inicial,
                    @RequestParam(value = "data_final", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data_final
                ){


        return service.consultaByVendedorByData(vendedor_id, data_inicial, data_final);
    }

    @GetMapping("/consultaVendaVendedor")
    public List<VendaValorDTO> consultaVendaVendedor(
            @RequestParam(value = "data_inicial", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data_inicial,
            @RequestParam(value = "data_final", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate data_final
    ){

        List<VendaValorDTO> valor = service.consultaByVendasVendedor(data_inicial, data_final);
        System.out.println(valor);
        return valor;
    }




    public Venda converter(VendaDTO dto) {
        Venda venda = new Venda();

        venda.setDataVenda(LocalDate.now());
        venda.setValor(dto.getValor());

        Vendedor vendedor = vendedorService.obterPorId(dto.getVendedor_id())
                .orElseThrow(() -> new RegraNegocioException("Vendedor não encontrado"));
        venda.setVendedor(vendedor);

        return venda;
    }

}
