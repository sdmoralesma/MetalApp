package com.metal.util;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import javax.transaction.Status;
import javax.transaction.UserTransaction;

//@RequiredTx
//@Interceptor
public class RequiredTransactionInterceptor implements Serializable {
	/***/
	private static final long serialVersionUID = 1L;

	@Resource
	private UserTransaction tx;

	@AroundInvoke
	public Object beginTransactionIfNotActive(InvocationContext ic) throws Throwable {
		boolean newTransaction = false;
		if (tx.getStatus() != Status.STATUS_ACTIVE) {
			tx.begin();
			newTransaction = true;
		}
		Object retVal = null;
		try {
			retVal = ic.proceed();
			if (newTransaction) {
				tx.commit();
			}
		} catch (Throwable t) {
			if (newTransaction) {
				tx.rollback();
			}
			throw t;
		}
		return retVal;
	}
}
