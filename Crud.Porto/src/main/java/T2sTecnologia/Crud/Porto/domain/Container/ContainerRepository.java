package T2sTecnologia.Crud.Porto.domain.Container;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContainerRepository extends JpaRepository<Container, Long> {


    public List<Container> findByNome(String nome);


}
