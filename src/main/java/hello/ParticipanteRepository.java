package hello;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ParticipanteRepository extends CrudRepository<Participante, Integer> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE participante SET jaretirou = 'sim' WHERE id = ?1", nativeQuery = true)
    void updateJaRetirou(Integer id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE participante SET foiretirado = 'sim' WHERE id = ?1", nativeQuery = true)
    void updateFoiRetirado(Integer id);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "insert into participante (id, firstname, quemtirou, senha, jaconsultou) values (?1, ?2, ?3, ?4, ?5);", nativeQuery = true)
    void insert(Integer id, String firstname, String quemtirou, String senha, String jaconsultou);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "update participante set jaconsultou = 'sim' where firstname = ?1", nativeQuery = true)
    void updateConsultou(String firstname);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "delete from participante", nativeQuery = true)
    void deleteAll();

    @Query(value = "SELECT * FROM participante WHERE firstname = ?1 AND senha = ?2", nativeQuery = true)
    Iterable<Participante> findByNameAndSenha(String firstname, String senha);

    @Query(value = "SELECT * FROM participante WHERE id != ?1 AND foiretirado = 'nao' ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Participante findRandom(Integer id);
}
