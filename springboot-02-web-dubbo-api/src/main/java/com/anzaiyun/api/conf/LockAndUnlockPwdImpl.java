package com.anzaiyun.api.conf;

import com.anzaiyun.api.conf.ILockAndUnlockPwd;

import javax.crypto.Cipher;
import java.security.Key;

public class LockAndUnlockPwdImpl implements ILockAndUnlockPwd {
	
	private static String defaultSecretKeyPrivate = "AnZaiyunLoveYoona"; //Ĭ��˽����Կ
	public static String defaultSecretKeyPublic = "Kill Me Heal Me";//Ĭ�Ͽ�����Կ
	
    private Cipher encryptCipherPublic = null; //������
    private Cipher decryptCipherPublic = null; //������
    private Cipher encryptCipherPrivate = null; //������
    private Cipher decryptCipherPrivate = null; //������
    
    public LockAndUnlockPwdImpl() throws Exception {
        this(defaultSecretKeyPublic);
    }
     
    /**
     * @param secretKey ���ܽ���ʹ�õ���Կ
     */
    public LockAndUnlockPwdImpl(String secretKey) {
        Key keyPublic;
        Key keyPrivate ;
        try {
        	keyPublic = getKey(secretKey.getBytes());
            encryptCipherPublic = Cipher.getInstance("DES");
            encryptCipherPublic.init(Cipher.ENCRYPT_MODE, keyPublic);
            decryptCipherPublic = Cipher.getInstance("DES");
            decryptCipherPublic.init(Cipher.DECRYPT_MODE, keyPublic);
            
            keyPrivate = getKey(this.defaultSecretKeyPrivate.getBytes());
            encryptCipherPrivate = Cipher.getInstance("DES");
            encryptCipherPrivate.init(Cipher.ENCRYPT_MODE, keyPrivate);
            decryptCipherPrivate = Cipher.getInstance("DES");
            decryptCipherPrivate.init(Cipher.DECRYPT_MODE, keyPrivate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
	 * @return the defaultSecretKeyPublic
	 */
	public static String getDefaultSecretKeyPublic() {
		return defaultSecretKeyPublic;
	}

	/**
	 * @param defaultSecretKeyPublic the defaultSecretKeyPublic to set
	 */
	public static void setDefaultSecretKeyPublic(String defaultSecretKeyPublic) {
		LockAndUnlockPwdImpl.defaultSecretKeyPublic = defaultSecretKeyPublic;
	}

	/**
     * ���� (�߼�: 1. ��Ҫ���ܵ��ַ���ת��Ϊ�ֽ�����(byte array)<br/>
     *            2. ����һ�����ֽ�������Ϊ����ʹ�ü�����(Cipher)��doFinal�������м���, �����ֽ�����<br/>
     *            3. �Ѽ��ܺ���ֽ�����ת����ʮ�����Ƶ��ַ���)<br/>
     * @param strIn Ҫ���ܵ��ַ���
     * @return ���ؼ��ܺ��ʮ�������ַ���
     * @throws Exception
     */
    private String encrypt(String strIn, Cipher cipher) throws Exception {
        return byteArr2HexStr(encrypt(strIn.getBytes(), cipher));
    }

    private byte[] encrypt(byte[] arrB, Cipher cipher) throws Exception {
        return cipher.doFinal(arrB);
    }
    
    /**
     * ���� (�߼�: 1. �Ѽ��ܺ��ʮ�������ַ���ת�����ֽ�����(byte array)<br/>
     *            2. ����һ�����ֽ�������Ϊ����ʹ�ü�����(Cipher)��doFinal�������н���, �����ֽ�����(byte array)<br/>
     *            3. �ѽ��ܺ���ֽ�����ת�����ַ���)<br/>
     * @param strIn
     * @return
     * @throws Exception
     */
    private String decrypt(String strIn, Cipher cipher) throws Exception {
        return new String(decrypt(hexStr2ByteArr(strIn), cipher));
    }

    private byte[] decrypt(byte[] arrB, Cipher cipher) throws Exception {
        return cipher.doFinal(arrB);
    }
    
    public static String byteArr2HexStr(byte[] arrB) throws Exception {
        int iLen = arrB.length;
        // ÿ��byte�������ַ����ܱ�ʾ�������ַ����ĳ��������鳤�ȵ�����
        StringBuffer sb = new StringBuffer(iLen * 2);
        for (int i = 0; i < iLen; i++) {
            int intTmp = arrB[i];
            // �Ѹ���ת��Ϊ����
            while (intTmp < 0) {
                intTmp = intTmp + 256;
            }
            // С��0F������Ҫ��ǰ�油0
            if (intTmp < 16) {
                sb.append("0");
            }
            sb.append(Integer.toString(intTmp, 16));
        }
        return sb.toString();
    }

    public static byte[] hexStr2ByteArr(String strIn) throws Exception {
        byte[] arrB = strIn.getBytes();
        int iLen = arrB.length;
        // �����ַ���ʾһ���ֽڣ������ֽ����鳤�����ַ������ȳ���2
        byte[] arrOut = new byte[iLen / 2];
        for (int i = 0; i < iLen; i = i + 2) {
            String strTmp = new String(arrB, i, 2);
            arrOut[i / 2] = (byte) Integer.parseInt(strTmp, 16);
        }
        return arrOut;
    }
    
    private Key getKey(byte[] arrBTmp) throws Exception {
        // ����һ���յ�8λ�ֽ����飨Ĭ��ֵΪ0��
        byte[] arrB = new byte[8];
        // ��ԭʼ�ֽ�����ת��Ϊ8λ
        for (int i = 0; i < arrBTmp.length && i < arrB.length; i++) {
            arrB[i] = arrBTmp[i];
        }
        // ������Կ
        Key key = new javax.crypto.spec.SecretKeySpec(arrB, "DES");
        return key;
    }



	@Override
	public String lockPassword(String pwd) throws Exception {
		// TODO Auto-generated method stub
		String publicDes = encrypt(pwd,encryptCipherPublic);  //һ�μ��ܣ�������Կ
        
        String privateDes = encrypt(publicDes,encryptCipherPrivate);   //���μ��ܣ�˽����Կ
		
		return privateDes;
	}

	@Override
	public String unlockPassword(String pwd) throws Exception{

		String privateDes = decrypt(pwd, decryptCipherPrivate);
		
		String publicDes = decrypt(privateDes, decryptCipherPublic);

		return publicDes;
	}
	
	 /**
     * �÷�ʵ��
     */
//    public static void main(String[] args) {
//        try {
//            String test = "https://blog.csdn.net/cainiao0589/article/details/101015485";
//            //ע������Զ���ļ��ܵ�KEYҪ�ͽ��ܵ�KEYһ�£������Կ�ף�����������ˣ�ȴ����Կ�ף���ô�ǽ��ܲ��˵�
//            LockAndUnlockPwdImpl des = new LockAndUnlockPwdImpl("leemenz"); //�Զ�����Կ
//            String lockpwd = des.lockPassword(test);
//            String ulockpwd = des.unlockPassword(lockpwd);
//            System.out.println("����ǰ���ַ���" + test);
//            System.out.println("���ܺ���ַ���" + lockpwd);
//            System.out.println("���ܺ���ַ���" + ulockpwd);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

}
