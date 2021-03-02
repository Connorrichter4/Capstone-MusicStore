//package com.hcl.capstone.services;
//
//
//
//import java.util.List;
//import java.util.Optional;
//
//
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.hcl.capstone.entities.Album;
//import com.hcl.capstone.entities.Artist;
//
//import com.hcl.capstone.entities.Song;
//import com.hcl.capstone.repositories.ArtistRepository;
//
//@Service
//public class ArtistService {
//	
//	@Autowired
//	ArtistRepository ArtRepo;
//	
//	Artist artist=new Artist();
//	
//	
//	
//	public Iterable<Artist> getAllArtist(){
//		return ArtRepo.findAll();
//	}
//	
//	public Optional<Artist> getArtistById(Long id){
//		return ArtRepo.findById(id);
//	}
//	
//	
//	public Artist createArtist(String name,String location,List<Song> songs, List<Album> album) {
//		artist.setName(name);
//		artist.setLocation(location);
////		artist.setSongs(songs);
////		artist.setAlbum(album);
//		
//		return artist;
//	}
//	
//	
//	public Boolean updateArtist(Long id, String name,String location,List<Song> songs, List<Album> album) {
//		Optional<Artist> foundArtist = ArtRepo.findById(id);
//		if(foundArtist.isEmpty()) {
//			return false;
//		}else {
//			Artist updateArtist = foundArtist.get();
//			updateArtist.setName(name);
//			updateArtist.setLocation(location);
////			updateArtist.setSongs(songs);
////			updateArtist.setAlbum(album);
//	
//			return true;
//		}
//		
//		
//	}
//	
//	public Boolean deleteArtist(Long id) {
//		Optional<Artist> foundArtist = ArtRepo.findById(id);
//		if(foundArtist.isEmpty()) {
//			return false;
//		}else {
//			
//			ArtRepo.deleteById(id);
//			
//			return true;
//		}
//		
//	}
//
//	public void save(Artist artist2) {
//		
//		System.out.println("should be saved now");
//		
//		ArtRepo.save( artist2);
//		
//	}
//	
//	
//	
//	
//	
//
//}
