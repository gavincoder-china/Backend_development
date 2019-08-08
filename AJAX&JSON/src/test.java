import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-05 15:05
 * @description:
 ************************************************************/
public class test {
    public static void main(String[] args) throws IOException {
        System.out.println("输入一个字符串");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        String s=input.readLine();

        if(s.indexOf("发动机")!=-1){
            System.out.println("发动机确实是傻逼");
        }

if (true){
    System.out.println("发动机是大傻逼");
}

    }

static {

    System.out.println("发动机是大傻逼");

}

}
