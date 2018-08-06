package com.softuni.controller;

import com.softuni.entity.Calculator;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.DecimalFormat;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("operator", "+");
        model.addAttribute("view", "views/calculatorForm");
        return "base-layout";
    }

    @PostMapping("/")
    public String calculate(@RequestParam String leftOperand,
                            @RequestParam String operator,
                            @RequestParam String rightOperand,
                            Model model) {
        model.addAttribute("view", "views/calculatorForm");

        double num1;
        double num2;

        DecimalFormat df = new DecimalFormat("#.########");

        try {
            num1 = Double.parseDouble(leftOperand);
        } catch (NumberFormatException ex) {
            num1 = 0;
        }

        try {
            num2 = Double.parseDouble(rightOperand);
        } catch (NumberFormatException ex) {
            num2 = 0;
        }

        Calculator calculator = new Calculator(num1, num2, operator);

        String result = calculator.calculateResult();

        model.addAttribute("leftOperand", df.format(calculator.getLeftOperand()));
        model.addAttribute("operator", calculator.getOperator());
        model.addAttribute("rightOperand", df.format(calculator.getRightOperand()));
        model.addAttribute("result", result);

        return "base-layout";
    }
}
