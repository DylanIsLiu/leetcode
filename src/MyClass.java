import javax.print.attribute.standard.NumberUp;
import java.time.LocalDateTime;

/**
 * @author Liumz
 * @since 2020/6/15  5:15 下午:32
 */
public class MyClass {

    public static void main(String[] args) {
        Object A = null;
        Object B  = null;
        System.out.println(A == B);
        //1111100110000110101010110111110
        System.out.println(new Object().hashCode());
        //0000000000000000110111010001100
        System.out.println(new Object().hashCode() >>> 16);
        String soutStr = "";
        String str = "{\\\"autoDownloadBegin\\\":\\\"%s\\\",\\\"autoDownloadEnd\\\":\\\"%s\\\"}";
        for (int i = 0; i <24 ; i++) {
            String a = i+":10";
            String b = (i+1)+":00";
            if(i<10){
                a = "0"+a;
            }
            if(i < 9){
                b = "0"+b;
            }

            soutStr += String.format(str,a,b)+",";
        }
        System.out.println(soutStr);
    }
}
