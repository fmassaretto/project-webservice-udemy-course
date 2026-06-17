package org.example.projectwebservicesection22.repositories;

import org.example.projectwebservicesection22.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
