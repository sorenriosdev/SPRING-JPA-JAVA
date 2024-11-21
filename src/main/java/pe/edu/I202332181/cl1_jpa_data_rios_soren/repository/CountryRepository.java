package pe.edu.I202332181.cl1_jpa_data_rios_soren.repository;
import org.springframework.data.repository.CrudRepository;
import pe.edu.I202332181.cl1_jpa_data_rios_soren.entity.Country;


public interface CountryRepository extends CrudRepository<Country, String> {
}
