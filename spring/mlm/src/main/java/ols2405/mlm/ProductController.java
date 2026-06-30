package ols2405.mlm;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.validation.Valid;
import ols2405.mlm.form.ProductForm;

@Controller
@RequestMapping(path = "/product")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    
    @GetMapping()
    public String getAllProducts(Map<String, Object> model) {
        model.put("products", productRepository.findAll());
        return "product/products";
    }
    
    @GetMapping(path = "/create")
    public String getProductCreate() {
        return "product/create";
    }
    
    @PostMapping()
    public String addNewProduct(@Valid @ModelAttribute ProductForm productForm, BindingResult result) {
        Product product = new Product();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        productRepository.save(product);
        return "redirect:/product";
    }

    @GetMapping(path = "/edit/{id}")
    public String getProductEdit(@PathVariable("id") int id, Model model) {
        Product product = productRepository.findById(id).orElseThrow();
        model.addAttribute("product", product);
        return "product/edit";
    }

    @PostMapping(path = "/edit/{id}")
    public String updateProduct(@PathVariable("id") int id, @Valid @ModelAttribute ProductForm productForm) {
        Product product = productRepository.findById(id).orElseThrow();
        product.setName(productForm.getName());
        product.setDescription(productForm.getDescription());
        productRepository.save(product);
        return "redirect:/product";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteProduct(@PathVariable("id") int id) {
        Product product = productRepository.findById(id).orElseThrow();
        productRepository.delete(product);
        return "redirect:/product";
    }
}