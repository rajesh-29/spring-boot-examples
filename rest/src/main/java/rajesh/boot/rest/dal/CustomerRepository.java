package rajesh.boot.rest.dal;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import rajesh.boot.rest.dal.entity.Customer;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findById(long id);
    
}