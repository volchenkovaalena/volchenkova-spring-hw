package volchenkova.volchenkovaspringhw.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import volchenkova.volchenkovaspringhw.service.CalculatorService;

@RestController
@RequestMapping ("/calculator")
public class CalculatorControler {
    private final CalculatorService calculatorService;

    public CalculatorControler ( CalculatorService calculatorService ) {
        this.calculatorService = calculatorService;
    }
    @GetMapping ("/plus")
    public String sumNumbers ( @RequestParam int num1, @RequestParam int num2 ){
        return String.valueOf ( calculatorService.sum(num1,num2) );
    }

    @GetMapping ("/minus")
    public String subtractNumbers ( @RequestParam int num1, @RequestParam int num2 ){
        return String.valueOf ( calculatorService.subtract (num1,num2) );
    }

    @GetMapping ("/multiply")
    public String multiplyNumbers ( @RequestParam int num1, @RequestParam int num2 ){
        return String.valueOf ( calculatorService.multiply (num1,num2) );
    }
    @GetMapping ("/divide")
    public String divideNumbers ( @RequestParam int num1, @RequestParam int num2 ){
        if (num2 == 0){
            return "На ноль делить нельзя";}
        return String.valueOf ( calculatorService.divide (num1,num2) );
    }
}
