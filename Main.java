package bills;

import java.util.HashMap;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		
	
		
			Bill b = new Bill ();
		b.addMoney(20, "deposit");
		b.addMoney(30, "salary");
		b.addMoney(10, "legasy");
		b.addMoney(40, "gifts");
		b.remMoney(10,"food");
		b.remMoney(200,"home");
		b.persentCategoryAdd();
	}

}
