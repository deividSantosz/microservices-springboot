package springboot.microservices.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import springboot.microservices.entities.Proposta;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {
}
