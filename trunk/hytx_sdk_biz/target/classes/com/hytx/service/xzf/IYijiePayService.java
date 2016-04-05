package com.hytx.service.xzf;

import com.hytx.model.xzf.XzfYijieBill;
import com.hytx.model.xzf.XzfYijieResult;

public interface IYijiePayService {

	String login(String uin, String sess);

	int insertYijieBill(XzfYijieBill yijieBill);

	int insertYijieResult(XzfYijieResult yijieResult);

	XzfYijieBill selectXzfYijieBillByOrderId(String orderId);

}
