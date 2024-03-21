package spring.jpa.demo.remotes;

import org.springframework.data.repository.CrudRepository;
import spring.jpa.demo.model.AccountDetails;

public interface AccountRepo  extends CrudRepository<AccountDetails, String> {
}
