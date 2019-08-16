import com.ymmm.miaosha.MainApplication;
import com.ymmm.miaosha.redis.MiaoshaKey;
import com.ymmm.miaosha.redis.RedisService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MainApplication.class)
public class RedisServiceTest {
    @Autowired
    JedisPool jedisPool;

    @Autowired
    RedisService redisService;

    Jedis resource;

    @Before
    public void before(){
        resource = jedisPool.getResource();
    }

    @Test
    public void test1(){
        System.out.println(resource.setnx("ymmm", "66"));
        System.out.println(resource.setnx("ymmm", "22"));
    }

    @Test
    public void test2(){
        redisService.set(MiaoshaKey.getMiaoshaPath, ""+151 + "_"+ 2, "ymmm");
        String set = redisService.getSet(MiaoshaKey.getMiaoshaPath, "" + 151 + "_" + 2, "", String.class);
        System.out.println(set);

    }

    @Test
    public void test3(){
        String set = resource.set("ymmmm", "", "NX", "EX", 10);
        String sw = resource.set("ymmmm", "", "NX", "EX", 10);
        System.out.println(set+"**"+sw);
    }

    @Test
    public void test4(){
        System.out.println(redisService.setNXEX(MiaoshaKey.sameUserSuo, "ymmm", "sdsdsdsd"));
        System.out.println(redisService.get(MiaoshaKey.sameUserSuo, "ymmm", String.class));
    }
}
