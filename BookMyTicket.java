import java.util.*;
import java.io.*;
class Area 
{
	public int n;
	boolean again;
	void getarea() throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	do
		{
			try
			{
			System.out.println("Select your area:");
			System.out.println("1.Mumbai: Western\n2.Mumbai: Central\n3.South Mumbai");
			n=Integer.parseInt(br.readLine());
                	if(n==0||n>3)
			 	again=false;
			else
				again=true;	
			}
			catch(Exception e)
			{
			}
		
			}
			while(again==false);
	}
}
class Theatre extends Area
{
	public int t;
	public void gettheatre() throws IOException
	{
		getarea();
		do
		{
		try
		{
		System.out.println("Choose the theatre");
		switch(n)
		{
		case 1:
			System.out.println("1.PVR Goregaon(E)\n2.CineMax Juhu\n3.Gaiety Galaxy Bandra");
			break;
		case 2:
			System.out.println("1.Nartaki Cinema Mulund\n2.MovieTime Bhandup\n3.CineMax Chembur");
			break;
		case 3:
			System.out.println("1.PVR Lower Parel\n2.Sterling Fort\n3.Inox Nariman Point");
			break;
		}
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		t=Integer.parseInt(br.readLine());
		if(t==0||t>3)
			 	again=false;
			else
				again=true;	
			}
			catch(Exception e)
			{
			}
		
			}
			while(again==false);
		}
		
	void printtheatre()
	{
		if(n==1)
		{
			switch(t)
			{
			case 1:
				System.out.print("PVR Goregaon(E)");
				break;
			case 2:
				System.out.print("CineMax Juhu");
				break;
			case 3:
				System.out.print("Gaiety galaxy Bandra");
				break;
			}
			System.out.println(", Mumbai: Western");
		}
		else if(n==2)
		{
			switch(t)
			{
			case 1:
				System.out.print("Nartaki Cinema Mulund");
				break;
			case 2:
				System.out.print("MovieTime Bhandup");
				break;
			case 3:
				System.out.print("Cinemax Chembur");
				break;
			}
			System.out.println(", Mumbai: Central");
		}
		else if(n==3)
		{
			switch(t)
			{
			case 1:
				System.out.print("PVR Lower Parel");
				break;
			case 2:
				System.out.print("Sterling Fort");
				break;
			case 3:
				System.out.print("Inox Nariman point");
				break;
			}
			System.out.println(", South Mumbai");
		}

	}
}
class Movies extends Theatre
{
	public int c;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	void getmovie()throws IOException
	{
		gettheatre();
		do
		{
		try
		{
		System.out.println("Choose the movie:");
		System.out.println("1.Golmaal Again\n2.3 Idiots\n3.Judwaa 2\n4.Baahubali 2");
		c=Integer.parseInt(br.readLine());
		if(c==0||c>4)
			 	again=false;
			else
				again=true;	
			}
			catch(Exception e)
			{
			}
		
			}
			while(again==false);
	}
	void printmovie()
	{
		switch(c)
		{
			case 1:
				System.out.println("Golmaal Again");
				break;
			case 2:
				System.out.println("3 Idiots");
				break;
			case 3:
				System.out.println("Judwaa 2");
				break;
			case 4:
				System.out.println("Baahubali 2");
				break;
		}
		printtheatre();
	}
}
class Show extends Movies
{
	public int s;
	String str;
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	void showtime() throws IOException
	{
		getmovie();
		System.out.println("Which date do you want to watch the show on?(dd/mm)");
		str=br.readLine();
		do
		{
		try
		{
		System.out.println("Select the show timing:");
		System.out.println("1.10:15 am\n2.1:30 pm\n3.4:30 pm\n4.8:00pm");
		s=Integer.parseInt(br.readLine());
		if(s==0||s>4)
			 	again=false;
			else
				again=true;	
			}
			catch(Exception e)
			{
			}
		
			}
			while(again==false);
	}
	void printshow()
	{
		
		switch(s)
		{
		case 1:
			System.out.print("10:15am");
			break;
		case 2:
			System.out.print("1:30pm");
			break;
		case 3: 
			System.out.print("4:30pm");
			break;
		case 4:
			System.out.print("8:00pm");
			break;
		}
		System.out.println(", "+str+"/16");
		return;
	}
}
class Seats extends Show
{
	public int a[][]=new int[3][9];
	boolean again;
	int no;
		
	public void selectseat() throws IOException
	{
		
		showtime();
		
		System.out.println("Seats Available:");
		for(int i=0;i<a.length;i++)
		{
			for(int j=0;j<a[i].length;j++)
				if(a[i][j]!=-999)
					System.out.print((char)(i+65)+"-"+(j+1)+"\t");
			System.out.println();
		}
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		do
		{
			try
			{
			System.out.println("Select the number of seats(1-10)");
			no=Integer.parseInt(br.readLine());
			if(no==0||no>10)
			 	again=false;
			else
				again=true;	
			}
			catch(Exception e)
			{
				System.out.println("wrong");
			}
		}
			while(again==false);

			for(int i=0;i<no;i++)
			{
				System.out.println("Select Row(A/B/C)");
				String ro=br.readLine();
				int row;
				if(ro.equalsIgnoreCase("a"))
					row=0;
				else if(ro.equalsIgnoreCase("b"))
					row=1;
				else 
					row=2;
				System.out.println("Select Seat Number(1-10)");
				int seat=Integer.parseInt(br.readLine());
				if(a[row][seat-1]==-999)
				{
					System.out.println("Seat not available");
					i--;
					continue;
				}
				a[row][seat-1]=-999;
			}
			System.out.println("Enter 1 to place an order for food to enjoy with your movie");
			int fd=Integer.parseInt(br.readLine());
			double food=0;
			if(fd==1)
				food=getfood();
			double price = getprice(no)+food;
			System.out.println("\nTICKETS BOOKED\n");
			printmovie();
			printshow();
			printtickets(price);
		}
	
	double getprice(int no)
	{
		switch(s)
		{
		case 1:
			return no*120.0;
		case 2:
			return no*160.0;
		case 3: 
			return no*230.50;
		case 4:
			return no*300;
		}
		return 0;
	}
	double getfood() throws IOException
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		double total=0;
		while(true)
		{
			System.out.println("1.Salted popcorn - ?100\n2.Flavoured popcorn - ?140\n3.Beverage - ?90\n*Enter 0 to exit*");
			int ch=Integer.parseInt(br.readLine());
			switch(ch)
			{
				case 1:
					total+=100;
					break;
				case 2:
					total+=140;
					break;
				case 3:
					total+=90;
					break;
				case 0:
					return total;
				default:
					System.out.println("Invalid option");
					break;
			}
		}
	}
	void printtickets(double price)
	{
		System.out.println("Tickets Selected:");
		for(int i=0;i<a.length;i++)
			for(int j=0;j<a[i].length;j++)
				if(a[i][j]==-999)
					System.out.print((char)(i+65)+"-"+(j+1)+"\t");
System.out.println("\nTotal cost (Inclusive of taxes) = ?"+Math.round(1.18*price*100.0)/100.0+"\n\n");
	}
}
class BookMyTicket
{
	public static void main(String[] args) throws IOException 
	{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Seats a=new Seats();
		System.out.println("Enter name");
		String name=br.readLine();
		System.out.println("Hello, "+name);
		while(true)
		{
			System.out.println("1.BOOK TICKETS\n2.EXIT");
			int choice=Integer.parseInt(br.readLine());
			if(choice==2)
			{
				System.out.println("Thank you");
				break;
			}
			if(choice>2||choice<1)
				System.out.println("Invalid Option");
			else
				a.selectseat();
		}
		
	}

}
