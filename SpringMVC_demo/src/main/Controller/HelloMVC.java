package main.Controller;

import main.Entity.Login;
import main.Entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * **********************************************************
 *
 * @Project:
 * @Author : Gavincoder
 * @Mail : xunyegege@gmail.com
 * @Github : https://github.com/xunyegege
 * @ver : version 1.0
 * @Date : 2019-08-19 09:05
 * @description:
 ************************************************************/

@Controller
@RequestMapping("hello")
public class HelloMVC {

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String login() {
        System.out.println("hello mvc");
        return "redirect:/login.jsp";
    }


    @RequestMapping("loginParam")
    public String login(@RequestParam("name") String name, @RequestParam("password") String password) {

        System.out.println(name + password);
        return "redirect:/login.jsp";
    }

    @RequestMapping("loginEntity")
    public String login(User user) {

        System.out.println(user);
        return "redirect:/login.jsp";
    }

    @RequestMapping("loginView")
    public String loginView() {

        return "success";
    }

    /*ant风路径格的URL
      ?====任意单个字符
      *====任意1或多个字符
      **===一个或多个路径或没有路径
      测试链接 http://localhost:8080/hello/a/aaa/b

     */
    @RequestMapping("a/**/b")
    public String testAnt() {

        return "success";
    }

    /*Restful格式的URL


     */
    @RequestMapping(value = "testRest/{aa}")
    public String testRest(@PathVariable("aa") int id) {
        System.out.println(id);
        return "success";
    }
    //这边写restful的四种提交格式


    //增 post
    @RequestMapping(value = "restTest", method = RequestMethod.POST)
    public String RestPost() {
        System.out.println("post方法");
        return "success";

    }

    //删  delete
    @RequestMapping(value = "restTest", method = RequestMethod.DELETE)
    public String RestDelete() {
        System.out.println("delete方法");

        return "redirect:/login.jsp";

    }

    //改 put
    @RequestMapping(value = "restTest", method = RequestMethod.PUT)
    public String RestPut() {

        System.out.println("put方法");
//        return "success";
        return "redirect:/login.jsp";

    }

    //查 get
    @RequestMapping(value = "restTest", method = RequestMethod.GET)
    public String RestGet() {
        System.out.println("get方法");
        return "success";
    }



//  axios  json操作

  @RequestMapping(value = "axiosDemo",method = RequestMethod.POST)
  public String AxiosDemo(){

      System.out.println("axios成功");


      return "redirect:/test.html";


  }
   @RequestMapping(value = "axiosDemo",method = RequestMethod.PUT)
    public String AxiosDemo2(){

        System.out.println("put axios成功");
      //  System.out.println(login);
        return "redirect:/test.html";

    }

  /* @RequestMapping(value = "axiosJson",method = RequestMethod.POST)
    public String AxiosDemo3(@RequestBody Login login){
        System.out.println(login);
        System.out.println("put axios成功");
        //  System.out.println(login);
        //return "redirect:/login.jsp";
       return "redirect:/test.html";

    }*/

    @RequestMapping(value = "axiosJson",method = RequestMethod.POST)
    public @ResponseBody Login AxiosDemo3(@RequestBody Login login){
       System.out.println(login);
        System.out.println("put axios成功");
        //  System.out.println(login);
        //return "redirect:/login.jsp";
        Login login1 = new Login();
        login1.setName("betty");
        login1.setPassword("51273526");
        return login1;

    }

    @RequestMapping(value = "axiosJson2")
    public @ResponseBody Login AxiosDemo4(){
        Login login1 = new Login();
        login1.setName("betty");
        login1.setPassword("51273526");
        return login1;

    }

}
