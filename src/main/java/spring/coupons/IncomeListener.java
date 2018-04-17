package spring.coupons;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class IncomeListener {

	@Autowired
	private IncomeFacade facadeImpl;

	@JmsListener(destination = "NewIncome")
	public void readIncome(String xml) {
		Income income = Income.fromXml(xml);
		this.facadeImpl.storeIncome(income);
	}

}
