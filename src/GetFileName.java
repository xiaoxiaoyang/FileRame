import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;



public class GetFileName    
{
	String A4 = "fake_NR_USB_Indoor_warpA4Photo_";
	String moveEye = "fake_NR_USB_Indoor_moveEyeA4Photo_";
	String copper = "fake_NR_USB_Indoor_warpCopperPhoto_";
    public static String [] getFileName(String path)
    {
        File file = new File(path);
        String [] fileName = file.list();
        return fileName;
    }  	
    
   
    public static void main(String[] args)
    {
    	int n = 9;
    	int m = 4;
        String [] fileName = getFileName("E:\\data\\data");
        ArrayList arrayList = new ArrayList();
        for(String name:fileName)
        {
           // System.out.println(name);
            String str_id=name.substring(name.length()-n,name.length()-m);//第一个参数是开始截取的位置，第二个是结束位置。
           // System.out.println(str_id);
            int id = Integer.valueOf(str_id).intValue(); 
           // System.out.println(id);
            Allname alln = new Allname(name, id);
            arrayList.add(alln);
        }         
        
        Object[] names =arrayList.toArray();
        System.out.println ("排序前。。。。");
        for (int i = 0; i<names.length; i++){
         System.out.println (names[i]);
        }
        System.out.println ("*******************************");
        System.out.println ("排序后。。。。。");
        //把排序规则交给sort方法。该方法就会按照自定义的规则进行排序       
        java.util.Arrays.sort(names,new MyComparator());
        for (int i = 0; i<names.length; i++){
         System.out.println (names[i]);
        }
    }
 }
class Allname{
	 String name;
	 int id ;
	 
	 public Allname(String name,int id){
	  this.name  = name;
	  this.id = id; 
	 }
	 
	 public String toString(){
	  return name;
	 }
	 
}



class MyComparator implements Comparator{
	 public  int compare(Object  obj1, Object obj2 ){
	  Allname u1 = (Allname)obj1;
	  Allname u2 = (Allname)obj2;
	  if(u1.id>u2.id){
	   return 1;
	  }else if(u1.id<u2.id){
	   return -1;
	  }else{
	   //利用String自身的排序方法。
	   //如果年龄相同就按名字进行排序
	   return u1.name.compareTo(u2.name);
	  }
	  
	  
	 }
	} 