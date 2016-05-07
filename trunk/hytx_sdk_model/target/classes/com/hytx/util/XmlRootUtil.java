package com.hytx.util;
import java.io.StringReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import net.sf.json.JSONObject;
import com.hytx.util.root;

public class XmlRootUtil {
	public static root getroot(String mo) {	
		try {
			String str = HttpClientUtil
					.simpleVisitUrl("http://life.tenpay.com/cgi-bin/mobile/MobileQueryAttribution.cgi?chgmobile="
							+ mo);
			JAXBContext context = JAXBContext.newInstance(root.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			root rot = (root) unmarshaller.unmarshal(new StringReader(str));

			return rot;
		} catch (Exception e) {
			root rot = getTaobao(mo);
			if (rot != null) {
				rot.setCity("-");
				return rot;
			} else {
				rot = getPaiPai(mo);
				if (rot.getProvince().equals("δ֪")) {
					rot.setProvince("-");
					rot.setCity("-");
				}
			}
			rot.setCity("-");
			return rot;
		}

	}

	public static root getTaobao(String mo) {
		

		try {
			String str = HttpClientUtil
					.simpleVisitUrl("http://tcc.taobao.com/cc/json/mobile_tel_segment.htm?tel="
							+ mo);
			JSONObject jsonObject = JSONObject.fromObject(str.substring(str
					.indexOf("{")));
			String province = jsonObject.getString("province");
			root rot = new root();
			rot.setProvince(province);
			return rot;

		} catch (Exception e) {

			return null;
		}
		
	}

	public static root getPaiPai(String mo) {
		

		try {
			String str = HttpClientUtil
					.simpleVisitUrl("http://virtual.paipai.com/extinfo/GetMobileProductInfo?amount=10000&callname=getPhoneNumInfoExtCallback&mobile="
							+ mo);
			JSONObject jsonObject = JSONObject.fromObject(str.substring(
					str.indexOf("{"), str.indexOf(")")));
			String province = jsonObject.getString("province");
			root rot = new root();
			rot.setProvince(province);
			return rot;

		} catch (Exception e) {
			System.out.println("1");
			return null;
		}
	
	}

	public static void main(String[] args) {
		System.out.println(getPaiPai("15313598288"));
	}
}
