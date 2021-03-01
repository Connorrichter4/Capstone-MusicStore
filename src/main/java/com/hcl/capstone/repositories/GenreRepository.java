package com.hcl.capstone.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hcl.capstone.entities.Genre;

public interface GenreRepository extends JpaRepository<Genre, Long> {

}
