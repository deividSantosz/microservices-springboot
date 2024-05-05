package springboot.microservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import springboot.microservices.dto.PropostaResponseDto;
import springboot.microservices.dto.PropostaResquestDTO;
import springboot.microservices.services.PropostaService;

import java.util.List;

@RestController
@RequestMapping("/proposta")
public class PropostaController {

    @Autowired
    private PropostaService propostaService;

    @PostMapping
    public ResponseEntity<PropostaResponseDto> criar(@RequestBody PropostaResquestDTO resquestDTO) {
       PropostaResponseDto response = propostaService.criar(resquestDTO);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(response.getId())
                .toUri())
                .body(response);
    }

    @GetMapping
    public ResponseEntity<List<PropostaResponseDto>> obterProposta() {
        return ResponseEntity.ok(propostaService.obterProposta());
    }
}
