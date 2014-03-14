package fr.aruku.catshop.api.dao;

import fr.aruku.catshop.api.domain.Notepad;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface NotepadRepository extends CrudRepository<Notepad, Long> {

    Iterable<Notepad> findByContent(String content);

    Notepad findByUserUuid(String uuid);
}
