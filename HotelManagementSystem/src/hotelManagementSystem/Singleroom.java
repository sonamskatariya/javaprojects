package hotelManagementSystem;

class Singleroom 
{
    String name;
    String contact;
    String gender;   

   
    Singleroom()
    {
        this.name="";
    }
    Singleroom(String name,String contact,String gender)
    {
        this.name=name;
        this.contact=contact;
        this.gender=gender;
    }
	
	public String toString()
    {
        return ("Customer Name 1 " + name + "\n"
                + "Customer Contact 1 " + contact);
    }
    
}