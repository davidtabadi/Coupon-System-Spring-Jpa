package spring.coupons;

import java.util.Collection;

public interface IncomeFacade {

	public Income storeIncome(Income income);

	public void sendIncome(Income income);

	public Collection<Income> getAllIncome();

	public Collection<Income> getCompanyIncome(long companyId);

	public Collection<Income> getCustomerIncome(long customerId);

}
