package com.hcl.capstone.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.hcl.capstone.entities.Album;

@Repository
public interface AlbumRepository extends CrudRepository<Album, Long> {

	public boolean findByName(String name);
}
