package com.example.basicguiexercise.Controller;

import com.example.basicguiexercise.Model.Pet;
import com.example.basicguiexercise.Utility.Connection;
import com.example.basicguiexercise.Utility.SqlHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

@Controller
public class PetController {
    ArrayList<Pet> getPets() throws SQLException {
        Statement s = Connection.getCon().createStatement();

        ArrayList<Pet> pets = new ArrayList<>();

        ResultSet rs = s.executeQuery("SELECT * FROM pets");

        while (rs.next()) {
            Pet pet = new Pet();
            pet.setId(rs.getString("id"));
            pet.setAnimal(rs.getString("animal"));
            pet.setName(rs.getString("name"));
            pet.setGender(rs.getString("gender"));
            pet.setDiet(rs.getString("diet"));
            pets.add(pet);
        }
        Connection.getCon().close();

        return pets;
    }

    @GetMapping("/")
    String home() {
        return "addPet";
    }

    @PostMapping("/addPet")
    public String addPet(@ModelAttribute Pet pet, Model model) throws SQLException {
        model.addAttribute("new_pet", pet);
        Statement s = Connection.getCon().createStatement();
        String inputs = "('" + pet.getAnimal() + "','" + pet.getName() + "','" + pet.getGender() + "','" + pet.getDiet() + "')";
        s.execute("INSERT INTO pets (animal,name,gender,diet) VALUES " + inputs);
        Connection.getCon().close();
        model.addAttribute("showList", getPets());
        return "redirect:/showList";
    }

    @PostMapping("/updatePet")
    public String updatePet(@ModelAttribute SqlHelper sqlHelper, Model model) throws SQLException {

        model.addAttribute("sqlHelper", sqlHelper);

        Statement s = Connection.getCon().createStatement();
        String sql = "UPDATE pets SET " + sqlHelper.getField() + " = '" + sqlHelper.getValue() + "' WHERE (id = " + sqlHelper.getId() + ")";
        System.out.println(sql);
        s.execute(sql);
        Connection.getCon().close();
        return "redirect:/showList";
    }

    @PostMapping("/updatePetForm")
    String updatePetForm(@ModelAttribute SqlHelper sqlHelper, Model model) {
        model.addAttribute("id", sqlHelper.getId());
        return "updatePet";
    }

    @GetMapping("/deletePet/{id}")
    String deletePetForm(@PathVariable String id) throws SQLException {
        Statement s = Connection.getCon().createStatement();
        s.execute("DELETE FROM pets WHERE id = " + id);
        Connection.getCon().close();
        return "redirect:/showList";
    }

    @GetMapping("/showList")
    public String addPet(Model model) throws SQLException {
        model.addAttribute("showList", getPets());
        return "showList";
    }
}
