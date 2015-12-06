package dataSource;

import java.io.UnsupportedEncodingException;

import org.bouncycastle.jcajce.provider.digest.SHA3.DigestSHA3;
import org.bouncycastle.util.encoders.Hex;

public class PasswordEncryption {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String password = "dompass2";
		DigestSHA3 digest = new DigestSHA3(256);
		digest.update(password.getBytes("UTF-8"));
		byte[] encrypt = digest.digest();
		System.out.println(Hex.toHexString(encrypt));
	}

}
