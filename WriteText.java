package atlas;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class WriteText {

	public WriteText() {
		super();

	}

	public void writer(String text) throws FileNotFoundException, IOException {
		Date data = new Date();

		SimpleDateFormat sdf = new SimpleDateFormat("MMyy");
		String dataText = sdf.format(data);
		SimpleDateFormat days = new SimpleDateFormat("ddMMyy");
		String dataDays = days.format(data);

		String dataSave = dataText + ".txt";
		File file = new File(dataSave);
		if(file.exists()==false) {
			file.createNewFile();
		}else {
		if (this.chekFile(file, dataDays)) {

			System.out.println(dataSave);
			try (BufferedWriter wr = new BufferedWriter(new FileWriter(file, true))) {
				wr.write(text);
				wr.newLine();

			} catch (IOException e) {
				System.out.println("File error.");
			}
		} else {

			try (BufferedWriter wr = new BufferedWriter(new FileWriter(file, true))) {
				wr.newLine();
				wr.write(dataDays);
				wr.newLine();
				wr.write(text);
				wr.newLine();

			} catch (IOException e) {
				System.out.println("FileWrtiter error.");
			}
		}
		}

	}

	private  boolean chekFile(File file, String date) throws FileNotFoundException, IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String str = "";
			for (; (str = br.readLine()) != null;)
				if (str.equals(date)) {
					return true;
				}
		}
		return false;
	}

}
