package be.stdz.winecellar.wines.infrastructure;

import org.springframework.cloud.gcp.data.datastore.repository.DatastoreRepository;

public interface WineRepository extends DatastoreRepository<WineEntity, Long> {

}
