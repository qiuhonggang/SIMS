import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Created by qhg on 16/5/23.
 */
public class jsss {

    @Test
    public void test(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            System.out.println(sdf.parse("2010-1-1 00:22:22").toString());
        }catch (ParseException p){
            p.printStackTrace();
        }
    }
}
