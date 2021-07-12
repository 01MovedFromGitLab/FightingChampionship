package fun.madeby.fightingchampionshipbackend_rest.services;

import fun.madeby.fightingchampionshipbackend_rest.models.Venue;
import fun.madeby.fightingchampionshipbackend_rest.repositories.VenueRepository;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
public class VenueServiceImpl implements VenueService{
	private final VenueRepository VENUE_REPO = new VenueRepository() {

		@Override
		public List<Venue> findAll() {
			return null;
		}

		@Override
		public List<Venue> findAll(Sort sort) {
			return null;
		}

		@Override
		public List<Venue> findAllById(Iterable<Long> iterable) {
			return null;
		}

		@Override
		public <S extends Venue> List<S> saveAll(Iterable<S> iterable) {
			return null;
		}

		@Override
		public void flush() {

		}

		@Override
		public <S extends Venue> S saveAndFlush(S s) {
			return null;
		}

		@Override
		public <S extends Venue> List<S> saveAllAndFlush(Iterable<S> iterable) {
			return null;
		}

		@Override
		public void deleteAllInBatch(Iterable<Venue> iterable) {

		}

		@Override
		public void deleteAllByIdInBatch(Iterable<Long> iterable) {

		}

		@Override
		public void deleteAllInBatch() {

		}

		@Override
		public Venue getOne(Long aLong) {
			return null;
		}

		@Override
		public Venue getById(Long aLong) {
			return null;
		}

		@Override
		public <S extends Venue> List<S> findAll(Example<S> example) {
			return null;
		}

		@Override
		public <S extends Venue> List<S> findAll(Example<S> example, Sort sort) {
			return null;
		}

		@Override
		public Page<Venue> findAll(Pageable pageable) {
			return null;
		}

		@Override
		public <S extends Venue> S save(S s) {
			return null;
		}

		@Override
		public Optional<Venue> findById(Long aLong) {
			return Optional.empty();
		}

		@Override
		public boolean existsById(Long aLong) {
			return false;
		}

		@Override
		public long count() {
			return 0;
		}

		@Override
		public void deleteById(Long aLong) {

		}

		@Override
		public void delete(Venue venue) {

		}

		@Override
		public void deleteAllById(Iterable<? extends Long> iterable) {

		}

		@Override
		public void deleteAll(Iterable<? extends Venue> iterable) {

		}

		@Override
		public void deleteAll() {

		}

		@Override
		public <S extends Venue> Optional<S> findOne(Example<S> example) {
			return Optional.empty();
		}

		@Override
		public <S extends Venue> Page<S> findAll(Example<S> example, Pageable pageable) {
			return null;
		}

		@Override
		public <S extends Venue> long count(Example<S> example) {
			return 0;
		}

		@Override
		public <S extends Venue> boolean exists(Example<S> example) {
			return false;
		}
	};


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
