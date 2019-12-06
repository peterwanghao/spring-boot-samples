package com.peterwanghao.samples.integration.storage.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.peterwanghao.samples.integration.storage.service.ITStorageService;

import io.seata.core.context.RootContext;
import com.peterwanghao.samples.integration.common.dto.CommodityDTO;
import com.peterwanghao.samples.integration.common.dubbo.StorageDubboService;
import com.peterwanghao.samples.integration.common.response.ObjectResponse;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: heshouyou
 * @Description
 * @Date Created in 2019/1/23 16:13
 */
@Service(version = "1.0.0",protocol = "${dubbo.protocol.id}",
        application = "${dubbo.application.id}",registry = "${dubbo.registry.id}",
        timeout = 3000)
public class StorageDubboServiceImpl implements StorageDubboService {

    @Autowired
    private ITStorageService storageService;

    @Override
    public ObjectResponse decreaseStorage(CommodityDTO commodityDTO) {
        System.out.println("全局事务id ：" + RootContext.getXID());
        return storageService.decreaseStorage(commodityDTO);
    }
}
