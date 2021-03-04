
package com.hcl.capstone.services;



import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.capstone.entities.Album;
import com.hcl.capstone.entities.Artist;

import com.hcl.capstone.entities.Song;
import com.hcl.capstone.repositories.ArtistRepository;

@Service
public class ArtistService {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	ArtistRepository ArtRepo;
	
	@Autowired
	AlbumService albumService;
	
	@Autowired
	SongService songService;
	
	Artist artist=new Artist();
	
	
	
	public Iterable<Artist> getAllArtist(){
		return ArtRepo.findAll();
	}
	
	public Optional<Artist> getArtistById(Long id){
		return ArtRepo.findById(id);
	}
	
	
//	public Artist createArtist(String name,String location,List<Song> songs, List<Album> album) {
//		artist.setName(name);
//		artist.setLocation(location);
//		artist.setSongs(songs);
//		artist.setAlbum(album);
//		
//		return artist;
//	}
	
	
	public Boolean updateArtist(Long id, String name,String location,List<Song> songs, List<Album> album) {
		Optional<Artist> foundArtist = ArtRepo.findById(id);
		if(!foundArtist.isPresent()) {
			return false;
		}else {
			Artist updateArtist = foundArtist.get();
			updateArtist.setName(name);
			updateArtist.setLocation(location);
			updateArtist.setSongs(songs);
			updateArtist.setAlbum(album);
	
			return true;
		}
		
	}
	
	public Boolean deleteArtist(Long id) {
		
		Artist foundArtist = ArtRepo.findById(id).get();
		
		
		if(foundArtist == null) {
			return false;
		}else {
			
			// find and delete all songs
			Iterable<Song> songs = songService.getSongByArtistName(foundArtist.getName());
			
			for(Song song: songs) {
				logger.info(song.getName());
				songService.deleteSong(song.getId());
			}
			
			// find and delete all albums
			
			List<Album> albums = albumService.getSongByArtistName(foundArtist.getName());
			
			for(Album album: albums) {
				logger.info(album.toString());
				albumService.deleteAlbum(album.getId());
			}
			
			ArtRepo.deleteById(id);
			
			return true;
		}
		
	}

	public void save(Artist artist2) {
		
		System.out.println("should be saved now");
		
		ArtRepo.save( artist2);
		
	}


	
	
	
	
	

}

