public class RegularCustomer extends Customer{
    public RegularCustomer(String firstName,String lastName,int phoneNumber,String email,String address){
        super(firstName, lastName, email, address, phoneNumber);
    }
    public void regularPayCoffee(){
        System.out.println(getFirstName()+" "+ getLastName()+" "+" is a regular customer so can pay for coffee using credit or cash.");
    }
    @Override
    public void payCoffee() {
        regularPayCoffee();
    }
}
