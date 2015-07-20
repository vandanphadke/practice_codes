import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


public class Test {
	final protected static char[] hexArray = "0123456789ABCDEF".toCharArray();
	
	public static void main(String[] args) throws NoSuchAlgorithmException {
		byte[] address = checkAddress("2D16B005E5C6032E47E23B1A62BD3558D9DE87ADA9A05D80EADA3FA847D20D38", "bvhhzozbs");
		String correct= "TNgJ8DKwzVza6GfTf9UWzpeLYTRigKB32fV";
		//System.out.println(address);
		//System.out.println(correct);
		//System.out.println(address.equals(correct));
		
		hexStringToByteArray("2D16B005E5C6032E47E23B1A62BD3558D9DE87ADA9A05D80EADA3FA847D20D38");
	}
	
private static byte[] checkAddress(String public_key, String UserName) throws NoSuchAlgorithmException{
		
		//byte[] PublicKey = hexStringToByteArray(public_key);
		byte[] PublicKey = hexStringToByteArray(public_key);
		byte[] NAME = UserName.getBytes(Charset.forName("ISO-8859-1"));
		//System.out.println(bytesToHex(NAME));
		MessageDigest digest = MessageDigest.getInstance("SHA-512");
        byte[] Hpk = digest.digest(public_key.getBytes());
        byte[] NA_Type = new byte[]{(byte) 14, (byte)217};
        //System.out.println(bytesToHex(NA_Type));
        
        byte[] Hpk__PK__NAME = new byte[Hpk.length + PublicKey.length + NAME.length + NA_Type.length];
        System.arraycopy(Hpk, 0, Hpk__PK__NAME, 0, Hpk.length);
        System.arraycopy(PublicKey, 0, Hpk__PK__NAME, Hpk.length, PublicKey.length);
        System.arraycopy(NAME, 0, Hpk__PK__NAME, PublicKey.length + Hpk.length, NAME.length);
        System.arraycopy(NA_Type, 0, Hpk__PK__NAME, PublicKey.length + Hpk.length + NAME.length, NA_Type.length);
        System.out.println(bytesToHex(Hpk__PK__NAME));
        byte[] H_Hpk__PK__NAME = new byte[20];
        //ArrayUtils.subarray(digest.digest(Hpk__PK__NAME), 0, 20);
        byte[] temp = digest.digest(Hpk__PK__NAME);
        for(int i = 0 ; i < 19 ; i++){
        	H_Hpk__PK__NAME[i] = temp[i];
        }
        System.out.println(bytesToHex(H_Hpk__PK__NAME));
        byte[] Address_PH = new byte[22];

        Address_PH[0] = NA_Type[0];
        Address_PH[1] = NA_Type[1];
        System.arraycopy(H_Hpk__PK__NAME, 0, Address_PH, 2, 20);
        System.out.println(new String(Address_PH));
		return Address_PH; 
	}

	public static byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
                + Character.digit(s.charAt(i + 1), 16));
		}
		return data;
	}
	
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = hexArray[v >>> 4];
            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
        }
        return new String(hexChars);
    }
	
}
