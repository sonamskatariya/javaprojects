package hotelManagementSystem;

public class Deluxroom extends Singleroom 
{ 
 
	/**
	 * @return the lunch
	 */
	public String getLunch() {
		return lunch;
	}
	/**
	 * @param lunch the lunch to set
	 */
	public void setLunch(String lunch) {
		this.lunch = lunch;
	}
	String lunch;
    
    Deluxroom()
    {
        this.gender="";
    }
    Deluxroom(String name,String contact,String gender,String lunch )
    {
        this.name=name;
        this.contact=contact;
        this.gender=gender;
        this.lunch=lunch;
    }
    
    @Override public String toString()
    {
        return (super.toString());
    }
}
