import java.util.StringTokenizer;

public class resultReturn {
	public double cal(String str) {
		
		StringTokenizer t = new StringTokenizer(str, "+-*", true);	
		Calculator c = new Calculator();
		double result = c.calculate(str);	//CalculatorOption에서 불러온 str을 calculate에서 계산
		return result;	//result를 return
		
	}
}