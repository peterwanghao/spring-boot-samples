package com.peterwanghao.samples.integration.storage.service;

import com.baomidou.mybatisplus.service.IService;
import com.peterwanghao.samples.integration.storage.entity.TStorage;

import com.peterwanghao.samples.integration.common.dto.CommodityDTO;
import com.peterwanghao.samples.integration.common.response.ObjectResponse;

/**
 * 仓库服务
 *
 * @author heshouyou
 * @since 2019-01-13
 */
public interface ITStorageService extends IService<TStorage> {

    /**
     * 扣减库存
     */
    ObjectResponse decreaseStorage(CommodityDTO commodityDTO);
}
