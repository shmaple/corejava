package v1ch5;

import java.util.Date;
import java.util.GregorianCalendar;

public class Employee implements Comparable<Employee>
{
   private String name;
   private double salary;
   private Date hireDay;

   public Employee(String n, double s, int year, int month, int day)
   {
      name = n;
      salary = s;
      GregorianCalendar calendar = new GregorianCalendar(year, month - 1, day);
      hireDay = calendar.getTime();
   }

   public String getName()
   {
      return name;
   }

   public double getSalary()
   {
      return salary;
   }

   public Date getHireDay()
   {
      return hireDay;
   }

   public void raiseSalary(double byPercent)
   {
      double raise = salary * byPercent / 100;
      salary += raise;
   }
   public String toString()
   {
	   return "Employee[name="+getName()+"salary="+getSalary()+" HireDay="+this.getHireDay()+"]";
   }

@Override
public int compareTo(Employee o) {
	// TODO Auto-generated method stub
	if(salary<o.salary) return -1;
	if(salary>o.salary) return 1;
	return 0;
}


}
