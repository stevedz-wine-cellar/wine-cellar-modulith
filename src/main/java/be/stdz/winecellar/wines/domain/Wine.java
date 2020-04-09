package be.stdz.winecellar.wines.domain;

public class Wine {
	private Long id;
	private String name;
	private String description;
	private WineRegion wineRegion;

	public Wine(Long id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}

	private Wine(Long id, String name, String description, WineRegion wineRegion) {
		this(id, name, description);
		this.wineRegion = wineRegion;
	}

	public Long getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public String getDescription() {
		return this.description;
	}

	public WineRegion getWineRegion() {
		return this.wineRegion;
	}

	public static Wine fromIdAndNameAndDescription(Long id, String name, String description) {
		return new Wine(id, name, description);
	}
}
