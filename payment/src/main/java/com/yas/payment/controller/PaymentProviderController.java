package com.yas.payment.controller;

import com.yas.payment.service.PaymentProviderService;
import com.yas.payment.viewmodel.PaymentProviderVm;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class PaymentProviderController {
    private final PaymentProviderService paymentProviderService;

    @GetMapping("/storefront/payment-providers")
    public ResponseEntity<List<PaymentProviderVm>> getPaymentProviders() {
        return ResponseEntity.ok(paymentProviderService.getEnabledPaymentProviders());
    }

    @GetMapping("/payment-providers/{id}/additional-settings")
    public ResponseEntity<String> getAdditionalSettings(@PathVariable("id") String id) {
        return ResponseEntity.ok(paymentProviderService
            .getAdditionalSettingsByPaymentProviderId(id));
    }


}