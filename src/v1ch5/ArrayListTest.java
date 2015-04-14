package v1ch5;
import java.util.*;
public class ArrayListTest {

	public static void main(String[] args) {
		ArrayList<Employee> staff=new ArrayList<Employee>();
		staff.add(new Employee("Carl Cracker",7500,1987,12,15));
		staff.add(new Employee("Harry Hacker",50000,1989,10,1));
		staff.add(new Employee("Tony Teste",40000,1990,3,15));
		Employee[] tt=new Employee[3];
		tt[0]=new Employee("Carl Cracker",75000,1987,12,15);
		tt[1]=new Employee("Harry Hacker",50000,1989,10,1);
		tt[2]=new Employee("Tony Teste",40000,1990,3,15);
		Arrays.sort(tt);
		for(Employee e:staff)
			e.raiseSalary(5);
		
		for(Employee e:staff)
			System.out.println("name="+e.getName()+",salary="+e.getSalary()+",hireDay="+e.getHireDay());
		for(Employee e:tt)
			System.out.println("name="+e.getName()+",salary="+e.getSalary()+",hireDay="+e.getHireDay());
		
		
	}

}
