package citiustech.com;

import java.util.List;
import java.util.stream.Collectors;

public class CandidateStreamingOperationsTask {

	public static void main(String[] args) {

		InterviewRepository i = new InterviewRepository();
		List<Candidate> cd = i.getCandidateList();

		// list candidate names from Pune city
		System.out.println("List of Pune Candidates:");
		cd.stream().filter(names -> names.getCity().equalsIgnoreCase("Pune"))
				.forEach(x -> System.out.println("Candidates from Pune City :" + x.getName()));

		printLine();

		// list city and count of candidates per city
		System.out.println("Candidate count per city");
		long P = cd.stream().filter(ct -> ct.getCity().equalsIgnoreCase("Pune")).count();
		long B = cd.stream().filter(ct -> ct.getCity().equalsIgnoreCase("Banglore")).count();
		long C = cd.stream().filter(ct -> ct.getCity().equalsIgnoreCase("Chennai")).count();
		long M = cd.stream().filter(ct -> ct.getCity().equalsIgnoreCase("Mumbai")).count();
		System.out.println("Pune :" + P + " Banglore :" + B + " Chennai :" + C + " Mumbai :" + M);

		printLine();

		// list technical expertise and count of candidates
		System.out.println("Candidate count by Technical Expertise");
		long J = cd.stream().filter(ct -> ct.getTechnicalExpertise().equalsIgnoreCase("Java")).count();
		long CN = cd.stream().filter(ct -> ct.getTechnicalExpertise().equalsIgnoreCase("C#")).count();
		long CPP = cd.stream().filter(ct -> ct.getTechnicalExpertise().equalsIgnoreCase("C++")).count();
		System.out.println("Java :" + J + " C# :" + CN + " C++ :" + CPP);
		printLine();
		
		// list fresher candidates
		System.out.println("Fresher Candidate list");
		List<Candidate> f = cd.stream().filter(i1 -> (i1.getYearsOfExperience() < 1)).collect(Collectors.toList());
		for (Candidate ca : f) {
			System.out.println(ca.getName() + ", Years of exp :" + ca.getYearsOfExperience());
		}
		printLine();
		
		// listing candidates with highest experience
		System.out.println("Sorted List of Candidates by Experience");
		cd.stream().sorted((a, b) -> a.getYearsOfExperience() > b.getYearsOfExperience() ? 1: a.getYearsOfExperience() < b.getYearsOfExperience() ? -1 : 0)
				.forEach(n -> System.out.println(n));
		printLine();

		// sort the candidates by city name
		System.out.println("Sorted List of Candidates by City Name");
		cd.stream().sorted((t, t1) -> t.getCity().compareTo(t1.getCity())).forEach(c -> System.out.println(c));
	}

	private static void printLine() {
		// TODO Auto-generated method stub
		System.out.println("======================================================");
	}

}
