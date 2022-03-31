package cn.caofanqi.filter;

import cn.caofanqi.api.RpcResult;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.common.constants.CommonConstants;
import org.apache.dubbo.common.extension.Activate;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Invocation;
import org.apache.dubbo.rpc.Invoker;
import org.apache.dubbo.rpc.Result;
import org.apache.dubbo.rpc.RpcException;
import org.apache.dubbo.rpc.service.GenericService;

/**
 * Rpc全局异常处理器
 *
 * 使用@Activate并指定group = CommonConstants.PROVIDER，使其只在服务提供者端生效
 *
 * @author Bobby Cao
 * @date 2022/03/31 11:17
 */
@Slf4j
@Activate(group = CommonConstants.PROVIDER)
public class RpcExceptionFilter implements Filter, Filter.Listener {

    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        return invoker.invoke(invocation);
    }

    @Override
    public void onResponse(Result appResponse, Invoker<?> invoker, Invocation invocation) {
        if (appResponse.hasException() && GenericService.class != invoker.getInterface()) {
            Throwable exception = appResponse.getException();
            RpcResult<Object> rpcResult = new RpcResult<>();
            rpcResult.setSuccess(Boolean.FALSE);
            rpcResult.setMessage(exception.getMessage());
            appResponse.setValue(rpcResult);
            appResponse.setException(null);
            log.error("RpcExceptionFilter catch exception msg:{}", exception.getMessage(), exception);
        }
    }

    @Override
    public void onError(Throwable t, Invoker<?> invoker, Invocation invocation) {
    }

}
