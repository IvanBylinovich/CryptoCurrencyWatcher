package com.bylinovich.cryptocurrencywatcher.repository;

import com.bylinovich.cryptocurrencywatcher.entity.Note;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends JpaRepository<Note, String> {

}
