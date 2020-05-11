/**
 * @author Srinivas_Chintakindhi
 */

public class Test01 {
    public static void main(String[] args) {
        String city = "Mina Las Bambas";
        String state = "";
        String country = "Australia";
        String postalCode = "0";

        String Unstandardvalue = "";

        if (!city.equals(""))
            Unstandardvalue = city + " ,";
        if (!state.equals(""))
            Unstandardvalue += state + " ,";
        if (!country.equals(""))
            Unstandardvalue += country + " ,";
        if (!postalCode.equals(""))
            Unstandardvalue += postalCode;
        else
            Unstandardvalue = Unstandardvalue.equals("") ? "" : Unstandardvalue.substring(0,Unstandardvalue.length()-2);


        System.out.println("Unstandardvalue = " + Unstandardvalue);
    }
}
