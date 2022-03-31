package cn.caofanqi.api;

import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
class DemoServiceTest {

    @DubboReference
    private DemoService demoService;

    @Test
    void sayHello() {
        RpcResult<String> result = demoService.sayHello("BobbyCao");
        log.info("result: {}", result);
    }

}