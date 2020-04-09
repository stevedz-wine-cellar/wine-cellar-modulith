package be.stdz.winecellar.wines.domain;

import java.util.List;
import java.util.stream.StreamSupport;

import be.stdz.winecellar.wines.infrastructure.WineRepository;

import org.springframework.stereotype.Service;

import static java.util.stream.Collectors.toList;

@Service
public class WineService {
	private WineRepository wineRepository;

	public WineService(WineRepository wineRepository) {
		this.wineRepository = wineRepository;
	}

	public List<Wine> findAllWines() {
		return StreamSupport.stream(this.wineRepository.findAll().spliterator(), false)
				.map(wineEntity -> Wine.fromIdAndNameAndDescription(wineEntity.getId(), wineEntity.getName(), wineEntity.getDescription()))
				.collect(toList());
	}
}
