package fun.madeby.fightingchampionshipbackend_rest.services;

import fun.madeby.fightingchampionshipbackend_rest.models.WeightClass;
import fun.madeby.fightingchampionshipbackend_rest.repositories.WeightClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WeightClassServiceImpl implements WeightClassService{
	private final WeightClassRepository WEIGHT_CLASS_REPO;

@Override
public void register(WeightClass weightClass) {
	WEIGHT_CLASS_REPO.save(weightClass);
}

@Override
public WeightClass retrieveById(Long id) {
	return WEIGHT_CLASS_REPO.findById(id).orElseThrow(RuntimeException::new);
}

@Override
public List<WeightClass> retrieveAll() {
	return WEIGHT_CLASS_REPO.findAll();

}
}
