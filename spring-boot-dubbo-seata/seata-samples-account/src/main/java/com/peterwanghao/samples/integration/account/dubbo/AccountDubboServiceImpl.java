package com.peterwanghao.samples.integration.account.dubbo;

import com.alibaba.dubbo.config.annotation.Service;
import com.peterwanghao.samples.integration.account.service.ITAccountService;

import io.seata.core.context.RootContext;
import com.peterwanghao.samples.integration.common.dto.AccountDTO;
import com.peterwanghao.samples.integration.common.dubbo.AccountDubboService;
import com.peterwanghao.samples.integration.common.response.ObjectResponse;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Author: heshouyou
 * @Description  Dubbo Api Impl
 * @Date Created in 2019/1/23 14:40
 */
@Service(version = "1.0.0",protocol = "${dubbo.protocol.id}",
         application = "${dubbo.application.id}",registry = "${dubbo.registry.id}",
         timeout = 3000)
public class AccountDubboServiceImpl implements AccountDubboService {

    @Autowired
    private ITAccountService accountService;

    @Override
    public ObjectResponse decreaseAccount(AccountDTO accountDTO) {
        System.out.println("全局事务id ：" + RootContext.getXID());
        return accountService.decreaseAccount(accountDTO);
    }
}
