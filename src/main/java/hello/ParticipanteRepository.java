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

    @Query(value = "SELECT * FROM participante WHERE jaretirou = 'nao'", nativeQuery = true)
    Iterable<Participante> findAllNaoRetirou();

    @Query(value = "SELECT * FROM participante WHERE id != ?1 AND foiretirado = 'nao' ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Participante findRandom(Integer id);
}
