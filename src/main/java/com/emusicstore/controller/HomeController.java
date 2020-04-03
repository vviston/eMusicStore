package com.emusicstore.controller;

import com.emusicstore.dao.UserDao;
import com.emusicstore.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

@Controller
public class HomeController {

    private Path path;

    @Autowired
    private UserDao userDao;

    @RequestMapping("/")
    public String home(Model model) {
        List<User> users = userDao.getAllUsers();
        model.addAttribute("users", users);
        return "home";
    }


    @RequestMapping("/userList")
    public String getUsers(Model model) {
        List<User> users = userDao.getAllUsers();
        model.addAttribute("users", users);
        return "userList";
    }

    @RequestMapping("/userList/viewUser/{userId}")
    public String viewUser(@PathVariable Long productId, Model model) throws IOException { //path variable takes productId from mapping
        User user = userDao.getUserById(productId);
        model.addAttribute(user); //add atribute to the view
        return "viewUser";
    }

    @RequestMapping("/admin")
    public String adminPage() {
        return "admin";
    }

    @RequestMapping("/admin/userInventory")
    public String productInventory(Model model) {
        List<User> users = userDao.getAllUsers();
        model.addAttribute("users", users);
        return "userInventory";
    }

    @RequestMapping("/admin/userInventory/addUser")
    public String addProduct(Model model) {
        User user = new User();
        user.setFullName("instrument");
        user.setComsi("new");
        user.setRoom("R134");

        user.setStartDate(new Date());
        user.setCluster("default cluster");
        user.setChapter("default chapter");
        model.addAttribute("user", user);
        return "addUser";
    }

    @RequestMapping(value = "/admin/userInventory/addUser", method = RequestMethod.POST)
    public String addProductPost(@ModelAttribute("user") User user, HttpServletRequest request) {
        userDao.addUser(user);
        MultipartFile productImage = user.getUserPhoto();
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/resources/images/" + user.getId()+ ".png");
        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (IOException e) {
                e.printStackTrace();
                throw new RuntimeException("User image saving failed!");
            }
        }

        return "redirect:/admin/userInventory";
    }

    @RequestMapping("/admin/userInventory/deleteUser/{id}")
    public String deleteProduct(@PathVariable Long id, Model model, HttpServletRequest request) {
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "/WEB-INF/resources/images/" + id +".png");

        if (Files.exists(path)) {
            try {
            Files.delete(path);
        } catch (IOException e) {
            e.printStackTrace();
            }
        }
        userDao.deleteUser(id);
        return "redirect:/admin/userInventory";
    }
}
