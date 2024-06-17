package ag.agriconnectlimiteur.dao;

import ag.agriconnectlimiteur.entities.Limite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LimiteRepository extends JpaRepository<Limite, Long> {

    Optional<Limite> findByIdCapteur(Long idCapteur);
}
