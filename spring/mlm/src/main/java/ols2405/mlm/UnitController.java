package ols2405.mlm;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/unit")
public class UnitController {
    @Autowired
    private UnitRepository unitRepository;

    @GetMapping
    public String getAllUnits(Map<String, Object> model) {
        model.put("units", unitRepository.findAll());
        return "unit/units";
    }
}
