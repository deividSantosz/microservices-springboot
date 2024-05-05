package springboot.microservices.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springboot.microservices.dto.PropostaResponseDto;
import springboot.microservices.dto.PropostaResquestDTO;
import springboot.microservices.entities.Proposta;
import springboot.microservices.mapper.PropostaMapper;
import springboot.microservices.repositories.PropostaRepository;

import java.util.List;

@Service
public class PropostaService {

    @Autowired
    private PropostaRepository propostaRepository;
    public PropostaResponseDto criar (PropostaResquestDTO resquestDTO) {
        Proposta proposta = PropostaMapper.INSTANCE.convertDtoToProposta(resquestDTO);
        propostaRepository.save(proposta);
        return PropostaMapper.INSTANCE.convertEntityToDto(proposta);
    }

    public List<PropostaResponseDto> obterProposta() {
        Iterable<Proposta> propostas =  propostaRepository.findAll();
        return PropostaMapper.INSTANCE.convertListEntityToListDto(propostas);

    }
}
