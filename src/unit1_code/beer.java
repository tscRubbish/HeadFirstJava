package unit1_code;

public class beer 
{

	public static void main(String[] args) 
	{
		int beernum=10;
		String word="bottles";
		while (beernum>0)//java?в????????int???????boolean
		{
			if (beernum==1) word="bottle";
			System.out.println(beernum+" "+word+" of beer");
			System.out.println("Take one down");
			beernum-=1;
			if (beernum==0) System.out.println("No beer");
		}
	}

}
