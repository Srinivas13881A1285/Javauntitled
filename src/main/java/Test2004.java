/**
 * @author Srinivas_Chintakindhi
 */

public class Test2004 {
    public static void main(String[] args) {

        String city = "Mina Las Bambas";
        String state = "";
        String country = "Australia";

        String Unstandardvalue = "";

        if (!city.equals(""))
            Unstandardvalue = city + " ,";
        if (!state.equals(""))
            Unstandardvalue += state + " ,";
        if (!country.equals(""))
            Unstandardvalue += country;
        else
            Unstandardvalue = Unstandardvalue.equals("") ? "" : Unstandardvalue.substring(0,Unstandardvalue.length()-2);


        System.out.println("Unstandardvalue = " + Unstandardvalue);
    }
}
