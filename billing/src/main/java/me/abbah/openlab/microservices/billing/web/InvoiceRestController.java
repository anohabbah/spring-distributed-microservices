package me.abbah.openlab.microservices.billing.web;

import me.abbah.openlab.microservices.billing.dto.InvoiceRequestDTO;
import me.abbah.openlab.microservices.billing.dto.InvoiceResponseDTO;
import me.abbah.openlab.microservices.billing.services.InvoiceService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/invoices")
public class InvoiceRestController {
    private final InvoiceService service;

    public InvoiceRestController(InvoiceService service) {
        this.service = service;
    }

    @GetMapping(path = "")
    public List<InvoiceResponseDTO> invoices() {
        return service.getAllInvoices();
    }

    @GetMapping(path = "{invoiceId}")
    public InvoiceResponseDTO getInvoice(@PathVariable String invoiceId) {
        return service.getInvoice(invoiceId);
    }

    @GetMapping(path = "{customerId}/customer")
    public List<InvoiceResponseDTO> getCustomerInvoices(@PathVariable String customerId) {
        return service.customerInvoices(customerId);
    }

    @PostMapping(path = "")
    public InvoiceResponseDTO store(@RequestBody InvoiceRequestDTO dto) {
        return service.store(dto);
    }
}
