package app.utils;

public class AlipayAttr {
	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2016101300679777";

	// 商户应用私钥，您的PKCS8格式RSA2私钥
	public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQDMjtmqOfv54mKJnn6aDRwmyU/Bz1RS+i6n6JRbsfcKN1VJKzi0O+QxpfdxeBbcvnss1eykHZD+8uiYudjae+oMd36JVfSu7tHwbyPYfgYMKSWiWYXQlC/TjBLoJUmJeIfFUKKxdNfniaQEivrnthJfXLa1bTqk/Zuec7xEj64Xg/mGm07UEDMOAde7YZBcx4MlnhhkaSDuvVBY+hoKf4/15yASqKtbFLI87s4XN4V7zHq211SFgD8XzltwHuDumi7weh7cHKiuh3qw70EH36N50psQ3NnIy3lsFmo+hs4jqK6jdKNigz4w3EVsbjcKb+iiXSE0k44/CnnR/EMlm2UhAgMBAAECggEBAI7Ol8UQkApG8tXy0Z3I00N8vXKnxM3dHV9ZruFJIBeAw8i+JOsm+Mt0e4g693MKhEGr43Y7sfNbL+kXrf3yDla/wZYtbRIHZod9f7/vU1eADmcGKraQDceZfcWV6n3PqLGm9r3+vZBGdjw5rqq/YJo0xtVoOU3gQ5leYSxYRojg+J01sQYMzq0/LqdDCgo8z8WAzouh+SJu4QC4QWvi9cenYuI057p7Vl7hPp71G1BtnM43ig1ymTj27yuB5aAjYTAlATouDU6lu1Il/Nvt42AYCYchx8h+6mHZJF73eHLZWbL/7hRPAvUVq5kR6hNiEsUHKmW2bBpiRmebJOYKDrECgYEA9jvmi34dNbrk1kJyyQ4NSzsX25VWGYzkhafSqrqNhB267zBUkwQtuOJcFskjUhgf/loUqhJxxhSheln6rQCknqiIge4eJA3GGtoa3cgGPTyC5haF18lbnTQlV56PBPNQZfcPUpZlxf14QyzJSLCnS0OetMuTNtAGhT7OMaeM8vUCgYEA1KvMiTavDax4bWK+X0uwpRbOwHlf2PTAF4L4JJNZdyFQHXiHZI5SrCYv1ANd7ZAmonePTi8DtwE3UbpSox5NYSB32MrWbk9k+uEC4859mhAa3J/90HBj4xXRoEvZgfK8jyCCvZtm+oT6LRqq+/wVpkE6rNFhx0i1SvMbjm7+hf0CgYAmSCfOthu6d8UOHqST55Bfit9pry0Eqef5c58IFhrcWHbwqvXrKXImVWL10+2e3MtUkxK1Ykq3/gsg545WiUwOsqsOcEPVXSLYl+Inauq1aIv9U7EZXF/W7/2CQs9/eIieYavLLkDCaGbjIrpkh7pqtCefeir4EZ2B58LM63y5ZQKBgQDK+LxZKMuhrT2yiE9Q/Bg3N7FTmYOUuOKsjd7uaYM1Y6HmvqXZnsvgaQG0wxHeLXnyDVHEOLK+8nYtljpQXBdV33sCeXR2C2hA2Ie9i9HsO/qnHjtLuDhc/vH2nu2UTGsR3uFovOxnpIpwiccuf8TZy9+IGL3NSONeCO//3IcmsQKBgA8FzxzffB7NSUd/OPG7upjjlJWyoJPH/6ozHLRF7kk4rJ6WL+f6kAI/y7GmyvOnlck8bxkX6+zWVEpKgI5NTeSB2noz84vUsT3LiO0tM4kdW8ncGGD4oJnbmcKIGWM1VuAHuECQ5OBL5CR3qMuaNGZ836N8Xr0vR68HBOOos5h1";

	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm
	// 对应APPID下的支付宝公钥。
	public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAoC3Om+x1Ns1xjB7UvSF1H2GrS1HqMpNa2kAH6icBhj5FYlmST3n2bY4NpBb47EcqUG4vNVqKaKZwKuMaF90utDYjljYIFfL7twnn5Zvc7tfZFJ3n0W4tRxLx52V4IbZ9b7s4RO2RdVGWWxggEXt1M1pM8+cXNtcVXwJMYtAkMT9Gaa5J7lGhKcKrEGl9zNnZBNf0V1bFcQliw8Wpa/XfdySznb929IVn2LAOERn6ziEwVWDC+tXjPiOqZlurwe+5OYK38xMTZTCqYsE87XbHYfY5fHxO/PqmZgYZvBdtS/ZyVF6SYPrXEqgpCY2expdFc2c45ETOgijrKhbkqNkH6QIDAQAB";

	// 服务器异步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String notify_url = "http://localhost:8080/alipay/payNotify";

	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	public static String return_url = "http://localhost:8080/alipay/payResult";

	// 签名方式
	public static String sign_type = "RSA2";

	// 字符编码格式
	public static String charset = "utf-8";

	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
}
