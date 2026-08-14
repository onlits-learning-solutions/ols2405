package ols2405.mlm.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import ols2405.mlm.form.UnitForm;
import ols2405.mlm.model.Unit;
import ols2405.mlm.repository.UnitRepository;
import ols2405.mlm.response.UnitResponse;

@Service
public class UnitService {
    
    private final UnitRepository unitRepository;

    public UnitService(UnitRepository unitRepository) {
        this.unitRepository = unitRepository;
    }

    public void createService(UnitForm unitForm) {
        Unit unit = new Unit();
        unit.setUnit(unitForm.getUnit());
        unit.setName(unitForm.getName());

        unitRepository.save(unit);
    }

    public List<UnitResponse> findAll() {
        List<Unit> units = unitRepository.findAll();
        List<UnitResponse> responses = new ArrayList<>();

        for (Unit unit : units) {
            UnitResponse unitResponse = new UnitResponse();

            unitResponse.setUnit(unit.getUnit());
            unitResponse.setName(unit.getName());

            responses.add(unitResponse);
        }

        return responses;
    }
}
