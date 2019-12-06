package com.peterwanghao.samples.integration.order.service;

import com.baomidou.mybatisplus.service.IService;
import com.peterwanghao.samples.integration.order.entity.TOrder;

import com.peterwanghao.samples.integration.common.dto.OrderDTO;
import com.peterwanghao.samples.integration.common.response.ObjectResponse;

/**
 * <p>
 *  创建订单
 * </p>
 *
 * @author heshouyou
 * @since 2019-01-13
 */
public interface ITOrderService extends IService<TOrder> {

    /**
     * 创建订单
     */
    ObjectResponse<OrderDTO> createOrder(OrderDTO orderDTO);
}
