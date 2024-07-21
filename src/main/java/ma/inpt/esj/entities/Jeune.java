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
@Getter
@Setter 
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Jeune {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sexe;

    private String dateNaissance;

    private int age;

    private int identifiantPatient;

    private boolean scolarise;

    private String niveauEtudes;

    private String cne;

    private boolean favorite;

    @ElementCollection
    @CollectionTable(name = "antecedent_personnel_medicaux", joinColumns = @JoinColumn(name = "jeune_id"))
    @Column(name = "medicaux")
    private List<String> medicaux;

    @ElementCollection
    @CollectionTable(name = "antecedent_personnel_chirurgicaux", joinColumns = @JoinColumn(name = "jeune_id"))
    @Column(name = "chirurgicaux")
    private List<String> chirurgicaux;

    @ElementCollection
    @CollectionTable(name = "antecedent_personnel_habitues", joinColumns = @JoinColumn(name = "jeune_id"))
    @Column(name = "habitues")
    private List<String> habitues;

    @ElementCollection
    @CollectionTable(name = "antecedent_familial_maladies", joinColumns = @JoinColumn(name = "jeune_id"))
    @Column(name = "maladies_familiales")
    private List<String> maladiesFamiliales;

    private Long infoUserId;
}
