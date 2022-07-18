package com.bylinovich.cryptocurrencywatcher.repository;

import com.bylinovich.cryptocurrencywatcher.entity.Note;
import com.bylinovich.cryptocurrencywatcher.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findUserByUsername(String username);

    User findUserByNote(Note note);
}
