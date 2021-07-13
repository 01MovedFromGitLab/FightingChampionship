package fun.madeby.fightingchampionshipbackend_rest.controllers;

import fun.madeby.fightingchampionshipbackend_rest.models.Fighter;
import fun.madeby.fightingchampionshipbackend_rest.services.FighterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class FighterController {
	private final FighterService fighterService;

	//@GetMapping(value="api/fighter/{id}", produces = "applicatiion/json; charset=UTF-8")

@GetMapping(value="api/fighter/{id}")
@ResponseBody
	public Fighter fighterById(@PathVariable Long id) {
		  return fighterService.retrieveById(id);
	}


}
