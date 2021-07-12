package fun.madeby.fightingchampionshipbackend_rest.services;


import fun.madeby.fightingchampionshipbackend_rest.models.Venue;
import java.util.List;

public interface VenueService{

void register(Venue venue);
Venue retrieveById(Long id);
List<Venue> retrieveAll();
}
