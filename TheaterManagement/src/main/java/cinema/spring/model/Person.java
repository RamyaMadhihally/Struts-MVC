package cinema.spring.model;


public class Person 
{
	private int id;
	private String name;
	private String gender;
	private String isActor;
	private String isDirector;
	private String isWriter;
	private String imageUrl;
	private String birthDate;
	
	public Person()
	{
		
	}
	
	public Person(String name)
	{
		setName(name);
	}
	
	public Person(int id,String name, String gender, String isActor, String isDirector, String isWriter) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.isActor = isActor;
		this.isDirector = isDirector;
		this.isWriter = isWriter;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String getgender() {
		return gender;
	}

	public void setgender(String gender) {
		this.gender = gender;
	}

	public String getIsActor() {
		return isActor;
	}

	public void setIsActor(String isActor) {
		this.isActor = isActor;
	}

	public String getIsDirector() {
		return isDirector;
	}

	public void setIsDirector(String isDirector) {
		this.isDirector = isDirector;
	}

	public String getIsWriter() {
		return isWriter;
	}

	public void setIsWriter(String isWriter) {
		this.isWriter = isWriter;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}
	
	
}
