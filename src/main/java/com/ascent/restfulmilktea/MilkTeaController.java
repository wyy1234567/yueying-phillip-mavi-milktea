package com.ascent.restfulmilktea;


import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MilkTeaController {
    private final MilkTeaService milkTeaService;

    public MilkTeaController(MilkTeaService milkTeaService) {
        this.milkTeaService = milkTeaService;
    }

    @GetMapping("/milkTea")
    public List<MilkTea> findAllMilkTeas() {
        return milkTeaService.findAllMilkTeas();
    }

    @PostMapping("/milkTea")
    public MilkTea addMilkTea (@RequestBody MilkTea milkTea) {
        return milkTeaService.addMilkTea(milkTea);
    }

    @RequestMapping(value="/milkTea/{id}", method={RequestMethod.DELETE})
    public @ResponseBody void deleteMilkTea (@PathVariable Long id) {
        milkTeaService.deleteMilkTea(id);
    }

    @GetMapping("/milkTea/{id}")
    public MilkTea getMilkTeaById(@PathVariable Long id) {
        return milkTeaService.getMilkTeaById(id);
    }

    @PatchMapping("/milkTea/{id}")
    public @ResponseBody MilkTea updateMilkTea(@PathVariable Long id,
            @RequestBody Map<String,
                Object> fields) {
        // Finds milk tea by id to update
        MilkTea milkTea = milkTeaService.getMilkTeaById(id);
        // method patches milk tea using reflection
        return milkTeaService.updateMilkTea(milkTea, fields);
    }
}
