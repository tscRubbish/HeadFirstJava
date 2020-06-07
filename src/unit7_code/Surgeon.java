package unit7_code;

public class Surgeon extends Doctor
{
	void treatPatient()//覆盖父类的方法
	{
		
	}
	void makeIncision()
	{
		
	}
}
//覆盖规则：返回类型要兼容，子类对象的保证能执行父类的一切(如bool->int)，不能降低方法的权限(public->private)
