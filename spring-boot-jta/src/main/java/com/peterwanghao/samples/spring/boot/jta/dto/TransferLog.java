package com.peterwanghao.samples.spring.boot.jta.dto;

import java.math.BigDecimal;
/**
 * @ClassName: TransferLog
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date: 2019年8月22日 上午10:48:15
 * @version V1.0
 * 
 */
public class TransferLog {
	private String fromAccountId;
	private String toAccountId;
	private BigDecimal amount;

	public TransferLog(String fromAccountId, String toAccountId,
			BigDecimal amount) {
		this.fromAccountId = fromAccountId;
		this.toAccountId = toAccountId;
		this.amount = amount;
	}

	public String getFromAccountId() {
		return fromAccountId;
	}

	public String getToAccountId() {
		return toAccountId;
	}

	public BigDecimal getAmount() {
		return amount;
	}
}
