package ma.inpt.esj.enums;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
@Setter
@Getter
@Entity
public class NiveauEtudes {
    private String libelle; // AUCUN, PRIMAIRE, SECONDAIRE, SUPERIEUR
}
