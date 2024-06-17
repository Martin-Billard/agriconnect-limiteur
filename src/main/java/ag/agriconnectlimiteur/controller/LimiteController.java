package ag.agriconnectlimiteur.controller;

import ag.agriconnectlimiteur.entities.Limite;
import ag.agriconnectlimiteur.metier.LimiteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/limites")
public class LimiteController {


    private final LimiteService limiteService;

    public LimiteController(LimiteService limiteService) {
        this.limiteService = limiteService;
    }

    @GetMapping("")
    public List<Limite> getAllLimites() {
        return limiteService.findAllLimites();
    }

    @GetMapping("/{id}")
    public Limite getLimiteById(@PathVariable Long id) {
        Optional<Limite> limite = limiteService.findLimiteById(id);
        if (limite.isEmpty()) {
            return null;
        }
        return limite.get();
    }

    @GetMapping("/capteur/{idCapteur}")
    public Limite getLimiteByIdCapteur(@PathVariable Long idCapteur) {
        if (limiteService.findLimitesByIdCapteur(idCapteur).isPresent()){
            return limiteService.findLimitesByIdCapteur(idCapteur).get();
        }
        else {
            return null;
        }
    }

    @PostMapping("")
    public ResponseEntity<Limite> createLimite(@RequestBody Limite limite) {
        return ResponseEntity.ok(limiteService.saveLimite(limite));
    }

    @PutMapping("/{id}")
    public Limite updateLimite(@PathVariable Long id, @RequestBody Limite limite) {
        Optional<Limite> existingLimite = limiteService.findLimiteById(id);
        if (existingLimite.isEmpty()) {
            return null;
        }
        limite.setId(id);
        return limiteService.saveLimite(limite);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteLimite(@PathVariable Long id) {
        if (limiteService.findLimiteById(id).isEmpty()) {
            return null;
        }
        limiteService.deleteLimite(id);
        return ResponseEntity.ok().build();
    }
}