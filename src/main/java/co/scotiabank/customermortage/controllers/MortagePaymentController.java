package co.scotiabank.customermortage.controllers;


import co.scotiabank.customermortage.models.MortagePaymentResponse;
import co.scotiabank.customermortage.models.MortagePaymentRequest;
import co.scotiabank.customermortage.services.MortagePaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/scotiabank/mortageApi/v1.0.0")
public class MortagePaymentController {

    @Autowired
    private MortagePaymentService mortagePaymentService;

    @PostMapping("/calculateMortagePaymentValue")
    public MortagePaymentResponse calculateMortagePaymentValue(@RequestBody MortagePaymentRequest request) throws Exception {
        return mortagePaymentService.calculateValue(request);
    }
}
