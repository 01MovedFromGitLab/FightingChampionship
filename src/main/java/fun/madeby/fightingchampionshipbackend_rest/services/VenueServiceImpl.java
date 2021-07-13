package fun.madeby.fightingchampionshipbackend_rest.services;

import fun.madeby.fightingchampionshipbackend_rest.models.Venue;
import fun.madeby.fightingchampionshipbackend_rest.repositories.VenueRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class VenueServiceImpl implements VenueService{
	private final VenueRepository VENUE_REPO;

@Override
public void register(Venue venue) {
	VENUE_REPO.save(venue);

}

@Override
public Venue retrieveById(Long id) {
	return null;
}

@Override
public List<Venue> retrieveAll() {
	return null;
}
}
