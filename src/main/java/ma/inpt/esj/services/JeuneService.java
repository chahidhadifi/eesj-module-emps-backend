package ma.inpt.esj.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.inpt.esj.entities.Jeune;
import ma.inpt.esj.repositories.JeuneRepository;

@Service
public class JeuneService {
    @Autowired
    private JeuneRepository jeuneRepository;

    public List<Jeune> getAllJeunes() {
        return jeuneRepository.findAll();
    }

    public List<Object[]> getAllJeuneWithInfoUser() {
        return jeuneRepository.getAllJeuneWithInfoUser();
    }

    public Object getJeuneDossierMedical(Long id) {
        return jeuneRepository.getJeuneDossierMedical(id);
    }

    public List<Object[]> getFavoritePatients() {
        return jeuneRepository.getFavoritePatients();
    }

    public Optional<Jeune> getJeuneById(Long id) {
        return jeuneRepository.findById(id);
    }

    public Jeune createJeune(Jeune jeune) {
        return jeuneRepository.save(jeune);
    }

    public Jeune updateJeune(Long id, Jeune jeuneDetails) {
        Jeune jeune = jeuneRepository.findById(id).orElseThrow(() -> new RuntimeException("Jeune not found"));
        jeune.setSexe(jeuneDetails.getSexe());
        jeune.setDateNaissance(jeuneDetails.getDateNaissance());
        jeune.setAge(jeuneDetails.getAge());
        jeune.setIdentifiantPatient(jeuneDetails.getIdentifiantPatient());
        jeune.setScolarise(jeuneDetails.isScolarise());
        jeune.setFavorite(jeuneDetails.isFavorite());
        return jeuneRepository.save(jeune);
    }

    public void updateFavoriteState(Long id, Boolean favorite) {
        jeuneRepository.updateFavoriteState(id, favorite);
    }

    public void deleteJeune(Long id) {
        jeuneRepository.deleteById(id);
    }
}
