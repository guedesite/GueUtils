package fr.guedesite.utils;

import java.io.File;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

public class CrashHandler {
	
private static final String path = new String("Crash/");
	
	private static Exception last;
	
	private static CrashRunnable runHandler;
	
	public static void init(CrashRunnable run) {
		
		runHandler = run;
		if(!new File(path).exists())
		{
			new File(path).mkdirs();
		}
	}
	
	public static void Push(Exception e)
	{
		if(last != null && e.getMessage() != null && last.getMessage() != null && e.getMessage().equals(last.getMessage()))
		{
			return;
		}
		last = e;
		e.printStackTrace();
		int i = 0; 
		File f = new File(path+"Crash-"+LocalDate.now().toString()+"-"+i+".txt");
		while(f.exists())
		{
			i++;
			f = new File(path+"Crash-"+LocalDate.now().toString()+"-"+i+".txt");
		
		}
		try {
			System.err.println("Error saved in: "+f.getAbsolutePath());
		

			
			PrintWriter writer = new PrintWriter(path+"Crash-"+LocalDate.now().toString()+"-"+i+".txt", "UTF-8");
			
			writer.println("########################	error	########################");
			writer.println(" ");
			writer.println("Time: "+LocalDate.now().toString().replace("-", "/")+" "+new SimpleDateFormat("HH:mm:ss").format(java.util.Calendar.getInstance().getTime()));
			writer.println(" ");
			
			e.printStackTrace(writer);
			
			writer.println(" ");
			writer.println("########################	error	########################");
			writer.println(" ");
			writer.close();
			
			if(runHandler != null) {
				runHandler.run(e);
			}
			
		} catch (Exception e1) {
			e1.printStackTrace();
		} 
		
	
	}
	
	static abstract class CrashRunnable {
		public abstract void run(Exception e);
	}
	
}
