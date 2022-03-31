package cn.caofanqi.impl;

import cn.caofanqi.api.DemoService;
import cn.caofanqi.api.RpcResult;
import org.apache.dubbo.config.annotation.DubboService;

/**
 * @author Bobby Cao
 * @date 2022/03/31 15:03
 */
@DubboService
public class DemoServiceImpl implements DemoService {

    @Override
    public RpcResult<String> sayHello(String name) {
        if (true) {
            throw new RuntimeException("test RpcExceptionFilter");
        }
        RpcResult<String> result = new RpcResult<>();
        result.setSuccess(Boolean.TRUE);
        result.setMessage("success");
        result.setData("hello " + name + "!");
        return result;
    }

}
