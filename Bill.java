package atlas;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Bill {

	private Map<String, Integer> profit = new HashMap<>();
	private Map<String, Integer> exspens = new HashMap<>();
	private double billProfit;
	private double billExspens;
	final WriteText wt = new WriteText();

	public Bill(Map<String, Integer> profit, Map<String, Integer> exspens, double billProfit, double billExspens) {
		super();
		this.profit = profit;
		this.exspens = exspens;
		this.billProfit = billProfit;
		this.billExspens = billExspens;
	}

	public Map<String, Integer> getProfit() {
		return profit;
	}

	public void setProfit(Map<String, Integer> profit) {
		this.profit = profit;
	}

	public Map<String, Integer> getExspens() {
		return exspens;
	}

	public void setExspens(Map<String, Integer> exspens) {
		this.exspens = exspens;
	}

	public double getBillProfit() {
		return billProfit;
	}

	public void setBillProfit(double billProfit) {
		this.billProfit = billProfit;
	}

	public double getBillExspens() {
		return billExspens;
	}

	public void setBillExspens(double billExspens) {
		this.billExspens = billExspens;
	}

	public Bill() {
		super();

	}

	public void addMoney(int changeSum, String category) throws FileNotFoundException, IOException {

		this.setBillProfit(this.getBillProfit() + changeSum);
		// Check category exist
		if (profit.containsKey(category)) {
			int s = profit.get(category);
			s = s + changeSum;
			profit.replace(category, s);
			String forFile = category + ";" + changeSum;
			wt.writer(forFile);
			System.out.println(changeSum + "UAH earned");

		} else {
			// add new category
			profit.put(category, changeSum);
			String forFile = category + ";" + changeSum;
			wt.writer(forFile);
			System.out.println(changeSum + "UAH earned");
		}

	}

	public void remMoney(int changeSum, String category) throws FileNotFoundException, IOException {

		this.setBillExspens(this.getBillExspens() + changeSum);
		// Check category exist
		if (exspens.containsKey(category)) {
			int s = exspens.get(category);
			s = s + changeSum;
			exspens.replace(category, s);
			System.out.println(changeSum + "UAH spent");
			String forFile = "del;" + category + ";" + changeSum;
			wt.writer(forFile);

		} else {
			// add new category
			exspens.put(category, changeSum);
			String forFile = "del;" + category + ";" + changeSum;
			wt.writer(forFile);
			System.out.println(changeSum + "UAH spent");
		}

	}

	public void persentCategoryAdd() {
		Set<Map.Entry<String, Integer>> hms = profit.entrySet();
		Set<Map.Entry<String, Integer>> sp = exspens.entrySet();
		System.out.println("_____PROFIT_____");
		for (Map.Entry<String, Integer> hmse : hms) {

			System.out.print(hmse.getValue() + " UAH ");
			double a = (double) hmse.getValue();
			double per = (a / billProfit) * 100;
			String formattedDouble = new DecimalFormat("#0.00").format(per);
			System.out.println(hmse.getKey() + " - " + formattedDouble + '%');

		}
		System.out.println("_____EXSPENS_____");
		for (Map.Entry<String, Integer> hmse : sp) {
			System.out.print(hmse.getValue() + " UAH ");
			double b = (double) hmse.getValue();
			double per = (b / billExspens) * 100;
			String formattedDouble = new DecimalFormat("#0.00").format(per);
			System.out.println(hmse.getKey() + " - " + formattedDouble + '%');

		}
		System.out.println("_____YOU HAVE_____");
		System.out.println(billProfit - billExspens + "UAH.");

	}

	@Override
	public String toString() {
		return "Bill [profit=" + profit + ", exspens=" + exspens + ", billProfit=" + billProfit + ", billExspens="
				+ billExspens + "]";
	}
}
