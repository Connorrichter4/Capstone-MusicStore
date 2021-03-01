package com.hcl.capstone.repositories;

import org.springframework.data.repository.CrudRepository;
import com.hcl.capstone.entities.Song;

public interface SongRepository extends CrudRepository<Song, Long> {

}
