package hello;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete

public interface ParticipanteRepository extends CrudRepository<Participante, Integer> {

    @Query(value = "SELECT * FROM participante WHERE jaretirou = 'nao'", nativeQuery = true)
    Iterable<Participante> findAllNaoRetirou();

    @Modifying(clearAutomatically = true)
    @Query(value = "UPDATE participante SET jaretirou = 'sim' WHERE id = ?1", nativeQuery = true)
    void updateJaRetirou(Integer id);

}
