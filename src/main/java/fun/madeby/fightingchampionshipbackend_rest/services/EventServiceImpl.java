package fun.madeby.fightingchampionshipbackend_rest.services;

import fun.madeby.fightingchampionshipbackend_rest.models.Event;
import fun.madeby.fightingchampionshipbackend_rest.repositories.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService{
	private final EventRepository EVENT_REPO;

@Override
public void register(Event event) {
	EVENT_REPO.save(event);
}

@Override
public Event retrieveById(Long id) {
	return EVENT_REPO.findById(id).orElseThrow(RuntimeException::new);
}

@Override
public List<Event> retrieveAll() {
	return EVENT_REPO.findAll();
}

}
