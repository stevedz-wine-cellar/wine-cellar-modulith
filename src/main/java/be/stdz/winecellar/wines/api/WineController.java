package be.stdz.winecellar.wines.api;

import java.util.List;

import be.stdz.winecellar.wines.domain.WineService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("/wines")
public class WineController {

	private WineService wineService;

	public WineController(WineService wineService) {
		this.wineService = wineService;
	}

	@GetMapping("/")
	public List<WineResource> getWines() {
		return this.wineService.findAllWines().stream().map(WineResource::fromWine).collect(toList());
	}
}
