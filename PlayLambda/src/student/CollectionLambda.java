package student;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.functions.*;

public class CollectionLambda {

	public static void main(String[] args) {

		CollectionLambda c = new CollectionLambda();

		c.notLambda();
		c.lambda();
	}

	private void notLambda() {
		
		List<Student> students = getStudents();
		
		int maxScore = 
				students.filter(new Predicate<Student>() {
					@Override
					public boolean eval(Student s) {
						return s.gradYear == 2011;
					}
				}).map(new Mapper<Student, Integer>() {
					@Override
					public Integer map(Student s) {
						return s.score;
					}
				}).reduce(0, new Operator<Integer>() {
					@Override
					public Integer eval(Integer left, Integer right) {
						return Math.max(left, right);
					}					
				});
		
		System.out.println("Max score of 2011 is : " + maxScore);
	}

	private void lambda() {
		List<Student> students = getStudents();
		
		int maxScore = 
				students.filter(s -> s.gradYear == 2011)
				.map(s -> s.score)
				.reduce(0, (left, right) -> Math.max(left, right));
		
		System.out.println("Max score of 2011 is : " + maxScore);
	}

	private List<Student> getStudents() {

		List<Student> s = new ArrayList<>();

		s.add(new Student(2011, 57));
		s.add(new Student(2011, 83));
		s.add(new Student(2011, 46));
		s.add(new Student(2011, 95));
		s.add(new Student(2010, 18));
		s.add(new Student(2010, 75));

		return s;
	}
}
