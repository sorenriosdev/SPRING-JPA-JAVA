package pe.edu.I202332181.cl1_jpa_data_rios_soren;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.edu.I202332181.cl1_jpa_data_rios_soren.entity.Country;
import pe.edu.I202332181.cl1_jpa_data_rios_soren.repository.CountryRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Cl1JpaDataRiosSorenApplication implements CommandLineRunner {

	@Autowired
	CountryRepository countryRepository;

	public static void main(String[] args) {
		SpringApplication.run(Cl1JpaDataRiosSorenApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Consulta 1: ifPresentOrElse() con lenguajes de Argentina o Perú
		Optional<Country> argCountry = countryRepository.findById("ARG");
		argCountry.ifPresentOrElse(
				country -> {
					System.out.println("Lenguajes de Argentina:");
					country.getLanguages().forEach(lang ->
							System.out.println(lang.getName())
					);
				},
				() -> {
					Optional<Country> perCountry = countryRepository.findById("PER");
					perCountry.ifPresentOrElse(
							country -> {
								System.out.println("Lenguajes de Perú:");
								country.getLanguages().forEach(lang ->
										System.out.println(lang.getName())
								);
							},
							() -> System.out.println("No se encontraron lenguajes para Argentina ni Perú")
					);
				}
		);

		// Consulta 2
		List<String> countriesToDelete = Arrays.asList("COL", "ARG");
		countryRepository.deleteAllById(countriesToDelete);

		// Consulta 3
		Optional<Country> argCountryAfterDelete = countryRepository.findById("ARG");
		argCountryAfterDelete.ifPresentOrElse(
				country -> {
					System.out.println("Lenguajes de Argentina (después de eliminar):");
					country.getLanguages().forEach(lang ->
							System.out.println(lang.getName())
					);
				},
				() -> {
					Optional<Country> perCountry = countryRepository.findById("PER");
					perCountry.ifPresentOrElse(
							country -> {
								System.out.println("Lenguajes de Perú (después de eliminar Argentina):");
								country.getLanguages().forEach(lang ->
										System.out.println(lang.getName())
								);
							},
							() -> System.out.println("No se encontraron lenguajes para Argentina ni Perú")
					);
				}
		);
	}
}

