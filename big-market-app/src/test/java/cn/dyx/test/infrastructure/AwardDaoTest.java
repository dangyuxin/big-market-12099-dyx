package cn.dyx.test.infrastructure;

import cn.dyx.infrastructure.persistent.dao.IAwardDao;
import cn.dyx.infrastructure.persistent.po.Award;
import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@SpringBootTest
public class AwardDaoTest {

    @Resource
    private IAwardDao iAwardDao;

    @Test
    public void test_queryAwardList() {
        List<Award> awards = iAwardDao.queryAwardList();
        log.info("测试结果 --> {}", JSON.toJSON(awards));
    }
}
