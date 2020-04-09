package be.stdz.winecellar.wines.api;

import be.stdz.winecellar.wines.domain.Wine;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class WineResource {

	private Long id;
	private String name;
	private String description;

	private WineResource() {}

	public static WineResource fromWine(Wine wine) {
		WineResource wineResource = new WineResource();
		wineResource.id = wine.getId();
		wineResource.name = wine.getName();
		wineResource.description = wine.getDescription();

		return wineResource;
	}

	public static WineResource fromIdAndNameAndDescription(Long id, String name, String description) {
		WineResource wineResource = new WineResource();
		wineResource.id = id;
		wineResource.name = name;
		wineResource.description = description;

		return wineResource;
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
}
