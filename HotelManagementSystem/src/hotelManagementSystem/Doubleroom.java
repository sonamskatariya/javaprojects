package hotelManagementSystem;

class Doubleroom extends Singleroom 
{ 
    String name2;
    String contact2;
    String gender2;  
    
    Doubleroom()
    {
        this.name="";
        this.name2="";
    }
    Doubleroom(String name,String contact,String gender,String name2,String contact2,String gender2)
    {
        this.name=name;
        this.contact=contact;
        this.gender=gender;
        this.name2=name2;
        this.contact2=contact2;
        this.gender2=gender2;
    }
    @Override public String toString()
    {
        return (super.toString() + "\n Customer Name 2 " + name2 + "\n"
                + "\n Customer Contact 2 " + contact2);
    }
    
}