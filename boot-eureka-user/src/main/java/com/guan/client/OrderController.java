package com.guan.client;

import com.guan.pojo.Order;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Mr.Guan
 * @since 2019/11/25
 * 代理接口
 * 三个注意事项
 * 1）使用@FeignClient声明需要调用的服务
 * 2）检查@RequestMapping注解，路径要补全
 * 3）@PathVariable注解的value不能省略
 */
//value:提供者名称，fallback：FallBack处理类
@FeignClient(value = "boot-eureka-order", fallback = OrderControllerFallBack.class)
public interface OrderController {

    @RequestMapping(value = "/order/findAll", method= RequestMethod.GET)
    public List<Order> findAll();

    @RequestMapping(value = "/order/findById/{id}", method=RequestMethod.GET)
    public Order findById(@PathVariable(value = "id") Integer id);
}
