package mittari;

import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main 
{

	public static void main(String[] args) throws IOException 
	{
	URL url = new URL("http://tuftuf.gambitlabs.fi/feed.txt");
	Scanner sc = new Scanner(url.openStream(), StandardCharsets.UTF_8.toString());
	
		while (sc.hasNextLine())
		{
		System.out.println(sc.nextLine());	
		}
	sc.close();
	}

}
