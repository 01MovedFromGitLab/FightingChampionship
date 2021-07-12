package fun.madeby.fightingchampionshipbackend_rest.services;

import fun.madeby.fightingchampionshipbackend_rest.models.WeightClass;
import fun.madeby.fightingchampionshipbackend_rest.repositories.WeightClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeightClassServiceImpl implements WeightClassService{
	private final WeightClassRepository weightClassRepo;

@Override
public void register(WeightClass weightClass) {
	weightClassRepo.save(weightClass);
}

@Override
public WeightClass retrieveById(Long id) {
	return weightClassRepo.findById(id).orElseThrow(RuntimeException::new);
}

@Override
public List<WeightClass> retrieveAll() {
	return weightClassRepo.findAll();

}
}
