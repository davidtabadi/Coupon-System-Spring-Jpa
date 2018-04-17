package spring.coupons;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IncomeFacadeImpl implements IncomeFacade {

	@Autowired
	private JmsTemplate jmsTemplate;

	@Autowired
	private IncomDao incomeDao;

	@Override
	@Transactional
	public Income storeIncome(Income income) {
		return incomeDao.save(income);
	}

	@Override
	@Transactional
	public void sendIncome(Income income) {
		String xml = income.toXml();
		this.jmsTemplate.send("NewIncome", session -> session.createTextMessage(xml));
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Income> getAllIncome() {
		return incomeDao.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Income> getCompanyIncome(long companyId) {
		return incomeDao.getIncomeByCompany(companyId, OperationType.CUSTOMER_PURCHASE);
	}

	@Override
	@Transactional(readOnly = true)
	public Collection<Income> getCustomerIncome(long customerId) {
		return incomeDao.getIncomeByCustomer(customerId, OperationType.CUSTOMER_PURCHASE);
	}

}
