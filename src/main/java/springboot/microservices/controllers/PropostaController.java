package springboot.microservices.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springboot.microservices.controllers.dto.PropostaResponseDto;
import springboot.microservices.controllers.dto.PropostaResquestDTO;
import springboot.microservices.services.PropostaService;

@RestController
@RequestMapping("/proposta")
public class PropostaController {

    @Autowired
    private PropostaService propostaService;
    @PostMapping
    public ResponseEntity<PropostaResponseDto> criar(@RequestBody PropostaResquestDTO resquestDTO) {
       PropostaResponseDto response = propostaService.criar(resquestDTO);
        return ResponseEntity.ok(response);
    }
}
