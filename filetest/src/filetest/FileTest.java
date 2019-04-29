package filetest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.PrintWriter;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class FileTest {

	public static void main(String[] args) {
		//git test...
		String IFN = "C:\\home\\desktop\\InputFile.txt";
		String IFL = null;
		String OFN = "C:\\home\\desktop\\OutputFile.txt";
		//String OFL = null;
		String IK = null;
		
		//Input by Key-Board...
		BufferedReader kbr = new BufferedReader(new InputStreamReader(System.in));
		
		try {
			//Input File of IF...
			BufferedReader IF = new BufferedReader(
					new InputStreamReader(new FileInputStream(IFN)));
			
			//Output File of OF...
			PrintWriter pw = new PrintWriter(
					new BufferedWriter(
							new OutputStreamWriter(
									new FileOutputStream(new File(OFN))
									, "UTF8")));
			
			while((IFL=IF.readLine())!=null 
					&& (IK=kbr.readLine())!=null) {
				if(IK.equals(IFL)) {
					System.out.println("Match input File : "+IK);
					pw.println(IK);
				}else {
					System.out.println("Not Match input File :"+IK);
				}
			}
			kbr.close();
			IF.close();
			pw.close();
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		System.out.println("End of System...");
	}
}
