package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class HelloController {

    @GetMapping("hello")
    public String hello(Model model){
        model.addAttribute("data","hello!!");
        return "hello";
    }

    @GetMapping("hello-mvc")
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name", name);
        return "hello-template";
    }

    @GetMapping("hello-string")
    @ResponseBody //http의 body부에 이 데이터를 직접 넣어주겠다는 의미
    public String helloString(@RequestParam("name") String name, Model model){
        return "hello " + name;
    }

    @GetMapping("hello-api")
    @ResponseBody
    public Hello helloApi(@RequestParam("name") String name, Model model){
        Hello hello = new Hello();
        hello.setName(name);
        return hello;
    }

    @GetMapping("test")
    public String test(@RequestParam Map map, Model model){
        model.addAllAttributes(map);
        return "test2";
    }

    @GetMapping("test2")
    public void test2(HttpServletRequest hreq){
        System.out.println(hreq.getRemoteAddr());
    }

    static class Hello{
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
