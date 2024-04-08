public class PremiumCustomer extends Customer{
    public PremiumCustomer(String firstName,String lastName,int phoneNumber,String email,String address){
        super(firstName, lastName, email, address, phoneNumber);
    }

    public void premiumPayCoffee(){
        System.out.println(getFirstName()+ " "+getLastName()+ " "+"Premium customer can pay for the coffee using bitcoin, credit card, or cash.");
        System.out.println("A 10 percent discount will be applied to the price");
    }
    @Override
    public void payCoffee(){
        premiumPayCoffee();
    }
}
