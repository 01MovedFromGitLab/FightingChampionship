package fun.madeby.fightingchampionshipbackend_rest.services;

import fun.madeby.fightingchampionshipbackend_rest.models.Event;
import java.util.List;

public interface EventService {
void register(Event event);
Event retrieveById(Long id);
List<Event> retrieveAll();
}
