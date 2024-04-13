public class PremiumCustomer extends Customer{
    public PremiumCustomer(String name,int phoneNumber,String address) {
        super(name, address, phoneNumber);
    }
    public void premiumPayCoffee(){
        System.out.println("Premium customer get a 10 percent discount and can pay for the coffee using bitcoin, credit card, or cash.");


    }
    @Override
    public void payCoffee(){
        premiumPayCoffee();

    }
}
