public class StrangeCounter {
    static long strangeCounter(long t){
        int cycleRange = 3;
        int i = 1;

        while (t > cycleRange){
            i *= 2;
            cycleRange += 3*i;
        }

        return cycleRange - t + 1;
    }

    static long strangeCounter2(long t){
        double v = (Math.log(t) - Math.log(3)) / Math.log(2);
        System.out.println("base   = " + v);
        long mul = (long) (Math.pow(2,Math.ceil(v))-1);
        System.out.println("2powern-1 = " + mul);
        return 3 * mul -t +1;
    }

    static long strangeCounter3(long t){
        double baseinDouble =  (Math.log(t/3+1)/Math.log(2)+1e-11);
        long longBase;

        if(baseinDouble == Math.floor(baseinDouble)){//if it finds perfect base extact int
             longBase = (long)baseinDouble;
        }else{
            longBase = (long)baseinDouble;//if not
            longBase += 1;
        }

        System.out.println("longBase = " + longBase);
        long ans = (long) (3*(Math.pow(2,longBase)-1) - t + 1);

        if(t == 3*(Math.pow(2,longBase-1)-1))
            ans = 1;

        return ans;
    }

    public static void main(String[] args) {
        long l = strangeCounter3(22);
       System.out.println("l = " + l);
    }
}
