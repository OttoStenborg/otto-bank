package se.ottobank.otto.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import se.ottobank.otto.bank.entity.AppUser;

import java.util.Optional;

public interface AppUserRepository extends JpaRepository<AppUser,Long> {

    boolean existsByUsername(String username);

    Optional<AppUser> findByUsername(String username);
}
