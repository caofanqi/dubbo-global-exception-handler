package cn.caofanqi.api;

/**
 * @author Bobby Cao
 * @date 2022/03/31 14:58
 */
public interface DemoService {

    /**
     * sayHello
     *
     * @param name name
     * @return cn.caofanqi.api.RpcResult<java.lang.String>
     * @author Bobby Cao
     * @date 2022/3/31 15:01
     */
    RpcResult<String> sayHello(String name);

}
