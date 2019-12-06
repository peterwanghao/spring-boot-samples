package com.peterwanghao.samples.integration.order.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.peterwanghao.samples.integration.order.service.ITOrderService;

import io.seata.core.context.RootContext;
import com.peterwanghao.samples.integration.common.dto.OrderDTO;
import com.peterwanghao.samples.integration.common.dubbo.OrderDubboService;
import com.peterwanghao.samples.integration.common.response.ObjectResponse;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: heshouyou
 * @Description
 * @Date Created in 2019/1/23 15:59
 */
@Service(version = "1.0.0",protocol = "${dubbo.protocol.id}",
        application = "${dubbo.application.id}",registry = "${dubbo.registry.id}",
        timeout = 3000)
public class OrderDubboServiceImpl implements OrderDubboService {

    @Autowired
    private ITOrderService orderService;

    @Override
    public ObjectResponse<OrderDTO> createOrder(OrderDTO orderDTO) {
        System.out.println("全局事务id ：" + RootContext.getXID());
        return orderService.createOrder(orderDTO);
    }
}
