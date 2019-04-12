package programs;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Program3 {
	
	public static void main(String args[])
	{
		Scanner s=new Scanner(System.in);
		
		String str=s.next();
		int count=0;
		
		List<String> strList=new ArrayList<String>();
		
		for(int i=0;i<str.length();i++)
		{
			String temp=new String("");
			for(int j=i;j<str.length();j++)
			{
				temp+=((str.charAt(j)));
				if(!strList.contains(temp))
				{
					StringBuilder sb=new StringBuilder(temp);
					if((sb.toString()).equals(sb.reverse().toString()))
					{
						//System.out.print(sb.toString()+" ");
						count++;
						
					}
						
				strList.add(temp);
				}
				
			}
			
		}
	/*	System.out.println(strList);*/
		System.out.println(count);
		
		
	}

}
