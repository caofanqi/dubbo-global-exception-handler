package cn.caofanqi.api;

import lombok.Data;

import java.io.Serializable;

/**
 * Rpc调用统一返回对象
 * @author Bobby Cao
 * @date 2022/03/31 14:58
 */
@Data
public class RpcResult<T> implements Serializable {

    private Boolean success;

    private String message;

    private T data;


}
