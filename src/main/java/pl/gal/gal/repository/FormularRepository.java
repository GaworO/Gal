package pl.gal.gal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.gal.gal.entity.Formular;

@EnableJpaRepositories
public interface FormularRepository extends JpaRepository<Formular , Long> {
}
