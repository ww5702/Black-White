import java.util.StringTokenizer;

public class resultReturn {
	public double cal(String str) {
		
		StringTokenizer t = new StringTokenizer(str, "+-*", true);	
		Calculator c = new Calculator();
		double result = c.calculate(str);	//CalculatorOption���� �ҷ��� str�� calculate���� ���
		return result;	//result�� return
		
	}
}