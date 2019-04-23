package exprCalc;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class FileLogger extends Logger {
	   BufferedWriter writer;
	   public FileLogger(int level) throws IOException{
		  SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss");
		  String fileName = "log" + "-" + sdf.format(new Timestamp(System.currentTimeMillis()));
		  writer = new BufferedWriter(new FileWriter(fileName));
	   }

	   @Override
	   public void write(String message) {		
	      try {
			writer.write(message + "\n");
	      } catch (IOException e) {
			e.printStackTrace();
	      }
	   }
}
