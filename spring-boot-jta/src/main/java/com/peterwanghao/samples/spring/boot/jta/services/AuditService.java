package com.peterwanghao.samples.spring.boot.jta.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Service;

import com.peterwanghao.samples.spring.boot.jta.dto.TransferLog;

import java.math.BigDecimal;
/**
 * @ClassName: AuditService
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @author: wanghao
 * @date: 2019年8月22日 上午10:51:32
 * @version V1.0
 * 
 */
@Service
public class AuditService {

	final JdbcTemplate jdbcTemplate;

	@Autowired
	public AuditService(
			@Qualifier("jdbcTemplateAudit") JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void log(String fromAccount, String toAccount, BigDecimal amount) {
		jdbcTemplate.update(
				"insert into AUDIT_LOG(FROM_ACCOUNT, TO_ACCOUNT, AMOUNT) values ?,?,?",
				fromAccount, toAccount, amount);
	}

	public TransferLog lastTransferLog() {
		return jdbcTemplate.query(
				"select FROM_ACCOUNT,TO_ACCOUNT,AMOUNT from AUDIT_LOG order by ID desc",
				(ResultSetExtractor<TransferLog>) (rs) -> {
					if (!rs.next())
						return null;
					return new TransferLog(rs.getString(1), rs.getString(2),
							BigDecimal.valueOf(rs.getDouble(3)));
				});
	}
}
