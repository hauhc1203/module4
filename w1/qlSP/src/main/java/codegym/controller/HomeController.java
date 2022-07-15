package codegym.controller;


import codegym.model.Category;
import codegym.model.Product;
import codegym.service.CategoryCRUD;
import codegym.service.ProductCRUD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
        @Autowired
        ProductCRUD productCRUD;
        @Autowired
        CategoryCRUD categoryCRUD;

        @RequestMapping("/home")
        public ModelAndView home(){
            ModelAndView modelAndView=new ModelAndView("home");
            modelAndView.addObject("products" ,productCRUD.getAll());
            return modelAndView;
        }


        @GetMapping("/create")
        public ModelAndView create(){
            ModelAndView modelAndView=new ModelAndView("create");

            modelAndView.addObject("categories" ,categoryCRUD.getAll());
            return modelAndView;
        }


        @PostMapping(value = "/create")
        public String createP(@ModelAttribute Product product, @RequestParam("id") int id){
            product.setCategory(categoryCRUD.findByID(id));
            productCRUD.getAll().add(product);
            return "redirect:/home";
        }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int  id){
        productCRUD.getAll().remove(productCRUD.findByID(id));
        return "redirect:/home";
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int  id){
            ModelAndView modelAndView=new ModelAndView("edit");
             modelAndView.addObject("categories" ,categoryCRUD.getAll());
            modelAndView.addObject("product",productCRUD.findByID(id));
            return modelAndView;
    }


    @PostMapping(value = "/edit")
    public ModelAndView edit(@ModelAttribute Product product,@RequestParam("id") int idC){
            ModelAndView modelAndView=new ModelAndView("redirect:/home");
            product.setCategory(categoryCRUD.findByID(idC));
            productCRUD.getAll().set(productCRUD.getIndex(product.getIdP()), product);
            return modelAndView;
    }
    @GetMapping("/search")
    public ModelAndView search(@RequestParam("key") String key){
            ModelAndView modelAndView=new ModelAndView("home");
            modelAndView.addObject("products",productCRUD.search(key));
            return modelAndView;
    }
}
