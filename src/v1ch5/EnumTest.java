package v1ch5;

import java.util.Scanner;

public class EnumTest {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.print("Enter a size:(SAMLL,MEDIUM,LARGE,EXTRA_LAGER)");
		String input=in.next().toUpperCase();
		Size size=Enum.valueOf(Size.class, input);
		System.out.println("size="+size);
		System.out.println("abbreviation="+size.getAbbreviation());
		if(size==Size.EXTRA_LARGE)
			System.out.println("Good job--you paid attention to the_.");

	}

}
enum Size
{
	SAMLL("S"),MEDIUM("M"),LARGE("L"),EXTRA_LARGE("XL");
	private String abbreviation;
	private Size(String abbreviation)
	{
		this.abbreviation=abbreviation;
	}
	public String getAbbreviation()
	{
		return abbreviation;
	}
}
