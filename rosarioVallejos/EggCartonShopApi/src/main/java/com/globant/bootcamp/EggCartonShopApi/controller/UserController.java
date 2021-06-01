package com.globant.bootcamp.EggCartonShopApi.controller;


import com.globant.bootcamp.EggCartonShopApi.dao.UserRepository;
import com.globant.bootcamp.EggCartonShopApi.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class UserController {

    @Autowired
    UserRepository repository;

    @GetMapping("indexes")
    public String index(Model modelo, User user) {
        modelo.addAttribute("Usuario",new User());
        modelo.addAttribute("Usuarios",repository.findAll());
        return "indexes";
    }

    @PostMapping("/crearUsuario")
    public String crearUsuario(Model modelo, User user) {
          repository.save(user);
        modelo.addAttribute("Usuario",new User());
        modelo.addAttribute("Usuarios",repository.findAll());
        return "indexes";
    }

    @GetMapping("/editarUsuario/{id}")
    public String editarUsuarioForm(Model modelo, @PathVariable(name="id") Long id) {
        User usuarioParaEditar = repository.findById(id).get();
        modelo.addAttribute("Usuario",usuarioParaEditar);
        modelo.addAttribute("Usuarios",repository.findAll());
        return "indexes";
    }

    @GetMapping("/eliminarUsuario/{id}")
    public String eliminarUsuario(Model modelo, @PathVariable(name="id") Long id) {
        User usuarioParaEliminar = repository.findById(id).get();
        repository.delete(usuarioParaEliminar);
        modelo.addAttribute("Usuario",new User());
        modelo.addAttribute("Usuarios",repository.findAll());
        return "indexes";
    }
}

