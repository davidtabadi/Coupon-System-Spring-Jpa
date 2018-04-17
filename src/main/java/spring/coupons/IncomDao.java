package spring.coupons;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IncomDao extends JpaRepository<Income, Long> {

	@Query("SELECT i FROM Income AS i WHERE i.invokerId = :companyId AND type !=:OperationType  ORDER BY  i.timestamp DESC")
	public List<Income> getIncomeByCompany(@Param(value = "companyId") long companyId,
			@Param(value = "OperationType") OperationType type);

	@Query("SELECT i FROM Income AS i WHERE i.invokerId = :companyId AND type =:OperationType  ORDER BY  i.timestamp DESC")
	public List<Income> getIncomeByCustomer(@Param(value = "companyId") long customerId,
			@Param(value = "OperationType") OperationType type);

}
