package ag.agriconnectlimiteur.metier;

import ag.agriconnectlimiteur.dao.LimiteRepository;
import ag.agriconnectlimiteur.entities.Limite;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LimiteService {


    private final LimiteRepository limiteRepository;

    public LimiteService(LimiteRepository limiteRepository) {
        this.limiteRepository = limiteRepository;
    }

    public List<Limite> findAllLimites() {
        return limiteRepository.findAll();
    }

    public Optional<Limite> findLimiteById(Long id) {
        return limiteRepository.findById(id);
    }

    public Optional<Limite> findLimitesByIdCapteur(Long idCapteur) {
        return limiteRepository.findByIdCapteur(idCapteur);
    }

    public Limite saveLimite(Limite limite) {
        Limite limiteSaved = new Limite();
        limiteSaved.setIdActionneurTemp(limite.getIdActionneurTemp());
        limiteSaved.setIdActionneurHum(limite.getIdActionneurHum());
        limiteSaved.setLimitTemp(limite.getLimitTemp());
        limiteSaved.setLimitHum(limite.getLimitHum());
        limiteSaved.setDureeActionneurTemp(limite.getDureeActionneurTemp());  // mise à jour de la durée de l'actionneur de température
        limiteSaved.setDureeActionneurHum(limite.getDureeActionneurHum());
        return limiteRepository.save(limite);
    }

    public void deleteLimite(Long id) {
        limiteRepository.deleteById(id);
    }
}