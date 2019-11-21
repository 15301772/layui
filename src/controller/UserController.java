package controller;

import pojo.User;
import service.UserDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
@Controller
public class UserController {
    @Autowired
    UserDao userDao;
    @Autowired
    HttpServletRequest httpServletRequest;

    @RequestMapping("/layui.action")
    @ResponseBody
    public String layui(@RequestBody User user) {
        HttpSession session = httpServletRequest.getSession();
        User user1 = userDao.Login(user);
        if (user!=null){
            session.setAttribute("user",user1);
            String msg = "success";
            return msg;
        }else {
            String msg = "fail";
            return msg;
        }
    }
//    @RequestMapping("selectLayUitable.action")
//    @ResponseBody
//    public Map<String, Object> selectLayUitable() {
//        Map<String, Object> returnTable = new HashMap<>();
//        returnTable.put("code", 0);
//        returnTable.put("msg", "");
////        List<User> users = userDao.;
//    }
    @RequestMapping("/login.action")
    public String Login(User user, Model model) {
        HttpSession session = httpServletRequest.getSession();
        User user1 = userDao.Login(user);
        String password = user.getPassword();
        if (user1 != null) {
            session.setAttribute("user", user1);
            return "redirect:frame.jsp";
        } else {
            model.addAttribute("msg", "用户名或密码错误，请重新登录");
            return "login.jsp";
        }
    }
//    @RequestMapping("selectLayUitable_Page.action")
//    @ResponseBody
//    public Map<String, Object> selectLayUitable_Page(int page, int limit) {
//
//        HashMap<String, Integer> map = new HashMap<>();
//        int pageStart = (page - 1) * limit;
//        map.put("pagestart", pageStart);
//        map.put("size", limit);
//        List<User> users = userDao.selectpage(map);
//        Map<String, O

//    @RequestMapping("/userList.action")
//    public ModelAndView userList() {
//        return
//    }
}