package services.wechat.util;

import java.io.File;

import play.Play;
import services.wechat.config.WechatPayConfig;

/**
 * User: rizenguo
 * Date: 2014/10/29
 * Time: 14:40
 * 这里放置各种配置数据
 */
public class Configure {
//这个就是自己要保管好的私有Key了（切记只能放在自己的后台代码里，不能放在任何可能被看到源代码的客户端程序中）
	// 每次自己Post数据给API的时候都要用这个key来对所有字段进行签名，生成的签名会放在Sign这个字段，API收到Post数据的时候也会用同样的签名算法对Post过来的数据进行签名和验证
	// 收到API的返回的时候也要用这个key来对返回的数据算下签名，跟API的Sign数据进行比较，如果值不一致，有可能数据被第三方给篡改
//	private static final String CERT_PATH=Play.configuration.getProperty("wxpay.sslcert_path");
	private static String certLocalPath = Play.applicationPath.getAbsolutePath()+File.separator+"conf/apiclient_cert.p12";

	//HTTPS证书密码，默认密码等于商户号MCHID
	private static String certPassword = WechatPayConfig.MCHID;

	//是否使用异步线程的方式来上报API测速，默认为异步模式
	private static boolean useThreadToDoReport = true;
	
	public static final String PAY_API="https://api.mch.weixin.qq.com/pay/unifiedorder";

	public static final String RED_PACK_API="https://api.mch.weixin.qq.com/mmpaymkttransfers/sendredpack";
	
	public static final String REFUND_API="https://api.mch.weixin.qq.com/secapi/pay/refund";
	
	public static final String CHECK_API="https://api.mch.weixin.qq.com/pay/orderquery";
	
	public static boolean isUseThreadToDoReport() {
		return useThreadToDoReport;
	}

	public static void setUseThreadToDoReport(boolean useThreadToDoReport) {
		Configure.useThreadToDoReport = useThreadToDoReport;
	}

	public static String HttpsRequestClassName = "com.tencent.common.HttpsRequest";

	

	public static void setCertLocalPath(String certLocalPath) {
		Configure.certLocalPath = certLocalPath;
	}

	public static void setCertPassword(String certPassword) {
		Configure.certPassword = certPassword;
	}
	
	public static String getCertLocalPath(){
		return certLocalPath;
	}
	
	public static String getCertPassword(){
		return certPassword;
	}

	public static void setHttpsRequestClassName(String name){
		HttpsRequestClassName = name;
	}

}