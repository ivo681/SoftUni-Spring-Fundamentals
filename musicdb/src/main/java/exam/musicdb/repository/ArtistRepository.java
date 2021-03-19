package exam.musicdb.repository;

import exam.musicdb.model.entity.Artist;
import exam.musicdb.model.entity.ArtistName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArtistRepository extends JpaRepository<Artist, String> {
    Optional<Artist> findByName(ArtistName artistName);
}
