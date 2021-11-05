package edu.catholic.controller;



import edu.catholic.Service.AccountService;


import edu.catholic.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HomeController {

    private final AccountService accountService;

    @Autowired //지워도 가능하긴 함 2개 이상 생성자 생성시 지정 필수
    public HomeController(AccountService accountService) {
        this.accountService = accountService;
    }


    @RequestMapping(value = "/")
    public String index(Model model) {
        model.addAttribute("text", "Spring Page.");
        return "index";
    }


    @RequestMapping(value = "/addUserForm")
    public String addUserForm() {
        return "addUserForm";
    }

    @RequestMapping(value = "/addUser")
    public String addUser(Model model, HttpServletRequest req) {

        Account account = new Account();
        account.setId(req.getParameter("id"));
        account.setPassword(req.getParameter("password"));
        accountService.insertAccount(account);
        model.addAttribute("text", "Spring Page.");
        return "index";
    }

    @RequestMapping(value = "/findUserForm")
    public String findUserForm() {
        return "findUserForm";
    }

    @RequestMapping(value = "/findUser")
    public String findUser(Model model, HttpServletRequest req) {

        Account account = accountService.getAccount(req.getParameter("id"));

        model.addAttribute("id", account.getId());
        model.addAttribute("password", account.getPassword());
        return "findUserResult";
    }

    @RequestMapping(value = "/UpdateUserForm")
    public String UpdateUserForm() {
        return "UpdateUserForm";
    }

    @RequestMapping(value = "/UpdateUser")
    public String UpdateUser(Model model, HttpServletRequest req) {

        Account account = new Account();
        account.setId(req.getParameter("id"));
        account.setPassword(req.getParameter("password"));
        account.set_NewPassword(req.getParameter("new_password"));

        if (req.getParameter("id") == "") { //아이디칸에 값이 없을때
            model.addAttribute("check", 1);
            return "UpdateUserResult";
        }
        if (req.getParameter("password") == "" || req.getParameter("new_password")=="") { //비밀번호칸에 값이 없을 때
            model.addAttribute("check", 2);
            return "UpdateUserResult";
        }

        Account check = accountService.getAccount(req.getParameter("id"));
        if (check == null){
            //db에 아이디가 존재하지 않을때
            model.addAttribute("check", 4);
            return "UpdateUserResult";
        }
        if (check.getId().equals(req.getParameter("id"))&&check.getPassword().equals(req.getParameter("password"))) {
            //아이디와 비밀번호가 일치하면 로그인 성공 -> 비밀번호 변경 가능
            model.addAttribute("check", 3);
            model.addAttribute("id", account.getId());
            model.addAttribute("new_password", account.getPassword());
            accountService.UpdateAccount(account);
            return "UpdateUserResult";

        } else {//아이디는 맞지만 비밀번호가 일치하지 않으면
            model.addAttribute("check", 5);
            return "UpdateUserResult";
        }

    }
}




