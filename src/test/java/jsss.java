import com.cuit.june.util.MD5Util;
import org.junit.Test;

/**
 * Created by qhg on 16/5/23.
 */
public class jsss {
    @Test
    public void test(){
        String passwd = "123";
        System.out.println(MD5Util.encode(passwd));
    }
}
