package fr.aruku.catshop.api.dao;

import fr.aruku.catshop.api.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
