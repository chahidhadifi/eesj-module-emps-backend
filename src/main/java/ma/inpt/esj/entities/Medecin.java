package ma.inpt.esj.entities;

import java.util.List;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String inpe;

    private String ppr;

    private boolean estMedecinEsj;

    private String aProposDeMoi;

    private String lienLinkedIn;

    @ElementCollection
    @CollectionTable(name = "specialites_medicales", joinColumns = @JoinColumn(name = "medecin_id"))
    @Column(name = "specialite")
    private List<String> specialites;

    @ElementCollection
    @CollectionTable(name = "langues_parlees", joinColumns = @JoinColumn(name = "medecin_id"))
    @Column(name = "langue")
    private List<String> languesParlees;

    @ElementCollection
    @CollectionTable(name = "education", joinColumns = @JoinColumn(name = "medecin_id"))
    private List<Education> educations;

    @ElementCollection
    @CollectionTable(name = "experience", joinColumns = @JoinColumn(name = "medecin_id"))
    private List<Experience> experiences;

    private Long infoUserId;
}
