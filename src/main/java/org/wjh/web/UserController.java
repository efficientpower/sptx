package org.wjh.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.wjh.domain.User;
import org.wjh.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping("/hello.do")
    public Object hello(@RequestParam("id") Integer id) {
        //userService.updateInTx(id);
        long start = System.currentTimeMillis();
        List<User> users = new ArrayList<User>();
        for(int i=0; i<500; i++){
            User user = new User();
            user.setName(UUID.randomUUID().toString());
            users.add(user);
        }
        userService.batchInsert(users);
        long end = System.currentTimeMillis();
        System.out.print("batch:" +(end - start));

        start = System.currentTimeMillis();
        for(int i=0; i<500; i++){
            User user = new User();
            user.setName(UUID.randomUUID().toString());
            userService.insert(user);
        }
        end = System.currentTimeMillis();
        System.out.print("recycle:" +(end - start));
        return "OK";
    }
}
