package inherit2;

public class TaxCal {
	public double getTax(Employee e) {
		double result = 0.0;
		result = e.getAnnSalary()*0.17; //직원의 연봉에서 세금구할거야
		return result;
	}
}
