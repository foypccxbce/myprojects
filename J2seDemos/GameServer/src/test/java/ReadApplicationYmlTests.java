import com.myprojects.YmlConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @Package: PACKAGE_NAME
 * @Author: tangkj
 * @Daet: 2017/8/7 14:08
 * @Email: none@mail.com
 * @Desc:
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = com.myprojects.gs.class)
public class ReadApplicationYmlTests {

    @Autowired
    private YmlConfig config;

    @Test
    public void testDisplayYmlValue() {
        System.out.println(config);
        System.out.println(config.getSimpleProp());
    }
}
