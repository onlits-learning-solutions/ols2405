package ols2405.mlm.controller;

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
import ols2405.mlm.form.UnitForm;
import ols2405.mlm.model.Unit;
import ols2405.mlm.repository.UnitRepository;
import ols2405.mlm.service.UnitService;

@Controller
@RequestMapping(path = "/unit")
public class UnitController {
    @Autowired
    private UnitRepository unitRepository;
    
    private final UnitService unitService;
    public UnitController(UnitService unitService) {
        this.unitService = unitService;
    }

    @GetMapping
    public String getAllUnits(Map<String, Object> model) {
        model.put("units", unitService.findAll());
        return "unit/units";
    }

    @GetMapping(path = "/create")
    public String getProductCreate() {
        return "unit/create";
    }

    @PostMapping
    public String addNewUnit(@Valid @ModelAttribute UnitForm unitForm, BindingResult result) {
        
        if(result.hasErrors()) {
            return "unit/create";
        }
    
        unitService.createService(unitForm);

        
        return "redirect:/unit";
    }

    @GetMapping(path = "/edit/{unit}")
    public String getProductEdit(@PathVariable("unit") String unitParam, Model model) {
        Unit unit = unitRepository.findById(unitParam).orElseThrow();
        model.addAttribute("unit", unit);
        return "unit/edit";
    }

    @PostMapping(path = "/edit/{unit}")
    public String updateUnit(@PathVariable("unit") String unitParam, @Valid @ModelAttribute UnitForm unitForm) {
        Unit unit = unitRepository.findById(unitParam).orElseThrow();
        unit.setUnit(unitForm.getUnit());
        unit.setName(unitForm.getName());
        unitRepository.save(unit);
        return "redirect:/unit";
    }

    @GetMapping(path = "/delete/{unit}")
    public String deleteUnit(@PathVariable("unit") String unitParam) {
        Unit unit = unitRepository.findById(unitParam).orElseThrow();
        unitRepository.delete(unit);
        return "redirect:/unit";
    }
}
