package ma.inpt.esj.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ma.inpt.esj.entities.Medecin;
import ma.inpt.esj.repositories.MedecinRepository;

@Service
public class MedecinService {
    @Autowired
    private MedecinRepository medecinRepository;

    public List<Medecin> getAllMedecins() {
        return medecinRepository.findAll();
    }

    public Optional<Medecin> getMedecinById(Long id) {
        return medecinRepository.findById(id);
    }

    public Medecin createMedecin(Medecin medecin) {
        return medecinRepository.save(medecin);
    }

    public Medecin updateMedecin(Long id, Medecin medecinDetails) {
        Medecin medecin = medecinRepository.findById(id).orElseThrow(() -> new RuntimeException("Medecin not found"));
        medecin.setPpr(medecinDetails.getPpr());
        medecin.setAProposDeMoi(medecinDetails.getAProposDeMoi());
        medecin.setEducations(medecinDetails.getEducations());
        medecin.setEstMedecinEsj(medecin.isEstMedecinEsj());
        medecin.setExperiences(medecinDetails.getExperiences());
        medecin.setInpe(medecinDetails.getInpe());
        medecin.setLanguesParlees(medecinDetails.getLanguesParlees());
        medecin.setLienLinkedIn(medecinDetails.getLienLinkedIn());
        medecin.setSpecialites(medecinDetails.getSpecialites());
        return medecinRepository.save(medecin);
    }

    public void deleteMedecin(Long id) {
        medecinRepository.deleteById(id);
    }
}

