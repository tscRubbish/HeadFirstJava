package unit10_code;

public class boxing 
{

	public static void main(String[] args) 
	{
		String s="2";
		int x=Integer.parseInt(s);//���ַ���ת��Ϊint
		System.out.println(x);
		double d=Double.parseDouble("420.24");//ת��Ϊdouble
		boolean b=new Boolean("true").booleanValue();
		//boolean����ֱ�����캯�������ַ���
		d=42.5;
		String doubleString=""+d;//�������ص�+�����
		String doubleString2=Double.toString(d);//����Double��ľ�̬����
		System.out.println(doubleString);
		System.out.println(doubleString2);
	}

}
