package in.kishanPandey.Day38_Testing_SpringBoot_Code.repository;


import in.kishanPandey.Day38_Testing_SpringBoot_Code.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean existsByName(String name);
}