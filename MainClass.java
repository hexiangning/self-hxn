package mvc.view;

import java.util.ArrayList;
import java.util.Scanner;

import mvc.control.Operator;
import mvc.io.IO;
import mvc.model.Book;
import mvc.model.BookList;

import org.junit.Test;

public class MainClass {  
    /* 
    public static final int SIZE = 10; 
    Book[] booklist = new Book[SIZE]; 
    */  
      
    public MainClass()  
    {  
          
        Scanner scan = new Scanner(System.in);  
        IO io = new IO();  
        io.load();  
        printMenu();  
          
        while(true)  
        {  
            //读取用户输入  
            int choice = scan.nextInt();  
              
            if(choice == 5)  
            {  
                io.save();  
                System.out.println("成功退出系统，欢迎再次光临！");  
                break;  
            }  
            switch(choice)  
            {  
            case 1: addBook(); break;  
            case 2: deleteBoo(); break;  
            case 3: changeBoo(); break;  
            case 4: findBoo(); break;  
            default: System.out.println("输入非法"); printMenu(); continue;  
            }  
        }  
          
          
        /* 
        while(true) 
        {    
            //根据用户输入调用不同方法 
            if(choice == 1) 
            { 
                addBook(); 
            } 
            else if(choice == 2) 
            { 
                deleteBoo(); 
            } 
            else if(choice == 3) 
            { 
                changeBoo(); 
            } 
            else if(choice == 4) 
            { 
                findBoo(); 
            } 
            else if(choice == 5) 
            { 
                System.out.println("成功退出系统，欢迎再次光临！"); 
                break; 
            } 
        } 
        */  
    }  
    void printMenu()  
    {  
        //打印菜单  
        System.out.println("欢迎...");  
        System.out.println("增加图书...1");  
        System.out.println("删除图书...2");  
        System.out.println("修改图书...3");  
        System.out.println("查询图书...4");  
        System.out.println("退出系统...5");   
    }  
      
    void addBook()  
    {  
        System.out.println("当前共有:"+BookList.booklist.size()+"本书!");  
        Scanner scan = new Scanner(System.in);  
        System.out.println("请输入图书名：");  
        String bookname = scan.next();  
        System.out.println("请输入作者：");  
        String author = scan.next();  
        System.out.println("请输入单价：");  
        float price = scan.nextFloat();  
        Operator operator = new Operator();  
        boolean isSuccess = operator.addBook(bookname, author, price);  
        if(isSuccess)  
        {  
            System.out.println("增加成功！");  
        }  
        else  
        {  
            System.out.println("增加失败！");  
        }  
        operator.printAllBook();  
    }  
      
    void deleteBoo()  
    {  
        Scanner scan = new Scanner(System.in);  
        while(true)  
        {  
            System.out.println("请输入按哪种方法删除图书：1、序号/2、书名/3、返回主菜单");  
            int choose = scan.nextInt();  
            if(choose == 1)  
            {  
                System.out.println("请输入要删除第几本书：");  
                int id = scan.nextInt();  
                Operator operator = new Operator();  
                id = operator.orderFind(id);  
                //System.out.println(id);  
                if(id > -1)  
                {  
                    /* 
                    for(int i = id; i < count - 1 ; i++) 
                        booklist[i]=booklist[i+1]; 
                    */  
                    boolean isSuccess = operator.deleteBook(id);  
                    if(isSuccess)  
                        System.out.println("删除成功！");  
                    else  
                        System.out.println("删除失败！");  
                    operator.printAllBook();  
                }  
                else  
                {  
                    System.out.println("输入错误！");  
                }  
            }  
            else if(choose == 2)  
            {  
                System.out.println("请输入您要删除的书名：");  
                String name = scan.next();  
                Operator operator = new Operator();  
                int id = operator.nameFind(name);  
                if(id > -1)  
                {  
                    /* 
                    for(int j = id; j<count-1; j++) 
                    { 
                        booklist[j]=booklist[j+1]; 
                    } 
                    */  
                    boolean isSuccess = operator.deleteBook(id);  
                    if(isSuccess)  
                        System.out.println("删除成功！");  
                    else  
                        System.out.println("删除失败！");  
                    operator.printAllBook();  
                }  
                else  
                {  
                        System.out.println("未查找到您想要的书名");  
                }     
            }  
            else if(choose == 3)  
            {  
                printMenu();  
                break;  
            }  
            else  
            {  
                System.out.println("输入非法！");  
            }  
        }  
    }  
      
    void changeBoo()  
    {  
        Scanner scan = new Scanner(System.in);  
        while(true)  
        {  
            System.out.println("请输入按哪种方法修改图书：1、序号/2、书名/3、返回主菜单");  
            int choose = scan.nextInt();  
            if(choose == 1)  
            {  
                System.out.println("请输入要修改第几本书：");  
                int number = scan.nextInt();  
                Operator operator = new Operator();  
                int id = operator.orderFind(number);  
                if(id > -1)  
                {  
                    Book book = (Book)BookList.booklist.get(id);  
                    //System.out.println("原书名为："+booklist[id].getBookname()+" 请输入你要修改为什么书名：");  
                    System.out.println("原书名为："+book.getBookname()+" 请输入你要修改为什么书名：");  
                    String str = scan.next();  
                    System.out.println("请输入作者：");  
                    String author = scan.next();  
                    System.out.println("请输入单价：");  
                    double price = scan.nextDouble();  
                    //booklist[id].setBook(str,author,price);  
                    boolean isSuccess = operator.changeBoo(id,str,author,price);  
                    if(isSuccess)  
                        System.out.println("修改成功！");  
                    else  
                        System.out.println("修改失败！");  
                    operator.printAllBook();  
                }  
                else  
                {  
                    System.out.println("输入错误！");  
                }  
            }  
            else if(choose == 2)  
            {  
                System.out.println("请输入您要修改的书名：");  
                String name = scan.next();  
                Operator operator = new Operator();  
                int id = operator.nameFind(name);  
                if(id > -1)  
                {  
                    Book book = (Book)BookList.booklist.get(id);  
                    //System.out.println("原书名为："+booklist[id].getBookname()+" 请输入你要修改为什么书名：");  
                    System.out.println("原书名为："+book.getBookname()+" 请输入你要修改为什么书名：");  
                    String str = scan.next();  
                    System.out.println("请输入作者：");  
                    String author = scan.next();  
                    System.out.println("请输入单价：");  
                    double price = scan.nextDouble();   
                    //booklist[id].setBook(str,author,price);  
                    boolean isSuccess = operator.changeBoo(id,str,author,price);  
                    if(isSuccess)  
                        System.out.println("修改成功！");  
                    else  
                        System.out.println("修改失败！");  
                    operator.printAllBook();  
                }  
            }  
            else if(choose == 3)  
            {  
                printMenu();  
                break;  
            }  
            else  
            {  
                System.out.println("输入非法！");  
            }  
        }  
    }  
      
    void findBoo()  
    {  
        Scanner scan = new Scanner(System.in);  
        Operator operator = new Operator();  
        while(true)  
        {  
            System.out.println("请输入按哪种方法查找图书：1、序号/2、书名/3、返回主菜单");  
            int choose = scan.nextInt();  
            if(choose == 1)  
            {  
                System.out.println("请输入要查找第几本书：");  
                int number = scan.nextInt();  
                int id = operator.orderFind(number);  
                if(id > -1)  
                {  
                    operator.findBoo(id);  
                }  
                else  
                {  
                    System.out.println("输入错误！");  
                }  
            }  
            else if(choose == 2)  
            {  
                System.out.println("请输入您要查找的书名：");  
                String name = scan.next();  
                int id = operator.nameFind(name);  
                if(id > -1)  
                {  
                    operator.findBoo(id);  
                }  
            }  
            else if(choose == 3)  
            {  
                printMenu();  
                break;  
            }  
            else  
            {  
                System.out.println("输入非法！");  
            }  
        }  
    }  
      
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        new MainClass();  
    }  
  
}  