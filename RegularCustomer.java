public class RegularCustomer extends Customer{
    public RegularCustomer(String name,int phoneNumber,String address){
        super(name, address, phoneNumber);
    }

    public void regularPayCoffee(){
        System.out.println("Regular customer can pay for coffee using credit or cash.");
    }


    @Override
    public void payCoffee() {
        regularPayCoffee();
    }
}
