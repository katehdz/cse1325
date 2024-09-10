public class Student {
	private String name;
	private int id;
	private String email;
	private Account account;

	public Student(String name, int id, String email){
		if (!email.endsWith("@uta.edu") && !email.endsWith("@mavs.uta.edu")){
			throw new IllegalArgumentException("Non-UTA email address: "+ email);
		}

	}

	public String requestMedia(Media media){

	}

	@Override
	public String toString(){

	}
}