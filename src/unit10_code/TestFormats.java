package unit10_code;
import java.util.Calendar;
import java.util.Date;
public class TestFormats 
{

	public static void main(String[] args) 
	{
		String s=String.format("%,d",100000000);//%d�Ǹ�ʽ�����Ӷ��������ʾ�ã��ָ�
		System.out.println(s);
		//%��d��ʾ��ʮ���ƴ����ű�ʾ
		//%.2f����С�����2λ
		//%,.2f���������ԣ��ָ���С�����ֱ���2λ
		//format�õ��ǿɱ�����б�
		
		//Date������java�ϱ�ʾʱ�������
		s=String.format("%tc",new Date());
		//%tc��Date���͵ı�ʶ��
		System.out.println(s);
		s=String.format("%tr",new Date());
		//%tr��Date���͵ı�ʶ������ֻ��ʱ��
		System.out.println(s);
		s=String.format("%tA,%<tB,%<td",new Date());
		//%tc��Date���͵ı�ʶ��
		//<��ʾ�ظ�ʹ��ǰ��Ĳ���
		System.out.println(s);
		System.out.println("�ָ���");
		
		//Calendar�Ǹ������಻��ֱ�ӳ�ʼ�����޷�ֱ�ӵ��þ�̬����
		Calendar cal=Calendar.getInstance();//�Ծ�̬�����ĵ���
		cal.set(2019,9,31,14,54);//�·ݴ�0��ʼ
		System.out.println(cal.getTime());//ȡ��ʱ��
		long day1=cal.getTimeInMillis();//��ʱ��ת��Ϊ΢��
		day1+=1000*60*60;//�����һСʱ
		cal.setTimeInMillis(day1);
		System.out.println("new hour "+cal.get(cal.HOUR_OF_DAY));//cal.HOUR_OF_DAY��ʾСʱ
		cal.add(cal.DATE,35);
		System.out.println(cal.getTime());
		cal.roll(cal.DATE,35);//����35���·ݲ���
		System.out.println(cal.getTime());
		
	}

}
