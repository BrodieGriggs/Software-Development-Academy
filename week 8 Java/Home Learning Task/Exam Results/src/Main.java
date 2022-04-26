class Results {
	// class variables
	int physics;
	int chemistry;
	int biology;
	int total;
	float percentage;
	
	// class constructor
	Results(int physicsMark, int chemistryMark, int biologyMark) {
		physics = physicsMark;
		chemistry = chemistryMark;
		biology = biologyMark;
		total = physics + chemistry + biology;
		percentage = total / 450f * 100;
	}
	
	// method for getting results variables
	String getResults() {
		String results = "Physics:    " + physics + " / 150";
		results += "\nChemistry:  " + chemistry + " / 150";
		results += "\nBiology:    " + biology + " / 150";
		results += "\nTotal:      " + total + " / 450";
		
		return results;
	}
	
	String getPercentage() {
		return "Percentage: " + percentage + "%";
	}
	
	String checkPass() {
		/* simple check for mark being a pass or fail
		 * the majority of this method is creating a
		 * correctly structured string for the result. */
		String failedSubjects = "";
		if(physics < 60) {
			if(failedSubjects == "") { failedSubjects += "Physics"; }
			else { failedSubjects += ", Physics"; }
		}
		if(chemistry < 60) {
			if(failedSubjects == "") { failedSubjects += "Chemistry"; }
			else { failedSubjects += ", Chemistry"; }
		}
		if(biology < 60) {
			if(failedSubjects == "") { failedSubjects += "Biology"; }
			else { failedSubjects += ", Biology"; }
		}
		
		if(failedSubjects == "") { return "You passed!"; }
		else { return "Unfortunately, you failed " + failedSubjects + "."; }
	}
}

public class Main {

	public static void main(String[] args) {
		Results myResults = new Results(80, 59, 145);
		
		/* display the results that the person got for
		 * each exam and then the total mark. Try to make
		 * the output neat and bespoke for each exam. */
		System.out.println(myResults.getResults());
		
		/* find and display the percentage that the
		 * person received for the exams overall. */
		System.out.println(myResults.getPercentage());
		
		/* "Update the results so that even if the person
		 * gets higher than 60% overall, if they fail 1
		 * or more of the exams (pass grade of 60% for
		 * each exam) they still fail overall."
		 * 
		 * Since it's impossible to get a percentage less
		 * than 60 without failing at least one subject,
		 * a check of each subject's mark is all that is
		 * required */
		System.out.println(myResults.checkPass());
	}
}
