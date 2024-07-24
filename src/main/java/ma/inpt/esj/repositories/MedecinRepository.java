package ma.inpt.esj.repositories;

import ma.inpt.esj.entities.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MedecinRepository extends JpaRepository<Medecin,Long> {
    @Query(value = "SELECT\r\n" + //
            "\tm.id,\r\n" + //
            "\tm.a_propos_de_moi,\r\n" + //
            "\tstring_agg(DISTINCT l.langue, '#') AS langue,\r\n" + //
            "\tstring_agg(DISTINCT s.specialite, '#') AS specialite,\r\n" + //
            "\tstring_agg(DISTINCT CONCAT(ed.annee, ';', ed.diplome, ';', ed.institut), '#') AS education,\r\n" + //
            "\tstring_agg(DISTINCT CONCAT(ex.annee, ';', ex.hopital, ';', ex.poste), '#') AS expetience\r\n" + //
            "FROM\r\n" + //
            "\tmedecin m,\r\n" + //
            "\tlangues_parlees l,\r\n" + //
            "\tspecialites_medicales s,\r\n" + //
            "\teducation ed,\r\n" + //
            "\texperience ex\r\n" + //
            "WHERE\r\n" + //
            "\tm.id = l.medecin_id\r\n" + //
            "AND\r\n" + //
            "\tm.id = s.medecin_id\r\n" + //
            "AND\r\n" + //
            "\tm.id = ed.medecin_id\r\n" + //
            "AND\r\n" + //
            "\tm.id = ex.medecin_id\r\n" + //
            "GROUP BY\r\n" + //
            "\tm.id;", nativeQuery = true)
    Object getMedecinEvaluation();
}
