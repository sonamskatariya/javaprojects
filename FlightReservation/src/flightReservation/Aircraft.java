package flightReservation;

public class Aircraft {
	
	String name;
	String department;
	double duration;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public double getDuration() {
		return duration;
	}

	public void setDuration(double duration) {
		this.duration = duration;
	}

	@Override
	public String toString() {
		return "Aircraft [name=" + name + ", department=" + department + ", duration=" + duration + "]";
	}

	public Aircraft(String name,String department,double d)
	 {
		this.name=name;
		this.department=department;
		this.duration=d;
		
	}

}
