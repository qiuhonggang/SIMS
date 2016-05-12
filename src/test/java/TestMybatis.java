import com.cuit.june.pojo.TblUserinfo;
import com.cuit.june.services.UserinfoService;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * Created by qhg on 16/4/21.
 */


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring/applicationContext-mybatis.xml"})

public class TestMybatis {
    private static Logger logger = Logger.getLogger(TestMybatis.class);
//    private ApplicationContext ac = null;
    @Resource
    private UserinfoService userinfoService = null;

//    @Before
//    public void before() {
//        ac = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
//        userinfoService = (UserinfoService) ac.getBean("userService");
//    }

    @Test
    public void test1() throws Exception{
        TblUserinfo user = userinfoService.getUserById(new BigDecimal(1));
//        System.out.println(user.getUsinUsername());
        logger.info("值：" + user.getUsinUsername());
    }

}
